// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Took time to understand the minima and maxima.

// Perform binary search. check if middle < middle +1 if yes then peak lies to the right half of mid and perfrom binary search on that else middle could be a peak and perform binary search on left half. Perform binary search until left == right, then return left;

class Problem3 {
    public int findPeakElement(int[] nums) {
        int l =0;
        int r = nums.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid] < nums[mid+1]){
                l = mid+1;
            }else{
                r=mid;
            } 
        }
        return l;
    }
}
