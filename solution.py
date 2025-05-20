




## Problem 1: first and last position. run two binary seraches to find the first index and last index 
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        firstidx = self.findbound(nums,target, True)
        if firstidx == -1:
            return [-1,-1]
        secondidx = self.findbound(nums,target,False)
        return [firstidx,secondidx]     
    def findbound(self, nums, target, isFirst):
        lo = 0
        hi = len(nums) - 1
        while lo <= hi:
            mid = lo + (hi-lo)//2 
            if nums[mid] == target:
                if isFirst:
                    if mid == 0 or nums[mid-1] != nums[mid]:
                        return mid
                    else:
                        hi = mid-1
                else:
                    if mid == len(nums) - 1 or nums[mid+1] !=nums[mid]:
                        return mid 
                    else:
                        lo = mid +1           
            elif nums[mid] < target:
                lo = mid + 1
            else:
                hi = mid -1 
        return -1
## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
def findMin(self, nums: List[int]) -> int:

        lo = 0
        hi = len(nums) - 1 

        while lo < hi:
            mid = lo + (hi-lo)//2

            if nums[mid] > nums[hi]:
                lo = mid+1
            else:
                hi = mid
        return nums[lo]




## Problem 3: find peak element 

 def findPeakElement(self, nums: List[int]) -> int:
        lo = 0
        hi = len(nums) - 1
        while lo < hi:
            mid = lo + (hi-lo)//2
            if nums[mid] < nums[mid+1]:
                lo = mid + 1
            else:
                hi = mid
        return lo
            
        
