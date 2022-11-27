
// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : The technique of finding the right increasing element was hard


// Your code here along with comments explaining your approach


/*
Its not a sorted array, however we can use some technique to find out which direction to go
We will find mid element as we do, if mid < mid+1, then there is high probabality that peak is on mid+1 , as it already meet the half of the condition, so we go right
else we go left
*/
class Solution {
    public int findPeakElement(int[] nums) {

        int low =0, high = nums.length-1;
        int mid=0;

        while(low<=high){
            mid = low + (high - low)/2;

            if(isPeak(mid,nums)){
                return mid;
            }
            // check right side
            if(mid<nums.length && nums[mid] < nums[mid+1]){
                // go right
                low = mid+1;
            }
            else{ // go left
            high = mid -1;
            }
        }
        return Integer.MIN_VALUE; // we will never reach there
    }


    private boolean isPeak(int index, int[] nums){
        boolean isLeftSmaller = index ==0 ? true : nums[index-1] < nums[index] ;
        boolean isRightSmaller = index == nums.length-1 ? true : nums[index+1] < nums[index];
        return isLeftSmaller && isRightSmaller;

    }
}