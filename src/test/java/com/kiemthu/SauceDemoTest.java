package com.kiemthu; 

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SauceDemoTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver(); 
        driver.manage().window().maximize();
    }

    // ==========================================
    // TEST CASE 1: ĐĂNG NHẬP
    // ==========================================
    @Test
    public void testLoginSuccess() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        Thread.sleep(1000); // Dừng 1 giây cho bạn kịp nhìn
        
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains("inventory.html"), "Đăng nhập thất bại!");
    }

    // ==========================================
    // TEST CASE 2: THÊM SẢN PHẨM VÀO GIỎ HÀNG
    // ==========================================
    @Test
    public void testAddToCart() throws InterruptedException {
        // Bước 1: Phải đăng nhập thì mới vào được trang mua hàng
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000); 

        // Bước 2: Tìm nút "Add to cart" của sản phẩm Balo và click
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(1000); 

        // Bước 3: Tìm cái icon giỏ hàng ở góc phải trên cùng và kiểm tra xem có số "1" chưa
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        assertEquals("1", cartBadge.getText(), "Giỏ hàng không hiển thị đúng số lượng!");
    }

    // ==========================================
    // TEST CASE 3: ĐĂNG XUẤT
    // ==========================================
    @Test
    public void testLogout() throws InterruptedException {
        // Bước 1: Đăng nhập vào trong
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(1000); 

        // Bước 2: Tìm nút Menu 3 gạch ở góc trái trên cùng và click
        driver.findElement(By.id("react-burger-menu-btn")).click();
        
        // Phải đợi 1 giây cho cái thanh menu nó trượt từ trái sang phải xong thì mới bấm tiếp được
        Thread.sleep(1000); 

        // Bước 3: Tìm nút Logout và click
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(1000); 

        // Bước 4: Kiểm tra xem đã văng ra ngoài trang Login chưa
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.equals("https://www.saucedemo.com/"), "Đăng xuất thất bại!");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }
    }
}