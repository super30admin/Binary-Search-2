// Time Complexity : log n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// The entire array's mid is calculated as per binary search till the match for the key is found. So, basically for finding the first occurance
// binary search is conducted to the left of the position at which key is found(till element less than the key is reached). Then the index of first
// occurance is used as starting index and the entire array to the right of this index is explored for the last occurance using binary search.


class Solution {
    public int[] searchRange(int[] nums, int target) {
        // checking null conditons
        if(nums==null || nums.length==0) return new int[]{-1, -1};

        int n = nums.length;
        if(nums[0]>target || nums[n-1]<target){
            return new int[]{-1, -1};
        }

        int first = binarySearchFirst(nums, target);
        if(first==-1) return new int[]{-1,-1};

        int last = binarySearchLast(nums, first, n-1, target);

        return new int[]{first,last};
    }

    private int binarySearchFirst(int[] nums, int target){
        int low=0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid]==target){
                if(mid==0|| nums[mid]>nums[mid-1]){
                    return mid;
                } else { // keep moving left
                    high = mid-1;
                }
            } else if(nums[mid]>target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid]<nums[mid+1]){
                    return mid;
                } else { // keep moving right
                    low = mid+1;
                }
            } else if(nums[mid]>target){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
         return -1;
    }
}