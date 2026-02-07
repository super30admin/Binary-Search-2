# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use two binary searches. The first binary search finds the first occurrence and 
# The second binary search finds the last occurrence

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def findFirst(l, h):
            while l <= h:
                m = (l + h) // 2
                if nums[m] == target:
                    if m == 0 or nums[m - 1] != target:
                        return m
                    h = m - 1
                elif nums[m] < target:
                    l = m + 1
                else:
                    h = m - 1
            return -1
        
        def findSecond(l, h):
            while l <= h:
                m = (l + h) // 2
                if nums[m] == target:
                    if m == len(nums) - 1 or nums[m + 1] != target:
                        return m
                    l = m + 1
                elif nums[m] > target:
                    h = m - 1
                else:
                    l = m + 1
            return -1
        
        first = findFirst(0, len(nums) - 1)
        if first == -1:
            return [-1, -1]
        
        second = findSecond(first, len(nums) - 1)
        return [first, second]
