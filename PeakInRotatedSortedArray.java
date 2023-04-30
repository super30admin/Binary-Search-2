/* Time Complexity - O(Log N) where N is the size of input. Space Complexity - O(1).
*/
class Solution {
    public int findMin(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1 || nums[0] < nums[nums.length - 1])
            return nums[0];
        
        int left = 0, right = nums.length - 1;

        while(left <= right){

            int mid = left + (right - left);

            if(mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            if(mid < nums.length - 1 && nums[mid + 1] < nums[mid])
                return nums[mid + 1];
            
            if(nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums[0];
    }
}
