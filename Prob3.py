# -Time Complexity : O(logN)
# -Space Complexity : O(1)
# -Did this code successfully run on Leetcode : Yes
# -Any problem you faced while coding this :  Applying Binary search on un-sorted array, but I just need to get used to the notion that Binary search is related to halfing/doubling my search space and not the actual elements themselves.
# -Your code here along with comments explaining your approach.
#       1. Use Binary search and keep moving towards the side with higher element.
#       Note- This approach works here cause, 1. Need to find one of the peaks, 2. 0th and last elements are the peaks if not found any before reaching them

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]): #checking if mid is the peak element
                return mid
            elif nums[mid]<nums[mid+1]: #move right if right neighbour of mid is higher
                low=mid+1
            elif nums[mid-1]>nums[mid]: #move left if left neighbour of mid is higher
                high=mid-1
        return -1