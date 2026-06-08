# Find peak element in an array
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1

        while low<=high:
            mid = (low+high)//2

            if (mid==len(nums)-1 or nums[mid] > nums[mid+1]) and (mid ==0 or nums[mid]>nums[mid-1]):
                return mid
            elif (mid+1 < len(nums) and nums[mid+1]>= nums[mid]):
                low = mid+1
            else:
                high = mid-1
        return -1
    
# TC: O(logN)
# SC: O(1)