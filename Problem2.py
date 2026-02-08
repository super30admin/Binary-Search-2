# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

# This problem is about finding the minimum element in a rotated sorted array. By applying the binary search approach, this solution runs in O(log n) time complexity. The binary search approach eliminates the half of the array by trying to find sorted part in the array. The exit condition is when both the neighbors of mid element are greater then the mid itself. 
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            #return the first element if the array is not rotated
            if nums[low] <= nums[high]:
                return nums[low]
            if (mid == low or nums[mid] < nums[mid - 1]) and (mid == high or nums[mid] < nums[mid + 1]):
                return nums[mid]
            if nums[mid] >= nums[low]: #left sorted
                low = mid + 1
            else:
                high = mid - 1 #right sorted
        
        return -1