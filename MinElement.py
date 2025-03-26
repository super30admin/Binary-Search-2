# Time Complexity : O(log2 n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        n = len(nums)
        high = len(nums)-1
        while(low<high):
            mid = low+(high-low)//2
            if(nums[low]<=nums[high]):
                return nums[low]
            if((mid == 0 or nums[mid]< nums[mid-1]) and (mid == n-1 or nums[mid]< nums[mid+1])):
                return nums[mid]
            elif(nums[mid] < nums[high]):
                high = mid-1
            else:
                low = mid+1
            
        return nums[low]