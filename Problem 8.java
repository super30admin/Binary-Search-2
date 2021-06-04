// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : explained nicely in lecture, but not sure if I will fully remember it

class Solution {
    
    //finding first value
    public int first(int[] nums, int low, int high, int target) {
        
        while(low<=high){
            int mid = low + (high - low)/2;         
            if(nums[mid] == target){
                if(mid == low ||  nums[mid - 1] < nums[mid]) {//checking if this the first occurance
                    return mid;
                }else {
                    high = mid - 1;//if not, change search space to be on the left side of mid
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; 
    }
    
    public int last(int[] nums, int low, int high, int target){
        
        while(low<=high){
            int mid = low + (high - low)/2;         
            if(nums[mid] == target){
                if( mid == low ||  nums[mid + 1] > nums[mid]) {//check if this the last occurance 
                    return mid;
                }else {
                    low = low + 1;//if not, change search space to be on the right side of mid
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1; 
            }
        }
        return -1; 
    }
    
    public int[] searchRange(int[] nums, int target){
        int left = first(nums, 0, nums.length - 1, target);
        int right = last(nums, 0, nums.length - 1, target);
        return new int[] {left, right};
        
    }
                
}
