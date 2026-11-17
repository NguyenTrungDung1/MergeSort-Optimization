# Phân tích thuật toán: Tối ưu hóa MergeSort với CUTOFF

Dự án này thực hiện thí nghiệm đo lường và tìm kiếm giá trị `CUTOFF` tối ưu nhất để chuyển đổi giữa thuật toán **MergeSort** và **Insertion Sort** trên các mảng kích thước nhỏ.

## 📂 Thành phần dự án
- `MergeSortExperiment.java`: Mã nguồn cài đặt thuật toán và script chạy thí nghiệm đo thời gian tự động. (Dữ liệu test 1 triệu phần tử được sinh ngẫu nhiên trực tiếp trong bộ nhớ khi chạy).
- `Bao_Cao_Thi_Nghiem.pdf`: Báo cáo chi tiết, bảng số liệu và phân tích đồ thị kết quả.
- `Professional_AI_Chat_Log.docx`: Nhật ký tham vấn AI về thiết kế thí nghiệm và phân tích học thuật.

## 🚀 Kết quả tóm tắt
Qua quá trình chạy thử nghiệm lặp 10 lần trên mảng 1 triệu phần tử, đồ thị thời gian thực thi có dạng hình Parabol ngửa (U-curve). Giá trị CUTOFF mang lại hiệu năng tốt nhất trên môi trường thử nghiệm (Java, Windows 11) rơi vào khoảng **12 đến 15**.

## 🛠 Cách chạy thử nghiệm
1. Cài đặt Java Development Kit (JDK).
2. Biên dịch file: `javac MergeSortExperiment.java`
3. Chạy script: `java MergeSortExperiment`
