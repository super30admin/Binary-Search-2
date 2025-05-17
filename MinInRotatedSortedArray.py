# Time complexity: O(log n), n is the number of elements in the array
# Space complexity: O(1)
# All test cases passed on Leetcode: Yes

# I have used the below two properties of rotated sorted arrays using binary search to solve this problem
# At least one of the sub array is sorted and 
# the minimum element will be on the other part of sub array which is not sorted

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        n = len(nums) - 1
        high = n

        while low <= high:
            mid = low + (high - low) // 2

             # if the array is already sorted, return zeroth element
            if nums[low] <= nums[high]:
                return nums[low]  

            if mid !=0 and nums[mid] < nums[mid - 1] and mid != n and nums[mid] < nums[mid + 1]:
                return nums[mid]

            # find if the left array is sorted
            # if the left array is sorted, min will be on right side
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1


            
            
