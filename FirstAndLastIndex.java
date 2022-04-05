// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class FirstAndLast{
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums == null || nums.length == 0) return res;
        
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                res[0] = firstOccurance(nums, target, mid);
                res[1] = lastOccurance(nums, target, mid);
                break;
            }
            else if(target < nums[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }
    
    public int firstOccurance(int[] nums, int target, int mid){
        int idx = mid;
        while(idx-1 >= 0 && nums[idx-1] == target){
            idx--;
        }
        return idx;
    }
    
    public int lastOccurance(int[] nums, int target, int mid){
        int idx = mid;
        while(idx+1 < nums.length && nums[idx+1] == target){
            idx++;
        }
        return idx;
    }
}