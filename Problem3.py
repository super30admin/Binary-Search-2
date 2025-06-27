# TC : O(log n)

# SC : O(1)
class Solution(object):
    def findPeakElement(self, nums):
       
        low,high = 0,len(nums)-1
        if(low == high):
            return 0
        while low<=high:
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums [mid+1])  :
                return mid
            elif (mid < len(nums)-1) and (nums[mid + 1] > nums[mid]):
                low=mid+1
            else:
                high=mid-1
        return -1

