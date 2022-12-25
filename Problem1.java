class Solution {
    private int leftBinarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid -1]){
                    return mid;        
                }else{
                    high = mid - 1;
                }
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;    
    }

    private int rightBinarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == high || nums[mid] < nums[mid +1]){
                    return mid;        
                }else{
                    low = mid + 1;
                }
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;    
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums ==null || nums.length == 0) return new int[] {-1,-1};
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        if(nums[low] > target || nums[high] < target) return new int[] {-1,-1};
        int leftIndex = leftBinarySearch(nums, low, high, target);
        if (leftIndex == -1) return new int[] {-1,-1};
        int rightIndex = rightBinarySearch(nums, leftIndex, high, target);
        return new int[]{leftIndex, rightIndex};
    }
}