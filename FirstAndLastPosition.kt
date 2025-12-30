//Time Complexity: O(log n)
//Space Complexity: O(1)
// In this problem, we run binary search twice to find the first and last position. First pass finds the start position and second pass finds the end position.

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val start = searchRangeHelper(nums, target)
        
        if(start == -1) {
            return intArrayOf(-1, -1)
        }

        val end = searchRangeHelper(nums, target, false)

        return intArrayOf(start, end)
    }

    fun searchRangeHelper(nums: IntArray, target: Int, start: Boolean = true) : Int {
        val n = nums.size
        var low = 0
        var high = n-1

        var res = if(start) Int.MAX_VALUE else Int.MIN_VALUE

        while(low <= high) {
            val mid = low + (high - low) / 2

            if(nums[mid] == target) {
                res = if(start) {
                    high = mid - 1
                    minOf(res, mid) 
                } else {
                    low = mid + 1
                    maxOf(res,mid)
                }
            } else if(target < nums[mid] ) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        return if(res == Int.MAX_VALUE || res == Int.MIN_VALUE) -1 else res
    } 
}