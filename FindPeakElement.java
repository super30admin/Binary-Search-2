class Solution {

    /*
        Time Complexity : O(log n)
        Space complexity : O(1)

        Solution : To find the peak element in the array in O(log n) time, we use binary search
        to find the mid of the array. We compare the mid with i - 1 and i + 1 index and compare values.
        If value at mid is greater than both, then we have found a peak element index. Else we search in 
        the part of array where the value is greater than mid element.
    */

    public int findPeakElement(int[] nums) {
        int n = nums.length - 1;
        int low = 0;
        int high = n;
        if (nums.length == 1) {
            return 0;
        }

        while (low <= high) {
            int mid = low + (high - low)/2;
            if ((mid == 0 || (nums[mid] > nums[mid - 1])) && (mid == n || (nums[mid] > nums[mid + 1]))) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}