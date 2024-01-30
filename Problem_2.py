'''
Time Complexity - O(log n)
Space Complexity - O(1)

This code works on leetcode.
'''

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0: #check for empty array
            return -1
        low, high = 0, len(nums) - 1
        while low <= high:
            if nums[low] <= nums[high]: #if the array is now sorted return the element at low
                return nums[low]
            mid = low + (high - low)//2
            if nums[mid] < nums[mid - 1] and (mid == len(nums) - 1 or nums[mid] < nums[mid+1]): #return the element at mid if it is smaller than the element at mid - 1
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return 99999
        