// Time Complexity : O(logN)
// Space Complexity : O(1) -- not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to brainstorm about the logic


// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int findMin(int[] nums) {

        int start = 0, end = nums.length - 1;
        while(start < end)
        {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[end])
            {
                end = mid;
                
            } else{
                start = mid + 1;
            }
        }
        return nums[start];
    }
}