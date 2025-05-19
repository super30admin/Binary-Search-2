# Time Complexity: O(log n), n defines number of elements in the array
# Space Complexity: O(1)

class Solution:
    def findMin(self, nums) -> int:
        low = 0
        high = len(nums)-1
        n = len(nums)
        while low<=high:
            # Check if the low-high range is sorted
            # Single Element Range
            if nums[low]<=nums[high]:
                return nums[low]

            mid = low + (high - low)//2
            # Check the mid value is the min, as it's both neighbour are smaller
            # [2,0]
            if ((mid == 0 or nums[mid]<nums[mid-1]) and 
            (mid == n-1 or nums[mid]<nums[mid+1])):
                return nums[mid]
            # left sorted array
            elif nums[low] <= nums[mid]:
                low = mid + 1
            #right sorted array
            else:
                high = mid - 1
        return 0