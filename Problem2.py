"""
I followed the session's method by first checking if the range is sorted. If not, I use binary search to find the minimum by comparing the middle element with its neighbors. Based on the sorted half, I adjust the search space using low and high pointers.
Time Complexity: O(log n)
Space Complexity: O(1)
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while(low <= high):
            # check if complete range is sorted
            if nums[low] <= nums[high]:
                return nums[low]
            # calculate mid and check bounds
            mid = low + (high - low) // 2
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                # move to right
                low = mid + 1
            else:
                # move to left
                high = mid - 1 