class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {

        val first = binarySearchFirst(nums, target)
        val last = binarySearchLast(nums, target)

        return intArrayOf(first, last)

    }

    fun binarySearchFirst(nums: IntArray, target: Int): Int{

        var low = 0
        var high = nums.size -1
        while (low <= high){
            val mid = low + (high - low)/2

            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < target) return mid
                else {
                    high = mid -1
                }
            }
            else{
                if(nums[mid] > target){
                    high = mid -1
                }
                else{
                    low = mid +1

                }
            }

        }
        return -1

    }

    fun binarySearchLast(nums: IntArray, target: Int): Int{
        var low = 0
        var high = nums.size -1
        while (low <= high){
            val mid = low + (high - low)/2

            if(nums[mid] == target){
                if(mid == nums.size -1 || nums[mid + 1] > target) return mid
                else{
                    low = mid + 1
                }
            }
            else{
                if(nums[mid] > target){
                    high = mid -1

                }
                else{
                    low = mid +1
                }
            }

        }

        return -1
    }
}