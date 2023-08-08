//Tc= logn
//Sc= 0(1)
public class MinInRotatedSortedArr {

    public static void main(String[] args) {

        int[] arr = {9,1,2,4,5,6,7};

        MinInRotatedSortedArr obj1 = new MinInRotatedSortedArr();

        int obj2 = obj1.search(arr);

        System.out.println("min number is" + obj2);

    }

    private int search(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (nums[low] == nums[high]) {
                return nums[low];
            }
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }

}