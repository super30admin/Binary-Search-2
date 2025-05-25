

/**

 * 1. Use binary search to find the minimum in a rotated sorted array.
 * 2. If nums[mid] < nums[high], minimum must be in left half (including mid).
 * 3. Else, minimum lies in right half (excluding mid).
 */

class FindMinimumINRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[high])
                high = mid;
            else
                low = mid + 1;
        }

        return nums[low];
    }

    public static void main(String[] args) {
        FindMinimumINRotatedSortedArray sol = new FindMinimumINRotatedSortedArray();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Minimum in nums1: " + sol.findMin(nums1)); // Expected: 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum in nums2: " + sol.findMin(nums2)); // Expected: 0

    }
}
