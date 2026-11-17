
import java.util.Arrays;
import java.util.Random;

public class MergeSortExperiment {

    // --- 1. CÀI ĐẶT THUẬT TOÁN ---

    // Hàm Insertion Sort cho các mảng con nhỏ
    public static void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= lo && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Hàm Trộn (Merge)
    private static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
        // Copy mảng sang mảng phụ
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              arr[k] = aux[j++];
            else if (j > hi)               arr[k] = aux[i++];
            else if (aux[j] < aux[i])      arr[k] = aux[j++];
            else                           arr[k] = aux[i++];
        }
    }

    // Hàm đệ quy MergeSort có dùng CUTOFF
    private static void sort(int[] arr, int[] aux, int lo, int hi, int cutoff) {
        // Cải tiến: Dùng Insertion Sort nếu độ dài mảng <= CUTOFF
        if (hi - lo <= cutoff) {
            insertionSort(arr, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(arr, aux, lo, mid, cutoff);
        sort(arr, aux, mid + 1, hi, cutoff);
        merge(arr, aux, lo, mid, hi);
    }

    // Hàm gọi public
    public static void sort(int[] arr, int cutoff) {
        int[] aux = new int[arr.length];
        sort(arr, aux, 0, arr.length - 1, cutoff);
    }

    // --- 2. TẠO DỮ LIỆU THÍ NGHIỆM ---

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    // --- 3. SCRIPT CHẠY THÍ NGHIỆM ---

    public static void main(String[] args) {
        int arraySize = 1_000_000; // Mảng 1 triệu phần tử
        int numTrials = 10;        // Số lần lặp cho mỗi CUTOFF để lấy trung bình
        int maxCutoff = 30;        // Thử nghiệm CUTOFF từ 0 đến 30

        System.out.println("Bắt đầu thí nghiệm tìm CUTOFF tối ưu cho MergeSort...");
        System.out.println("Kích thước mảng: " + arraySize);
        System.out.println("Số lần lặp mỗi CUTOFF: " + numTrials);
        System.out.printf("%-10s | %-20s\n", "CUTOFF", "Thời gian TB (ms)");
        System.out.println("----------------------------------");

        for (int cutoff = 0; cutoff <= maxCutoff; cutoff++) {
            long totalTimeNs = 0;

            for (int t = 0; t < numTrials; t++) {
                // Tạo dữ liệu test mới cho mỗi lần lặp
                int[] data = generateRandomArray(arraySize);

                // Đo thời gian
                long startTime = System.nanoTime();
                sort(data, cutoff);
                long endTime = System.nanoTime();

                totalTimeNs += (endTime - startTime);
            }

            // Tính thời gian trung bình ra milliseconds
            double avgTimeMs = (totalTimeNs / (double) numTrials) / 1_000_000.0;
            System.out.printf("%-10d | %-20.3f\n", cutoff, avgTimeMs);
        }
    }
}
