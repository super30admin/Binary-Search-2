// Time Complexity :O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1, -1};

        int start = getFirst(nums,target);
        if(start == -1){
            return result;
        }else{
            result[0] = start;
            result[1] = getLast(nums,target,start,nums.length-1);
        }

        return result;
    }

    public int getFirst(int[] nums, int target) {

        int low = 0;
        int high = nums.length -1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                // find first element
                if (mid == low || nums[mid - 1] < target) {
                    // this is the first element
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int getLast(int[] nums, int target, int low, int high){
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                // search if this is last
                if (mid == high || nums[mid + 1] > target) {
                    // this is the last element
                    return mid;
                } else {
                    low = mid + 1;
                }

            }else if(nums[mid] >  target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}