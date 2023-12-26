class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        i = 0
        j = len(nums)-1
        while i < j:
            if nums[i] > nums[i+1]:
                return i
            elif nums[j] > nums[j-1]:
                return j
            i += 1
            j -= 1
        return len(nums)//2
