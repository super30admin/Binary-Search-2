// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

// As the array is sorted and rotated, the minimum will be around the rotation point. Use binary search and compare the middle element with the rightmost element to find which half contains the minimum. Keep searching in that half until l == r and return nums[l] as it is the minimum.
class Problem2 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        if(nums[l]<nums[r]){
            return nums[l];
        }
        while(l<r){
           int mid = l + (r-l)/2;
           if(nums[mid] > nums[r]){
             l = mid+1;
           }else{
            r = mid;
           }


        }
        return nums[l];
    }
}
