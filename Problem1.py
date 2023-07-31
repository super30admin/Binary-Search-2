# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

'''
1. Find an instance of the target using binary search
2. Expand the search to the left using a while loop and a pointer start. Similarly expand to the right using a pointer end.
3. Start and end have to be decremented and incremented by 1 after exiting the while loop. Return the start and end pointers as a list
'''
from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = 0 
        right = len(nums)-1
        if len(nums)==0:
            return [-1,-1]
        if len(nums)==1:
            if nums[0]==target:
                return[0,0]
            else:
                return [-1,-1]
        while(left<=right):
            middle = left+(right-left)//2
            if(nums[middle] == target):
                start = middle - 1
                end = middle + 1
                while(start>=left and nums[start] == target):
                    start -=1
                while(end<=right and nums[end] == target):
                    end +=1
                return [start+1,end-1]
            if (nums[middle] >= target):
                right = middle - 1
            else:
                left = middle + 1
        return [-1,-1]