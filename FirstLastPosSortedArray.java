import java.util.Arrays;

class FirstLastPosSortedArray {
    static int lowGlobal;
    public static int binarySearchFirst(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                if(mid == 0 || arr[mid] > arr[mid -1]){
                    return mid;
                } else {
                    end = mid -1;
                }
              
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchLast(int[] arr, int target) {
        int start = lowGlobal;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                if(mid == arr.length - 1 || arr[mid] < arr[mid +1]){
                    return mid;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int[] searchRange(int[] arr, int target) {
        if (arr == null || arr.length <= 0) return new int[] { -1, -1 };
        if(arr[0] > target || arr[arr.length -1] < target) return new int[] { -1, -1 };

        int firstElement = binarySearchFirst(arr, target);
        lowGlobal = firstElement;
        if(firstElement == -1) return new int[] { -1, -1 };
        int lastElement = binarySearchLast( arr, target);

        return new int[] { firstElement, lastElement };
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2 };
        int target = 2;
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
}