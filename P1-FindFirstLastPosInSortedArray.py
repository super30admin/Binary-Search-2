"""
Approach: Here, we have to find the indices of the first and last position of element in sorted array, we will do bianry search of the first occurence of the element
and the last occurence of the element differently by using two different functions.


TC: O(log n)
SC: O(1)
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None or len(nums) == 0:
            return [-1,-1]
        n = len(nums)
        def firstOcc(nums, low, high, target):
            while low <= high:
                mid = low + (high-low)//2
                if nums[mid] == target:
                    if mid == 0 or nums[mid] > nums[mid-1]:
                        return mid
                    else:
                        high = mid - 1
                elif target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        def lastOcc(nums, low, high, target): 
            while low <= high:
                mid = low + (high-low)//2
                if nums[mid] == target:
                    if mid == high or nums[mid] < nums[mid+1]:
                        return mid
                    else:
                        low = mid + 1
                elif target < nums[mid]:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        first = firstOcc(nums, 0, n-1, target)
        last = lastOcc(nums, first, n-1, target)
        return [first, last]


    