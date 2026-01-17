# Time Compelxity: O(logn)
# Space Compelxity: O(1)
# Approach: if mid is peak return, whichever side is greater go to that side, if both are greater go to any side

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low = 0
        high = n-1
        if n ==1:
            return 0
        while low<=high:
            mid  = low + (high- low)//2
            #mid is peak
            if (mid==n-1 or nums[mid] > nums[mid+1]) and (mid ==0 or nums[mid]> nums[mid-1]):
                return mid
            #peak is lying in left side
            elif nums[mid]<nums[mid-1] and mid >0 :
                high = mid -1
            else:
                low = mid+1
            
