class Solution:
    def findPeakElement(self, nums):
        n = len(nums)
        low,high  = 0, n-1
        while low <= high:
            mid = low + (high - low)//2
            curr = nums[mid]
            if (mid == 0 or nums[mid-1] < curr) and (mid == n-1 or nums[mid+1] < curr):
                return mid
            if nums[mid-1] < curr:
                low = mid + 1
            else:
                high = mid - 1
        return -1

nums = [1,2,1,3,5,6,4]
sl = Solution()
print(sl.findPeakElement(nums))
