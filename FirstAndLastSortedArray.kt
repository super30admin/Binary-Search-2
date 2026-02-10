//time complexity: O(log n)
//space complexity: O(1) as we are using constant space to store the indices
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val firstPosition = binarySearch1(nums, target)
        val lastPosition = binarySearch2(target, nums)
        return intArrayOf(firstPosition, lastPosition)


    }

    fun binarySearch1(nums: IntArray, target: Int): Int{
        var low = 0
        var high = nums.size -1

        while(low <= high){
            val mid = low + (high - low)/2

            if(nums[mid]== target){
                if(mid == 0 || nums[mid-1]< target) return mid
                else {
                    high = mid - 1
                }

            }else {
                if(nums[mid] >= target){
                    high = mid -1
                } else {
                    low = mid +1
                }
            }

        }

        return -1
    }

    fun binarySearch2(target: Int, nums: IntArray) : Int {

        var low = 0
        var high = nums.size - 1

        while(low <= high){
            val mid = low + (high - low)/2

            if(nums[mid] == target){
                if(mid == nums.size -1 || nums[mid+1] > target) return mid
                else { low = mid + 1}
            }else {
                if(nums[mid]<= target){
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }

        }
        return -1
    }
}