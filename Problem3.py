"""
Implemented using binary search. First, I check if the middle element is a peak, handling edge cases where the element could be at the ends of the array. If the middle element is not a peak, I move to the larger neighbor of the middle element, ignoring the other half.
Time Complexity: O(log n)
Space Complexity: O(1)
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while(low <= high):
            mid = low + (high - low) // 2
            if(mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            # find the bigger neighbour
            elif(mid > 0 and nums[mid] < nums[mid - 1]):
                high = mid - 1
            else:
                low = mid + 1
                