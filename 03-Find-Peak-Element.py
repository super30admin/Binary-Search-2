# Problem 3: Find Peak Element (https://leetcode.com/problems/find-peak-element/)

# Time Complexity: O(log n) where n is the number of elements in the array
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# We use binary search to find a peak element by comparing the middle element with its neighbors.
# If the middle element is greater than its neighbors, it is a peak and we return its index.
# If the left neighbor is greater, we search the left half; if the right neighbor is greater, we search the right half.


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        if not nums:
            return -1

        if len(nums) == 1:
            return 0

        low, high = 0, len(nums)-1

        while low <= high:
            mid = (low+high)//2
            if (mid ==0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            elif mid == 0 or nums[mid-1] < nums[mid]: 
                low = mid + 1
            else:
                high = mid - 1
                