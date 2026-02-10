// Time Complexity : O(log n)
// Space Complexity : O(1) as we are using constant space to store the indices
class Solution {
    fun findMin(nums: IntArray): Int {

        var low = 0
        var high = nums.size - 1

        while (low <= high) {

            val mid = low + (high - low) / 2

            if ((mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.size - 1 || nums[mid + 1] > nums[mid])) {
                return nums[mid]
            } else {
                if (nums[mid] < nums[high]) {
                    high = mid - 1
                } else {
                    low = mid + 1
                }
            }
        }
        return -1
    }
}