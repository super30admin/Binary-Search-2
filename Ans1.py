# Time Complexity :  O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes      
# Any problem you faced while coding this : No  

# Your code here along with comments explaining your approach: We want to avoid linear search for this problem so we choose binary search. We want to find the first as well as the second occurence of the target element. The startPos function checks for the first ocuurence or if the element is at the beginning. If not the first occurance move high to mid - 1. The endPos function checks for the second occurence or if the element is at the end.

class Solution:
    def startPos(self, nums, target, low, high):
        while (low <= high):
            mid = low + (high - low)//2

            if nums[mid] == target:
                if mid == low or nums[mid - 1] < nums[mid]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
    def endPos(self, nums, target, low, high):
        while (low <= high):
            mid = low + (high - low)//2

            if nums[mid] == target:
                if mid == high or nums[mid] < nums[mid + 1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1 

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        firstPos = self.startPos(nums, target, 0, len(nums) - 1)
        lastPos = self.endPos(nums, target, 0, len(nums) - 1)
        return [firstPos, lastPos]