class Solution:
    def getFirst(self, low, high, target, nums):
        ans = -1
        while low <= high:
            mid = low + (high - low) // 2
            curr = nums[mid]
            if curr == target:
                ans = mid
                high = mid - 1
            elif target < curr:
                high = mid - 1
            else:
                low = mid + 1
        return ans

    def getLast(self, low, high, target, nums):
        ans = -1
        while low <= high:
            mid = low + (high - low) // 2
            curr = nums[mid]
            if curr == target:
                ans = mid
                low = mid + 1
            elif target < curr:
                high = mid - 1
            else:
                low = mid + 1
        return ans

    def searchRange(self, nums, target):
        n = len(nums)
        low, high = 0, n - 1
        ans = [-1, -1]
        ans[0] = self.getFirst(low, high, target, nums)
        if ans[0] == -1:
            return ans
        ans[1] = self.getLast(low, high, target, nums)
        return ans



nums = [5,7,7,8,8,10]
target = 8
sl = Solution()
print(sl.searchRange(nums,target))