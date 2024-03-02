# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        while low<=high:
            if nums[low]<=nums[high]:   #if array is completely sorted
                return nums[low]
            mid = low+(high-low)//2
            if mid!=0 and nums[mid]<nums[mid-1]:  #if mid is the min element
                return nums[mid]
            elif nums[mid]<nums[high]: #right sorted
                high=mid-1             #search for min in left subarray
            else:
                low=mid+1
          

            
        


