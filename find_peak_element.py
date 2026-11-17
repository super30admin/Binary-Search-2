#Time complexity: O(logn)
#space complexity: O(1)

#finding a peak element: A peak element is an element in the array whose value is greater than both of its neighbors.
#basically its same as finding a minimum element in rotated sorted array.
#just that we are finding the element here whose value is greater than the neighbors.

class Solution:
    def findPeakElement(self, nums):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = (low + high) // 2
            if ((mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):
                return mid
            elif nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1