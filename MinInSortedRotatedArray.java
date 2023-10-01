// Time Complexity : O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class MinInSortedRotatedArray {
    class Solution {
        public int findMin(int[] nums) {
            int low = 0, high = nums.length-1;
            int min = Integer.MAX_VALUE;

            while(low <= high){
                int mid = low + (high - low)/2;
                min = Math.min(min, nums[mid]);

                if(min <= nums[high]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            return min;
        }
    }
}
