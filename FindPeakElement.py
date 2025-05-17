
#Approach - If the mid element is greater than the neighbouring elements then it is returned as peak.
# If it is not greater then do binary search on its greater neighbour.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        if not nums:
            return -1
       
        l = 0
        n = len(nums)
        h = n-1

        while l<=h:

            if l==h:
                return l

            m = l + (h-l)//2

            if ((m==0 and nums[m]>nums[m+1]) or (m==n-1 and nums[m]>nums[m-1])) or (nums[m-1]<nums[m] and nums[m+1]<nums[m]):
                return m
            if (m!=0 and nums[m-1]>nums[m+1]):
                h = m-1
            else:
                l=m+1

        return

