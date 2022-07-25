class Solution {
    fun findPeakElement(nums: IntArray): Int {

        var low = 0
        var high = nums.size -1

        while(low <= high){

            val mid = low + (high - low) / 2

            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.size -1 || nums[mid+1] < nums[mid])) return mid

            if(nums[mid+1] > nums[mid]){
                low = mid +1
            }
            else{
                high = mid -1
            }


        }

        return 0

    }
}