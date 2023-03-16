class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        print(nums)
        if(len(nums)==1):
            return 0
        l = 0
        r = len(nums) -1
        while(l<=r):
            mid = (l+r)//2
            if(l==r):
                return l
            elif(nums[mid]>nums[mid+1]):
                r = mid
            elif(nums[mid]<nums[mid+1]):
                l =mid+1
            
