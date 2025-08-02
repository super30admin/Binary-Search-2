// Time Complexity :  O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// lin 11 and line 17
class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) return 0
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2

            // if(mid + 1 <= right && mid - 1 >= 0 && nums[mid + 1] < nums[mid] && nums[mid] > nums[mid - 1]){
            //     return mid
            // }
            if (mid + 1 <= right && nums[mid] < nums[mid + 1]) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
