class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        r=len(nums)-1
        while l<r:
            m=l+(r-l)//2
            # This implies mid can not be minimum as it is greater than something
            if nums[m]>nums[r]:
                l=m+1
            # Here mid can be minimum so keeping r=m
            else:
                r=m
        return nums[r]


        