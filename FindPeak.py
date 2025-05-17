# Time complexity: O(log n), n is the number of elements in the array
# Space complexity: O(1)
# All test cases passed on Leetcode: Yes

# I have used binary search to solve this problem even though the array is not sorted
# first we will find mid, compare mid with neighbours, 
# if any of the neighbour is greater than mid, we will move towards that neighbour


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        n = len(nums) - 1
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if mid == 0 and mid == n:
                return mid

            if mid == 0 and nums[mid] > nums[mid + 1]:
                return mid

            if mid == n and nums[mid] > nums[mid - 1]:
                return mid
            
            if nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1]:
                return mid
            
            if nums[mid] < nums[mid + 1]:
                low = mid + 1
            elif nums[mid] < nums[mid - 1]:
                high = mid - 1
        
        return -1
            