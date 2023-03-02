# Time Complexity: O(log n)
# Space Complexity: O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        if nums[-1] >= nums[0]:
            return nums[0]

        while left <= right:
            mid = left + (right - left // 2 )

            if nums[left] < nums[mid]:
                left = mid + 1
            elif nums[left] > nums[mid]:
                if nums[mid - 1] > nums[mid]:
                    return nums[mid]
                else:
                    right = mid - 1
        
        return -1