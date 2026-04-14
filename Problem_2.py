import math

class Solution:
    def findMin(self, nums):
        n = len(nums)
        low,high = 0, n-1
        ans = math.inf
        while low <= high:
            mid = low + (high-low)//2
            curr = nums[mid]
            if nums[low] <= curr:
                ans = min(ans,nums[low])
                low = mid + 1
            else:
                ans = min(ans,curr)
                high = mid - 1
        return ans



# nums = [3,4,5,1,2]
nums = [2,1]
sl = Solution()
print(sl.findMin(nums))