# Runs on leetcode
# Time complexity:  O(logN)   93.35 % faster than python sols
# Memory complexity:  O(1)    100 % less than python sols

class Solution:
    def search(self,nums,low,high):
        a = nums[low:high+1]
        if not a:
            return []
        if len(a)==1:
            return a[0]
        if (nums[low]<nums[high]):
            return nums[low]
        else:
            mid = int((low+(high-low)/2))
            if nums[low]<nums[mid] or nums[mid]>nums[high]:
                return self.search(nums,mid+1,high)
            elif nums[low]>nums[mid] or nums[mid]<nums[high]:
                return self.search(nums,low,mid)
        
    def findMin(self, nums):
        return self.search(nums,0,len(nums)-1)
