'''
In this problem Iused binray search to find the element faster.
In a rotated sorted array at least one side of the array is always sorted.

We check if mis is the minimum element
We compare mid element with low and high pointer elements:
    if low is less than mid, its left sorted
    if mid is less than high, its right sorted

then we ignore the sorted side of the array and search of the other half, since that half has the minimum element

If the whole array is sorted then we directly return low element

'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = (low+high)//2
            # to check if mid element is the minimum element
            if mid > 0 and nums[mid] < nums[mid-1]:
                return nums[mid]
            # comparing low element with mid element
            elif nums[low] <= nums[mid]:
                # moving the pointer to right
                low = mid+1
            else:
                # moving the pointer to left
                high = mid-1

'''
Time Complexity: O(log n)
since we are using binray search and binary search takes O(log n) time

Space Complexity: O(1)
we did not use any extra space.
'''