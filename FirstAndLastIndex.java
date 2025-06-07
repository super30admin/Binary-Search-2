class Solution {
    private int binarySearchFirst(int [] nums, int low, int high, int target){
        while(low <= high){
            int mid = low +(high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid -1]){
                    return mid;
                } else {
                    // keep moving left , reject the right half
                    high = mid - 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    private int binarySearchLast(int [] nums, int low, int high, int target){
        while(low <= high){
            int mid = low +(high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid + 1]){
                    return mid;
                } else {
                    // keep moving right , reject the right half
                    low = mid + 1;
                }
            } else if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        // null check
        if(nums == null || nums.length == 0) return new int [] {-1, -1};
        int n = nums.length;
        if(target < nums[0] || target > nums[n-1]) return new int []{-1, -1};
        int firstIdx = binarySearchFirst(nums, 0, n - 1, target);
        if(firstIdx == -1) return new int [] {-1, -1};
        int lastIdx = binarySearchLast(nums, firstIdx, n - 1, target);
        return new int[] {firstIdx,lastIdx };

    }
}