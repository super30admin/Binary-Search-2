class Solution {
    fun findMin(nums: IntArray): Int {

        var left = 0
        var right = nums.size - 1

        while (left <= right) {

            val mid = left + (right - left) / 2
            print(mid)

            if ( ( mid == 0 || nums[mid - 1] > nums[mid]) && (mid == nums.size - 1 || nums[mid + 1] > nums[mid]))
            {return nums[mid]}

            if (nums[mid] < nums[right]) {
                right = mid -1
            } else {
                left = mid + 1
            }

        }

        return -1
    }
}

