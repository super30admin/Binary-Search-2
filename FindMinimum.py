# Time Complexity : O(log(n))
# Space Complexity : O(1)

class Solution:
    def findMin(self, nums):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            if (nums[low] <= nums[high]): return nums[low]
            mid = low + (high-low)//2
            if ((mid == 0 or nums[mid] < nums[mid-1]) and (nums[mid] < nums[mid+1])):
                return nums[mid]
            elif(nums[low] <= nums[mid]):
                low = mid + 1
            else:
                high = mid - 1
        return -1