// Time Complexity :  O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// lin 15 and 11
class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while(left < right){
            val mid = left + (right - left)/2
            // if(nums[left] < nums[right]) return nums[left]
            when{
                nums[mid] > nums[right] ->{
                    left = mid + 1
                }
                else-> {
                    right = mid
                }
            }
        }
        return nums[left]
    }
}