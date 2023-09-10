# time complexity : O(log(n))
# space complexity : O(1)

class Solution:
    def findPeakElement(self, nums):
        low, high = 0, len(nums)-1
        while low<=high:
            mid = (low+high)//2
            if (nums[mid] > nums[mid+1] or mid == high) and (nums[mid] > nums[mid -1] or mid == low):
                return mid
            if nums[mid] > nums[mid+1]:
                high = mid -1
            else:
                low = mid + 1