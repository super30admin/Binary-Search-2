// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
#I have used 2 separate Binary Searches to find first and last position of the target in list.
#First I checked if mid = target and mid is greater than/less than the target or mid is low/high then return mid
#If not I have moved the low and high pointers accordingly

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        output = [-1,-1]
        if not nums:
            return output
        if nums[0] > target or nums[-1] < target:
            return output
        for i in range(len(nums)):
            if nums[i] == target:
                output[0] = i
                break
        for i in range(len(nums) -1, -1, -1):
            if nums[i] == target:
                output[1] = i
                break
        return output

#Time - O(2N) where 2 is constant so O(N)
#Space - O(1)
        
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        if nums[0] > target or nums[-1] < target:
            return [-1,-1]
        output = []

        output.append(self.firstPosition(nums,target))
        output.append(self.secondPosition(nums, target))
        return output
    
    def firstPosition(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high-low) // 2
            if nums[mid] == target:
                if mid == low or nums[mid-1] < target:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def secondPosition(self, nums: List[int], target) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == high or nums[mid+1] > target:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

#Time - O(logN)
#Space - O(1)