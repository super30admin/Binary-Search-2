/**
Time Complexity - O(N) where N is the size of nums.
Space Complexity - O(1).
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        if(nums.length == 1 || nums[left] < nums[right])
            return nums[0];
        
        while(left <= right)
        {     
            int mid = (right - left) / 2 + left;
            
            if(mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            
            if(mid < nums.length - 1 && nums[mid + 1] < nums[mid])
                return nums[mid + 1];
            
            if(nums[right] >= nums[mid]) 
                //if mid is not the smallest element, 
                //then if the nums[right] is > nums[mid] we can confirm that 
                //the min element does not exist to the right of the array.
                right = mid - 1;
            else
                left = mid + 1;
            
        }
        return -1;
    }
}
