class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        r=len(nums)-1
        while l<r:
            m=l+(r-l)//2
            #This implies there is a greater element to the right
            # Since no two adjacent elements are equal as per the constraints
            # If the elements further are greater/smaller we are guaranteed to find a peak as the boundaries are -infinity
            if nums[m]<nums[m+1]:
                l=m+1
            else:
                r=m
        return l 


        