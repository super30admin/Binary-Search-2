class Solution {

/*Time Complexity : O(logn);
 * Space Complexity : O(1);
 * 
 * Executed in leetcode;
 */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length ==0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if ((mid == nums.length - 1 || nums[mid] > nums[mid + 1]) && (mid == 0 || nums[mid] > nums[mid -1])){
                return mid;
            }else if (mid != 0 && nums[mid - 1] > nums[mid]){
                high = mid -1;
            }else{
                low = mid + 1;
            }

        }
        return 899;
    }
}
