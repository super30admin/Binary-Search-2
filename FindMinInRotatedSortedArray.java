// Time complexity : O(logn)
// Space complexity : O(1)
public class FindMinInRotatedSortedArray {
    public static int findMin(int[] nums) {

        int n = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // if array is sorted
            if (nums[low] <= nums[high])
                return nums[low];

            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int result = findMin(arr);
        System.out.println(result);
    }

}
