"""
Approach: Here, as we have a rotated array, we will do a binary search with the help of low, high and mid pointers, we will check at each point that our mid pointer 
element is less than the previous one then it is our minimum element and if it is not then we will move our search to the minimum element.


TC: O(log n)
SC: O(1)
"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1
        if len(nums) == 1:
            return nums[0]
        while l<=h:
            mid = l + (h-l)//2
            if nums[l] < nums[h]:
                return nums[l]
            
            if nums[mid]<nums[mid-1] and mid != 0:
                return nums[mid]
            elif nums[l] <= nums[mid]:
                l = mid + 1
            else:
                h = mid - 1
        return -1