#Time Complexity : O(log n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Performed first binary search to find the leftmost occurrence of the target value and then the second binary search was performed to find the rightmost occurrence of the target value.


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low, high = 0, len(nums)-1
        pos = [-1,-1]

        while low <= high:
            mid = (low + high) // 2
            if target == nums[mid]: 
                pos[0] = mid
                high = mid - 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1

        low, high = 0, len(nums)-1

        while low <= high:
            mid = (low + high) // 2
            if target == nums[mid]: 
                pos[1] = mid
                low = mid + 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1

        return pos
        