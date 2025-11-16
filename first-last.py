# Time Complexity : O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :None

# Your code here along with comments explaining your approach in three sentences only
#find start, end of the index by doing binary searches separately
# do binary search to find the target

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums)-1
        start = self.findStart(nums, low, high, target)
        if start == -1:
            return [-1,-1]
        end  = self.findEnd(nums, low,high,target)
        return [start,end]
    def findStart(self, nums, low, high, target):
        while low <= high:
            mid = (low + high)#2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] < nums[mid]:
                    return mid
                else:
                    high = mid -1
            elif nums[mid] > target:
                high = mid -1
            else:
                low = mid + 1
        return -1
    def findEnd(self, nums, low, high, target):
        while low <= high:
            mid = (low + high)#2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid -1
            else:
                low = mid + 1
        return -1
        
        