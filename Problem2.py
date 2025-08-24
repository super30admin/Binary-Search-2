"""
TC: O(log(N)) {The minimum always lie in the unsorted half of the array, hence we discard the sorted half of the array 
                and continue our search on the other half, we get O(log(N)) t.c.}
SC: O(1)        {we dont use any extra spaces}

The problem succesfully ran on LeetCode
"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        low, high = 0, len(nums)-1

        while low<=high:
            mid = low + (high-low)//2

            if nums[low] <= nums[high]:
                return nums[low]
            
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid 
            

