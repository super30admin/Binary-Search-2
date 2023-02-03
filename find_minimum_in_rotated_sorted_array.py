# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only
# Initially we are checking for null array condition
# Then we are checking if the array is already sorted, if it then we return the low i.e 0th index element else we apply binary search to search for mid
# From mid we check if left side is sorted or right side is sorted or if mid is the lowest by comparing it with its neighbors

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        l = 0
        h = len(nums) - 1
        while (l<=h):
            if nums[l] <= nums[h]:
                return nums[l]
            mid = int((l+h)/2)
            if (mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            elif nums[l] <= nums[mid]:
                l = mid+1
            else:
                h = mid-1