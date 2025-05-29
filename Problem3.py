class Solution:
    def findPeakElement(self,nums):
        left,right=0,len(nums)-1

        while left<right:
            mid=(left+right)//2
            if nums[mid]>nums[mid+1]:
                right=mid
            else:
                left=mid+1
        return left
    
sol=Solution()
print(sol.findPeakElement(nums = [1,2,3,1]))
print(sol.findPeakElement(nums = [1,2,1,3,5,6,4]))