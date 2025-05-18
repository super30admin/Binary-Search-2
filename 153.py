# min element will be present in the un-sorted half
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        if nums[low] < nums[high] or low == high:
            return nums[low]
        while low <= high:
            mid = low + (high-low)//2
            print(low,mid,high)
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            if nums[mid] < nums[mid -1]:
                return nums[mid]
            if nums[low] < nums[mid]: # left is sorted, reject it
                low = mid+1
            else:
                high = mid-1

        return None
        
