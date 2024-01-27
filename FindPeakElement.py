'''
Since we need to find any peak - we follow the largest neighbor to select 
    the next range
if we find a mid who is greater than its neighbors, that is the peak
TC: O(logn)
SC: O(1)
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l,h = 0, len(nums)-1
        if len(nums) == 1:
            return 0
        while l<=h:
            mid = (l+h)//2
            if (mid-1)>=0 and (mid+1)<len(nums):
                if nums[mid]>nums[mid+1] and nums[mid]>nums[mid-1]:
                    return mid
                else:
                    if nums[mid]<nums[mid+1]:
                        l = mid+1
                    else:
                        h = mid-1
            elif mid == 0:
                if nums[mid]>nums[mid+1]:
                    return mid
                else:
                    l = mid+1
            else:
                if nums[mid]>nums[mid-1]:
                    return mid
                else:
                    h = mid-1