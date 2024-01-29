// Time Complexity : O(log n) ; O(log n) each for finding starting and end index = 2log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : rewatched videos to understand better

// Your code here along with comments explaining your approach

class Solution {

    // to find starting index
    private int firstBinarySearch(int lo, int hi, int[] nums, int target){
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(nums[mid] == target){
                if(mid == 0 || nums[mid] != nums[mid-1]){
                    return mid;
                }
                else{
                    hi = mid -1;
                }
            }
            else if(target < nums[mid]){ 
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }

        return -1;
    }

    // to find the end index
    private int secondBinarySearch(int lo, int hi, int[] nums,int target){
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            if(nums[mid] == target){
                if(mid == hi || nums[mid] != nums[mid+1]){
                    return mid;
                }
                else{
                   lo = mid + 1;
                }
            }
            else if(target < nums[mid]){ 
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        //target is not in range
        if(nums.length == 0 || target < nums[lo] || target > nums[hi]){
            return new int[]{-1,-1};
        }



        int fi = firstBinarySearch(lo,hi,nums,target);

        if(fi == -1){
            return new int[]{-1,-1};
        }


        int si = secondBinarySearch(fi,hi,nums,target);

        return new int[]{fi,si};
    }

}