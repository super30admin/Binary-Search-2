class Solution:
    def findMin(self, nums: List[int]) -> int:

        l=0
        h=len(nums)-1

        while l<=h:
            if nums[l]<=nums[h]:
                return nums[l]
            m=(l+h)//2

            if nums[m]<nums[m-1] and nums[m]<nums[m+1]:
                return nums[m]
            if nums[l]<=nums[m]:
                l=m+1
            else:
                h=m-1
        return 444444