from ast import List
import sys


class FindMinRot:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        res = float('inf')

        while low <= high:
            mid = low + (high - low) // 2
            res = min(res, nums[mid])
            res = min(res, nums[low])

            if nums[mid] >= nums[low]:
                low = mid + 1
            else:
                high = mid - 1

        return res