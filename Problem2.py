class Solution:
    def findMin(self,nums):
        low,high=0,len(nums)-1

        while low<high:
            mid=(low+high)//2

            if nums[mid]>nums[high]:
                low=mid+1
            else:
                high=mid

        return nums[low]
    
sol=Solution()
print(sol.findMin(nums = [3,4,5,1,2]))
print(sol.findMin(nums = [4,5,6,7,0,1,2]))
print(sol.findMin(nums = [11,13,15,17]))