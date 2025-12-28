''' Time Complexity : O(log n) 
    Space Complexity : O(1) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Your code here along with comments explaining your approach

   Approach : Implementing 2 binray search - for First and Last index
                1. Find First index by comparing with [mid-1], 
                2. Use first index as low for Second binary search
                3. Find Second index by comparing with [mid+1]

'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def firstBinarySearch(nums,l,h):
            while l <= h:
                mid = (l+h)//2
                print(l, h , mid)
                if nums[mid] == target:
                    if mid == 0 or nums[mid-1] != target:
                        return mid
                    else: 
                        h = mid - 1
                
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    h = mid - 1
            return -1

        def lastBinarySearch(nums,l,h):
            while l <= h:
                mid = (l+h)//2
                if nums[mid] == target:
                    if mid == n-1 or nums[mid+1] != target:
                        return mid
                    else:
                        l = mid + 1
                
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    h = mid - 1
            return -1

        n = len(nums)
        first = firstBinarySearch(nums,0,n-1)
        if first == -1:
            return [-1,-1]
        last = lastBinarySearch(nums,first,n-1)
        return [first,last]
        