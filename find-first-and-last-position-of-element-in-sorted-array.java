// Time Complexity : o(nlogn)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

//Performed Binary search for the left most index at first 
//checked if the array has atleast one element otherwise returning {-1,-1}
//if exist performing the binary search for the right most index of the target
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        // base case
        if (nums.length == 0 || nums == null)
            return ans;
        int l = 0; // left index
        int r = nums.length; // right index
        // finding the left
        while (l < r) {
            int mid = l + (r - l) / 2;
            // matches
            if (target == nums[mid]) {
                ans[0] = r = mid;
                continue;
            }
            if (target < nums[mid])
                r = mid;
            else
                l = mid + 1;

        }
        if (ans[0] == -1)
            return ans;
        l = ans[0];
        r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // match case
            if (target == nums[mid]) {
                ans[1] = mid;
                l = mid + 1;
                continue;
            }
            if (target < nums[mid])
                r = mid;
            else
                l = mid + 1;
        }
        return ans;
    }
}