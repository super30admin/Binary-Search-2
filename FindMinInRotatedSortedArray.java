//Time Complexity - O(logn)
//Space Complexity - O(1)
//Did it run on leetcode - Yes

//Approach - Minimum in an unsorted array lies in the unsorted side of a rotated sorted array. So Applying Binary Search by eliminating the sorted side yields the minimum.

public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid - 1] > nums[mid])
                    && (mid == nums.length - 1 || nums[mid + 1] > nums[mid])) {
                return mid;
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }

}
