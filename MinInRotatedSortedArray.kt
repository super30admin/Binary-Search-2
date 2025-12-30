//Time Complexity: O(log n)
//Space Complexity: O(1)
// In this problem, we run binary search to find the min element in rotated sorted array. we check if the mid element is less than its previous and next element. If yes, we return mid element as min. If not, we check if left part is sorted or right part is sorted. If left part is sorted, we move to right part else we move to left part. 
// else if left part is sorted, we move to right part else we move to left part. 
class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var h = nums.size - 1

        while (l <= h) {
            if (nums[l] <= nums[h]) {
                return nums[l]
            }
            val mid = l + (h - l)/2
            if ((mid != 0 && nums[mid] < nums[mid - 1]) && nums[mid] < nums[mid + 1]) {
                return nums[mid]
            }
            else if (nums[l]<= nums[mid]) {
                l = mid + 1
            }
            else {
                h = mid - 1
            }
        }
        return -1 
    }
}