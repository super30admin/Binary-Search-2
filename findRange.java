// Time Complexity : O(Log N)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/*
 * Finding the initial index using binary search and then finding in the right part of the array the last index again using binary search
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] output = new int[2];
        output[0] = searchInitialIndex(nums, target);
        if(output[0] == -1){
            output[1] = -1; 
            return output;
        }
        output[1] = searchLastIndex(nums, target, output[0], nums.length - 1);
        return output;
    }
    public int searchInitialIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while(low <=high){
            mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid !=0 && nums[mid -1] == target){
                    high = mid - 1;
                }
                else {
                    return mid;
                }
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1 ;
    }

    public int searchLastIndex(int[] nums, int target, int low, int high){
        int mid;
        while(low <=high){
            mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid !=high && nums[mid + 1] == target){
                    low = mid + 1;
                }
                else {
                    return mid;
                }
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1 ;
    }
}