public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // The minimum element must be in the right half
                left = mid + 1;
            } else {
                // The minimum element must be in the left half or at the mid position
                right = mid;
            }
        }

        // 'left' will be pointing to the minimum element
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int result1 = findMin(nums1);
        System.out.println("Example 1: " + result1);

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int result2 = findMin(nums2);
        System.out.println("Example 2: " + result2);
    }
}
