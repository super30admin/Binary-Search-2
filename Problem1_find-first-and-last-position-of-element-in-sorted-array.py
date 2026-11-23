# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#Approach: Instead of defining two separate binary searches for checking the first and the last occurance, we can use a flag in the same binary search function.
#          When the flag is True, that means we are trying to find the first occurance of the target, so when we find a mid element thats equal to target, we can check if the flag passed in the function call is True or False.
#          We can move the low and high pointer based on the flag value and the rest of the logic moves the low/high pointer based on if the mid found is smaller or larger than the target

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarySearch(find_first: bool) -> int:
            l, r = 0, len(nums) - 1
            ans = -1

            while l <= r:
                mid = (l + r) // 2

                if nums[mid] == target:
                    ans = mid

                    if find_first:
                        r = mid - 1
                    else:
                        l = mid + 1
                
                elif nums[mid] < target:
                    l = mid + 1

                else:
                    r = mid - 1
            return ans
        
        left = binarySearch(True)
        right = binarySearch(False)

        return [left, right]