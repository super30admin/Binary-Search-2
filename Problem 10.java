// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : explained nicely in lecture, but not sure if I will fully remember it

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            
            if (nums[low] < nums[high]) return nums[low]; //its already sorted
            int mid = low + (high-low)/2;            
            if((mid == 0 || nums[mid] < nums[mid - 1]) &&  nums[mid] < nums[mid + 1]){//condition if mid is the rotating point aka pivot
                return mid;
            }else if(nums[mid] < nums[high]){//pivot is before the middle point so right side is sorted
                high = mid - 1;
            }else{//pivot is after the middle point so left side is sorted
                low = mid + 1;
            }
        }
        
        return nums[low];        
    }
}