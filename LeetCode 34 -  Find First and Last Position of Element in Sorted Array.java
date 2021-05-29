class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[]{-1, -1};
        if(nums == null || nums.length == 0) return res;
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }
    public int findLeft(int[] nums, int target){
        int idx = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            // find the leftmost index
            if(nums[mid] >= target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            // update the index of target
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
    public int findRight(int[] nums, int target){
        int idx = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            // find the rightmost index
            if(nums[mid] <= target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            // update the index of target
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}