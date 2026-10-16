BÁO CÁO BÀI TẬP NÂNG CAO - LAB A8
1. NC1 – Bố cục Master–Detail cho Tablet / Màn hình lớn (sw >= 600dp)
   Mục tiêu: Tối ưu hóa giao diện ứng dụng khi chạy trên thiết bị màn hình lớn (máy tính bảng, điện thoại xoay ngang).
   Cách thực hiện:Tạo cấu trúc giao diện 2 cột trong thư mục tài nguyên res/layout-sw600dp/activity_main.xml.
       Cột trái (fragmentContainer) hiển thị danh sách tin tức;
       Cột phải (detailContainer) hiển thị nội dung chi tiết.
       Trong NewsListFragment, kiểm tra sự tồn tại của detailContainer.Nếu có, Fragment chi tiết sẽ nạp trực tiếp vào cột bên phải thay vì đè lên danh sách.
2. NC4 – Hiệu ứng chuyển cảnh Fragment (Custom Animations)
   Mục tiêu: Nâng cao trải nghiệm người dùng (UX) bằng các hiệu ứng chuyển màn hình mượt mà.
   Cách thực hiện: Sử dụng .setCustomAnimations() trong giao dịch FragmentTransaction:Chuyển Tab (MainActivity): Áp dụng hiệu ứng mờ dần (fade_in / fade_out) khi điều hướng giữa các tab Trang chủ, Tin tức và Cá nhân.
      Mở Chi tiết Tin (NewsListFragment): Áp dụng hiệu ứng trượt ngang (slide_in_left / slide_out_right) khi mở nội dung bài viết và khi nhấn nút Back quay lại.
