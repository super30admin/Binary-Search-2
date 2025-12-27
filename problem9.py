# All targets will lie in contiguous blocks since array is sorted.
# So first we find a mid which is equal to target.
# Then do a BS again to its left and to its right.
# result[-1,-1] 0th and 1st index is overwritten by min and max indices of target values in the 
# contingous stream

from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        #since array is sorted, the answers are found in straight contiguous block

        low = 0
        high = len(nums)-1
        result = [-1, -1]

        #BS search in left side of target

        while low <= high:
            mid = low + (high - low)//2

            if target == nums[mid]:
                result[0] = mid
                high = mid-1 #check for next one in left side

            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1

        #Do BS in right half of target
        low = 0
        high = len(nums)-1

        while low <= high:
            mid = low + (high - low)//2

            if target == nums[mid]:
                result[1] = mid
                low = mid+1 #check for next one in left side

            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1

        return result if result else [-1,-1]
    
# Time Complexity: O(logn)
# Space Complexity: O(1)