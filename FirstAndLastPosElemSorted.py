# Explain your approach in **three sentences only** at top of your code
# 1) handle cases where target is not present by comparing 1s and last then find the firstIndex where target is and then find the second index using the first index as low in bs(since we know the array is sorted)
# 2) for lowIndex binary search once we find target we need to check if that is the first targt to do this we basically reject the right half till we dont have nums[mid]>nums[mid-1]
# 3) once we find lowIndex we perform the same bs from lowIndex to last index but here we reject left half (l = mid+1) until nums[mid]< nums[mid+1] handle mid+1 and mid-1 out of bounds

#  can refactor based on flag for first or last index
from typing import List
class Solution:
    def findFirstIndex(self,nums, l, h, target):
        while l<=h:
            mid = l + (h-l)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] < nums[mid]:
                    return mid
                else:
                    h = mid -1
            elif nums[mid] > target:
                h = mid-1
            else:
                l = mid+1
        return -1

    def findLastIndex(self,nums, l, h, target):
        while l<=h:
            mid = l + (h-l)//2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid+1] > nums[mid]:
                    return mid
                else:
                    l = mid + 1
            elif nums[mid] > target:
                h = mid-1
            else:
                l = mid+1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l,h=0,len(nums)-1
        if not nums or len(nums) == 0 : return [-1,-1]
        if nums[0] > target or nums[h] <target:
            return [-1,-1]
        firstIdx = self.findFirstIndex(nums,l,h, target)
        lastIdx = self.findLastIndex(nums,firstIdx,h,target)
        return [firstIdx, lastIdx]