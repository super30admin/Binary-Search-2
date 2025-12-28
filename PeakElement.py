''' Time Complexity : O(log n) 
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Your code here along with comments explaining your approach

     Approach : Comparing if mid greater than its both neighbors, return mid
                Else , slide towards greater neighbor
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        l, h = 0, n-1
        while l <= h:
            mid = (l+h) // 2
            print(l,h,mid)
            if ((mid == 0 or nums[mid] > nums[mid-1]) and (mid == n-1 or nums[mid] > nums[mid+1])):
                return mid
            elif nums[mid+1] > nums[mid]:
                l = mid + 1
            else:
                h = mid - 1