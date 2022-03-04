// Time Complexity : O(3logn) -> O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : A lot 


// Your code here along with comments explaining your approach
class SolutionFistLast {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        int[] result = new int[2];
        int start = -1;
        int end = -1;
        int idx = -1;
        
        result[0] = -1;
        result[1] = -1;
        
        if(nums.length==0){
            return result;
        }
        
      
        //BS to find target index
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid]==target){
                idx = mid;
                left = right+1;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        
        if(idx==-1){
            return result;
        }
        
        int midTemp = idx;
        
        left = 0;
        right = midTemp;
        
        // BS on left half of above found index to find until the left element is no longer target
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid]==target){
                if(mid-1>=0 && nums[mid-1]==target){
                    right = mid - 1; 
                }else{
                    result[0]=mid;
                    left=right+1;                    
                }
            }else if(nums[mid]<target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        
        left = midTemp;
        right = nums.length;        
        
        // BS on left half of above found index to find until the right element is no longer target
        while(left<=right){
            mid = left + (right-left)/2;
            if(nums[mid]==target){
                if(mid+1<nums.length && nums[mid+1]==target){
                    left = mid + 1;
                }else{
                    result[1]=mid;
                    left=right+1;                    
                }
            }else if(nums[mid]<target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }        
        
        return result;
    }
}
