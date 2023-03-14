class Solution {
    public int binaryone(int[] nums, int low, int high, int target)
    {
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if( mid == low ||  nums[mid - 1] < nums[mid]) return mid;
                else high = mid - 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else low = mid + 1; 
        }
        return -1; 
    }
    public int binarytwo(int[] nums, int low, int high, int target)
    {
        while (low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid + 1] > target) return mid;
                else low = mid + 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else low = mid + 1; 
        }
        return -1; 
    }
    public int[] searchRange(int[] nums, int target) {
        int left = binaryone(nums, 0, nums.length - 1, target);
        int right = binarytwo(nums, 0, nums.length - 1, target);
        return new int[] {left,right};
    }
}