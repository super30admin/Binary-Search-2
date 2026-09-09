// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
#I have used Binary Search and checked if mid element is the peak that is greater than both the left and right neighbors
#If not then check mid element is smaller than left or right neighbor and move the low/high pointer towards the higher side to get the peak element

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return None
        for i in range(len(nums)-1):
            if nums[i] > nums[i+1]:
                return i
        return len(nums) - 1

#Time - O(N) Linear Search
#Space - O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return None
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid+1]):
                return mid
            if mid == len(nums)-1 or nums[mid] < nums[mid+1]:
                low = mid + 1
            else:
                high = mid - 1
        return low

#Time - O(logN)
#Space - O(1)