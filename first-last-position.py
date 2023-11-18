# Time Complexity is O(log n) and Space Complexity is O(1)

class Solution:
    # Binary search helper function. leftSide can be True/False. If False, look towards right side and vice versa. 
    def binarySearch(self, nums, target, leftSide):
        left, right = 0, len(nums) - 1
        index = -1
        while left <= right:
            middle = left + (right - left) // 2
            if target > nums[middle]:
                left = middle + 1
            elif target < nums[middle]:
                right = middle - 1
            else:
                index = middle                       
                if leftSide:                # If searching to left side
                    right = middle - 1
                else:                       # If searching to right side
                    left = middle + 1   
        return index

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = self.binarySearch(nums, target, True)        # To find left most target index.
        right = self.binarySearch(nums, target, False)      # To find right most target index.
        return [left, right]