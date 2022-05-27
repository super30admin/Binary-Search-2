class Solution:
    def peak(self, nums, start, end):
        while start <= end:
            mid = start + (end - start)//2
            if mid != 0 and mid != len(nums)-1 and nums[mid] > nums[mid+1] and nums[mid] > nums[mid-1]:
                return mid
            elif mid != len(nums)-1 and nums[mid] < nums[mid + 1]:
                start = mid + 1
            else:
                end = mid - 1

    def findPeakElement(self, nums: list[int]) -> int:
        start = 0
        end = len(nums) - 1
        mid = start + (end-start)//2
        if mid != 0 and mid != len(nums)-1 and nums[mid] > nums[mid+1] and nums[mid] > nums[mid-1]:
            return mid
        if self.peak(nums, mid + 1, end):
            return self.peak(nums, mid + 1, end)
        if self.peak(nums, start, mid-1):
            return self.peak(nums, start, mid-1)
        return nums.index(max(nums[0], nums[-1]))


check = Solution()
print(check.findPeakElement([1, 6, 5, 4, 3]))
