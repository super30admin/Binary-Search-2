# Find minimum in rotated sorted array
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0 
        high = len(nums)-1


        while low<=high:
            if nums[low] <= nums[high]:
                return nums[low]

            mid = (low+high)//2
            
            # check for left sorted or right sorted
            if mid>0 and nums[mid] < nums[mid-1]:
                return nums[mid]

            if nums[mid] >=  nums[low]: #left sorted
                low = mid+1
            elif nums[mid] < nums[high]: #right sorted
                high = mid-1
        
        return -1
            
