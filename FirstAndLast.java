class Solution {
    private int binarySearchFirst (int[] nums, int target){
        int low = 0, high = nums.length-1;
        while (low <= high){
            int mid = low + (high -low)/2 ;
            if(nums[mid] == target){
                if(mid ==0 || nums[mid] > nums[mid -1])
                    return mid;
                else {
                    high = mid -1;
                }
            } else if (nums[mid] > target ){
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }

    private int binarySearchLast (int[] nums, int target, int left, int high){
        int low = left;
        while (low <= high){
            int mid = low + (high -low)/2 ;
            if(nums[mid] == target){
                if(mid ==nums.length-1 || nums[mid] < nums[mid +1])
                    return mid;
                else {
                    low = mid +1;
                }
            } else if (nums[mid] > target ){
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums == null ){
            return new int [] {-1 ,-1};
        }
        int length = nums.length;
        if (nums[0] > target || nums[length - 1] < target){
            return new int [] {-1 ,-1};
        }
        int left = binarySearchFirst(nums, target);
        if (left == -1 )
            return new int [] {-1 ,-1};
        int right = binarySearchLast(nums, target, left, length-1);
        return new int [] {left ,right};
    }
}