#if mid-1 is less than mid and mid+1 is less than mid then mid is peak value
#if mid-1 is less tha mid search left side else search right side
#time complexity is o(log n)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if (mid==low or nums[mid-1]<nums[mid]) and (mid==high or nums[mid+1]<nums[mid]):
                return mid
            elif nums[mid-1]>nums[mid]:
                high=mid-1
            else:
                low=mid+1
        return 123