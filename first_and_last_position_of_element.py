#  Time Complexity : O(log (n)) where n is the length of the array.
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No


# - We perform binary search twice as we need to find both the first and last occurrence of a given target.
# - To find the first occurrence:
#     - First find target. Check if item of LHS of target ≠ target. If equal, move left to find first occurrence.
# - To find the last occurrence:
#     - First find target. Check if item of RHS of target ≠ target. If equal, move right to find last occurrence.
    
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1,-1]
        first = self.searchBinary(nums, target, True)
        if first == -1:
            return [-1,-1]
        last = self.searchBinary(nums, target, False)
        return [first,last]
    def searchBinary(self, nums, target, isFirst):
        low = 0
        high = len(nums) - 1

        while(low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                if isFirst:
                    if mid == 0 or nums[mid-1] != nums[mid]:
                        return mid
                    else:
                        high = mid -1
                else:
                    if mid == len(nums)-1 or nums[mid +1] != nums[mid]:
                        return mid
                    else:
                        low = mid + 1

            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
