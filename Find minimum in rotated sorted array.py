class Solution:
    def findMin(self, nums: List[int]) -> int:
        left=0
        right=len(nums)-1
        while left<right:
            mid=(left+right)//2
            if nums[mid]>nums[mid+1] and nums[mid]>nums[mid-1]:
                return nums[mid+1]
            elif nums[left]<nums[mid]:
                left=mid
            else:
               right=mid
        return nums[0]
