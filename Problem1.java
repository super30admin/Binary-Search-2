// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int n = nums.length;
        int first = firstBinarySearch(nums, target, 0, n-1);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int second = secondBinarySearch(nums, target, first, n-1);
        return new int[]{first,second};

    }
    public int firstBinarySearch(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid - 1]){
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int secondBinarySearch(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid] < nums[mid + 1]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

}