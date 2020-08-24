# Time Complexity : O(logn)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low  = 0
        high = len(nums) -1
        left = leftSearch(nums, low, high, target)
        if left == -1: return [-1, -1]
        right= rightSearch(nums, left, high, target)
        return [left, right]
    
def leftSearch(nums, low, high, target):
    while low <= high:
        mid = low + (high - low) // 2
        if(nums[mid] == target):
            if(mid == low or nums[mid - 1] != target):
                return mid
            high = mid - 1
        elif nums[mid] > target: high = mid -1
        else: low = mid + 1
    return -1

def rightSearch(nums, low, high, target):
    while low <= high:
        mid = low + (high - low) // 2
        if(nums[mid] == target):
            if(mid == high or nums[mid + 1] != target):
                return mid
            low = mid + 1
        elif nums[mid] > target: high = mid - 1
        else: low = mid + 1
    return -1