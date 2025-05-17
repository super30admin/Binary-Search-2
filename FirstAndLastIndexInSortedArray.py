# Time complexity: O(log n), n is the number of elements in the array
# Space complexity: O(1)
# All test cases passed on Leetcode: Yes

# I have used two binary searches one for finding the first index and another for finding last index

class Solution(object):

    def binarySearchFirst(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                if mid != 0 and nums[mid - 1] == nums[mid]:
                    high = mid - 1
                else:
                    return mid

            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1
    
    def binarySearchLast(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                if mid != len(nums) - 1 and nums[mid + 1] == nums[mid]:
                    low = mid + 1
                else:
                    return mid

            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        first_index = -1
        last_index = -1

        if not nums or len(nums) == 0:
            return [first_index, last_index]
        
        first_index = self.binarySearchFirst(nums, 0, len(nums) - 1, target)

        if first_index != -1:
            last_index = self.binarySearchLast(nums, first_index, len(nums) - 1, target)


        return [first_index, last_index]
        
