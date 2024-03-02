/**
Time Complexity O(log n)
Space Complexity O(1)
Runs successfully on Leetcode
*/


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int n = nums.length;
        int first = binarySearchForFirstOccurance(nums,0,n-1,target);
        if(first == -1){
            return new int[] {-1,-1};
        }
        int last = binarySearchForLastOccurance(nums,first, n-1, target);
        return new int[] {first,last};
    }
    private int binarySearchForFirstOccurance(int[] nums, int low, int high, int target ){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid -1;
                }
            }else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchForLastOccurance(int[] nums, int low, int high, int target ){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                //check if mid is the last occurance
                if(mid == nums.length-1 || nums[mid] < nums[mid+1]){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
      
}