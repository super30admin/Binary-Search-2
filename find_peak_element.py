# // Time Complexity : O(log n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only
# Initially we check for null array condition. We apply binary search and check if mid is the first and last element, if its not then we apply binary search again.



class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        l = 0
        h = len(nums) - 1
        while(l<=h):
            mid = int((l+h)/2)
            if (mid==0  or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            elif mid > 0 and nums[mid] < nums[mid-1]:
                h = mid - 1
            else:
                l = mid + 1
            