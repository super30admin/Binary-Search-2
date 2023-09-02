class Solution:
    def findMin(self, nums):
        left, right = 0, len(nums) - 1
    
        while left < right:
            mid = (left + right) // 2
            if nums[mid] < nums[right]:
                right = mid
            elif nums[mid] > nums[right]:
                left = mid + 1
            else:
                right -= 1
    
        return nums[left]

# Usage example
param_1 = [4, 5, 6, 7, 0, 1, 2]
result = Solution().findMin(param_1)
print(result)