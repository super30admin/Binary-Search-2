class Solution {
    public int[] searchRange(int[] nums, int target) {
        //initial check
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1};
        
        int first = first(nums, 0, nums.length - 1, target, nums.length);
        
        int last = last(nums, 0, nums.length - 1, target, nums.length);
        
        return new int[]{first, last};
        
    }
    
    public int first(int[] nums, int low, int high, int target, int n){     
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(target == nums[mid] && (mid == 0 || target > nums[mid-1])) 
                return mid;
            else if(target > nums[mid])
                return first(nums, mid+1, high, target, n);
            else
                return first(nums, low, mid-1, target, n);
            
        }
        return -1;
    }
    
    public int last(int[] nums, int low, int high, int target, int n){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(target == nums[mid] && (mid == n-1 || target < nums[mid+1]))
                return mid;
            else if(target < nums[mid])
                return last(nums, low, mid-1, target, n);
            else
                return last(nums, mid+1, high, target, n);            
        }
        return -1;
    
    }
}