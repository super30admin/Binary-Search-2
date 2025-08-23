'''
standing at number, I want to go to side which has higher number 
than pivot. Becasuse this gurantees of giving a higher number. 
# Time Complexity : 
    O(log n): Binary search 
# Space Complexity :
    O(1), just 3 pointers (left, right, mid)   
# Did this code successfully run on Leetcode :
    - yes
# Any problem you faced while coding this :
    - No
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums)==1:
            return 0
        left = 0
        right = len(nums)-1

        while left<=right:
            mid = left + (right-left)//2
            if (mid==0 and nums[mid]>nums[mid+1]) or (mid==len(nums)-1 and nums[mid]>nums[mid-1]) or (nums[mid-1]<nums[mid]>nums[mid+1]):
                return mid
            elif mid>0 and nums[mid-1]>nums[mid]:
                # go left
                right = mid-1
            else:
                #go right
                left = mid+1
        
        return mid