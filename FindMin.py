# time complexity : O(log(n))
# space complexity : O(1)
class Solution:
    def findMin(self, nums):
        if not nums:
            return -1
        low, high = 0, len(nums)-1
        if nums[low] <= nums[high]:
            return nums[low]
        
        while low <= high:
            mid = (low+high)//2
            if nums[mid] > nums[mid+1]:
                return nums[mid + 1]
            elif nums[mid-1] > nums[mid]:
                return nums[mid]
            if nums[mid] > nums[low]:
                low = mid + 1
            else:
                high = mid -1

        return -1