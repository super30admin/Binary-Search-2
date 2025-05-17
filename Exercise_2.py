# time complexity - O(log(n))
# space complexity - O(1)
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """


        low, high = 0, len(nums) - 1

        while low <= high:
            # If the subarray is already sorted
            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high - low) // 2

            # Check if mid is the minimum
            if (mid != 0 and nums[mid] < nums[mid - 1]):
                return nums[mid]

            # If left part is sorted, go right
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return -1  # should never be hit if input is a valid rotated array
    

