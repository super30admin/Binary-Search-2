#tc-o(logn),sc-o(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        print(nums)
        mid = len(nums)//2
        if nums[mid] > nums[0] and nums[mid] > nums[-1]:
            return self.findMin(nums[mid+1:])
        else:
            if nums[mid] < nums[mid-1]:
                return nums[mid]
            else:
                return self.findMin(nums[:mid])
