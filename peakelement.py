class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        
        while low<=high:
            mid = int((low+high)/2)
            if (mid==low or nums[mid-1]<nums[mid]) and (mid==high or nums[mid+1]<nums[mid]):
                return mid
            elif nums[mid]<nums[mid+1]:
                low=mid+1
            else:
                high =mid -1
        