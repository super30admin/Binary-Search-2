# I am using binary search to find the mid element. I am comparing it with the element to its left and right. 
# Once the increasing slope is found, low or high index is updated accordingly.


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        
        while low <= high:
            mid = low + (high - low)//2
            if (mid==0 or nums[mid]> nums[mid-1]) and (mid==len(nums)-1 or nums[mid]> nums[mid+1]):
                return mid
            elif mid != 0 and nums[mid] < nums[mid-1]:
                high=mid-1
            elif mid!=len(nums)-1 or nums[mid] < nums[mid+1]:
                low= mid+1
        return -1