# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        if len(nums)==1:
            return 0
        while low<=high:
            mid = (low+high)//2
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]): #If mid is the peak element
                return mid
            elif nums[mid+1]>nums[mid]: #when mid is not peak go towards element that is larger than peak
                low = mid+1
            else:
                high=mid-1
        