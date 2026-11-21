// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Took time to understand the minima and maxima.

//Perform binary search twice, first to find the first occurrence of the target and then to find the last occurrence. Whenever the target is found, store its index and keep searching on the left for the first occurrence and on the right for the last occurrence. If the target is not found, return -1 for that position, otherwise return the first and last indices.

class Problem1 {
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
