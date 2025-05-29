class Solution:
    def searchRange(self,nums,target):
        def findLeft():
            low,high=0,len(nums)-1
            left=-1
            while low<=high:
                mid=(low+high)//2
                if nums[mid]<target:
                    low=mid+1
                else:
                    high=mid-1
                if nums[mid]==target:
                    left=mid
            return left
          
        def findRight():
            low,high=0,len(nums)-1
            right=-1
            while low<=high:
                mid=(low+high)//2
                if nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
                if nums[mid]==target:
                    right=mid
            return right
               
        return[findLeft(),findRight()]

sol=Solution()
print(sol.searchRange(nums = [5,7,7,8,8,10], target = 8))
print(sol.searchRange(nums=[5,7,7,8,8,10], target = 6))
print(sol.searchRange(nums = [], target = 0))
          