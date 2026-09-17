
// Time Complexity :log (n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//Main Idea: Move towards the higher element side so you will find altleast one peak.
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //check if mid is peak element
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid == nums.length - 1 || nums[mid + 1] > nums[mid]) {
                //move towards right side if the mid+1 element is greater than mid
                left = mid + 1;

            } else if (mid == 0 || nums[mid - 1] > nums[mid]) {
                //move towards left side if the mid-1 element is greater than mid
                right = mid - 1;
            }

        }
        return -1;

    }
}