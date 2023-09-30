//time complexity-O(logn)
//space complexity-O(1)
//passed all the test cases on leetcode
//the approach is to find on which side of the mid is greater because that side has peak element for sure as the adjacent elements can not be same ,so if the right element is greater then there is a 100% possibility of having a peak element on that side.
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid + 1 == n || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid + 1 == n || nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}
