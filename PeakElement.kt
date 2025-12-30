//Time Complexity: O(log n)
//Space Complexity: O(1)
// In this problem, we run binary search to find the peak element, peak element is the one which is always or most likely going to be on the greater side of the array. 
class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if(nums.size == 1) {
            return 0
        }
        val n = nums.size
        var l = 0
        var h = n - 1
        while(l <= h) {
           val mid = l + (h - l)/2
           
           val greaterThanPrevElement = if(mid == 0) true else nums[mid]> nums[mid - 1]
           val greaterThanNextElement = if(mid == n - 1) true else nums[mid] > nums[mid + 1]
        
           if(greaterThanPrevElement && greaterThanNextElement) {
            return mid
           } else if(greaterThanPrevElement) {
                   l = mid + 1 
           } else {
            h = mid - 1
           }
        } 
        return 99999999
    }
}