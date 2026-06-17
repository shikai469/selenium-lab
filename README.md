# Kiểm Thử Tự Động Với Selenium WebDriver

## 1. Mục tiêu bài thực hành
Học và áp dụng công cụ kiểm thử tự động Selenium WebDriver để mô phỏng các thao tác của người dùng thực. Dự án thực hiện kiểm thử trên trang web thương mại điện tử demo: `https://www.saucedemo.com/`.

## 2. Môi trường và Công cụ
* **Ngôn ngữ:** Java (JDK 21)
* **Công cụ quản lý:** Maven
* **Thư viện kiểm thử:** Selenium WebDriver (v4.44.0)
* **Framework Test:** JUnit 5 (v5.10.0)
* **IDE:** Visual Studio Code

## 3. Các kịch bản kiểm thử (Test Cases)
Đã xây dựng thành công 03 kịch bản kiểm thử tự động (Automated Test Cases):

1.  **Test Case 1: Đăng nhập thành công (testLoginSuccess)**
    * *Mô tả:* Kiểm tra chức năng đăng nhập với tài khoản `standard_user`.
    * *Hành động:* Tự động điền Username, Password và click nút Login.
    * *Kỳ vọng:* Trình duyệt chuyển hướng thành công sang trang quản lý sản phẩm (`/inventory.html`).
2.  **Test Case 2: Thêm sản phẩm vào giỏ hàng (testAddToCart)**
    * *Mô tả:* Kiểm tra tính năng mua hàng của người dùng.
    * *Hành động:* Đăng nhập -> Tìm thẻ sản phẩm "Sauce Labs Backpack" -> Click nút "Add to cart".
    * *Kỳ vọng:* Biểu tượng giỏ hàng (Badge) ở góc phải màn hình cập nhật số lượng thành "1".
3.  **Test Case 3: Đăng xuất hệ thống (testLogout)**
    * *Mô tả:* Kiểm tra chức năng bảo mật/thoát phiên làm việc.
    * *Hành động:* Đăng nhập -> Mở menu Sidebar -> Chờ menu hiển thị -> Click "Logout".
    * *Kỳ vọng:* Phiên làm việc kết thúc, trình duyệt quay trở lại giao diện đăng nhập gốc.

## 4. Hướng dẫn chạy dự án
1. Mở dự án bằng Visual Studio Code (Yêu cầu cài đặt *Extension Pack for Java*).
2. Di chuyển đến file `src/test/java/com/kiemthu/SauceDemoTest.java`.
3. Nhấn vào nút `▶ Run Test` hiển thị trên đầu class hoặc từng hàm `@Test` để thực thi kịch bản.
