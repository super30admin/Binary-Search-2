// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
#I have used binary search to check the minimum in array. If mid is minimum then we can check its left and right neighbor if it is smaller
#If not then check with low and high and move the mid accordingly

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return None
        result = nums[0]
        for i in range(len(nums)):
            if nums[i] < result:
                result = nums[i]
        return result

#Time - O(N) Linear Search
#Space - O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return None
        low = 0
        high = len(nums) - 1
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high - low) // 2
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return nums[low]

#Time - O(logN)
#Space - O(1)

