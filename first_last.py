"""
This solution finds the first and last occurrence of a target in a sorted array using two binary searches. 
The `leftBiased` function first searches for the leftmost index (`flag=True`) and then the rightmost index (`flag=False`) by adjusting the search space accordingly. 
This approach ensures an efficient O(log N) time complexity by performing two binary searches instead of a linear scan.
Space Complexity: O(1)
"""

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def leftBiased(nums, target, flag):
            l, r = 0, len(nums)-1
            i = -1
            while l<=r:
                mid = l + (r-l)//2

                if target < nums[mid]:
                    r = mid - 1
                elif target > nums[mid]:
                    l = mid + 1
                else:
                    i = mid

                    if flag:
                        r = mid - 1
                    else:
                        l = mid + 1
            return i    
        left = leftBiased(nums, target, True)
        right = leftBiased(nums, target, False)

        return [left, right]