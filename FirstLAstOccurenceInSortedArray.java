// Time Complexity : O(log n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No. The approach of finding the first occurence by performing binary search and finding
// the second occurence by performing binary search again from first occurence point helped in solving this problem.

// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = binarySearchFirst(0, nums.length-1, target, nums);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = binarySearchLast(first, nums.length-1, target, nums);
        return new int[]{first, last};
    }


    int binarySearchFirst(int low, int high, int target, int[] nums){
        int mid = 0;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid] < target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }

    int binarySearchLast(int low, int high, int target, int[] nums){
        int mid = 0;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] != target){
                    return mid;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid] < target){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }
}