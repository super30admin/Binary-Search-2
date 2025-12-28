''' Time Complexity : O(log n) 
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Your code here along with comments explaining your approach

'''
# --- Solution 1 : ------
''' Approach : Comparing if mid less than its neighbours, return mid
                Else , find the sorted array and move to opposite direction
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        l, h = 0, n-1
        while l <= h:
            if nums[l] <= nums[h]:
                return nums[l]
            mid = (l+h) // 2
            if nums[mid] < nums[mid-1] and nums[mid] < nums[mid+1]:
                return nums[mid]
            elif nums[l] <= nums[mid]:
                l = mid + 1
            else:
                h = mid -1

# --- Solution 2 : ------
''' Approach : If mid is greater than high, means left side is sorted
               and min element lies in right side. 
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        l, h = 0, n-1
        while l < h:
            mid = (l + h) // 2
            if nums[mid] > nums[h]:
                # left side is sorted and min lies in right side
                l = mid + 1
            else:
                h = mid
        return nums[l]