# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""To find the index of the first occurence of the target,  we use the same binary search logic. If the mid element 
is equal to the target, we check if it is the first occurence of the target. If it is, we return the index. If not, we 
move the right pointer to mid-1. If the mid element is greater than the target, we move the right pointer to mid-1. 
If the mid element is less than the target, we move the left pointer to mid+1. We do the same for the last occurence of the target."""

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left_index, right_index=None,None

        # left index
        left, right = 0, len(nums)-1
        while left <= right:
            mid = (left + right) // 2

            if nums[mid] == target:
                if mid == 0:
                    left_index = mid
                    break
                elif nums[mid-1] != target:
                    left_index = mid
                    break
                else:
                    right = mid - 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1

        
        # right index
        left, right = 0, len(nums)-1
        while left <= right:
            mid = (left + right) // 2

            if nums[mid] == target:
                if mid == len(nums)-1:
                    right_index = mid
                    break
                elif nums[mid+1] != target:
                    right_index = mid
                    break
                else:
                    left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1

        if left_index is not None:
            return [left_index, right_index]
        else:
            return [-1,-1]