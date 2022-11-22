"""
    Problem Statement: Find minimum element in a rotated sorted array.

    Time complexity: log(n)
    
    Space complexity: O(1).

    Accepted on LeetCode? Yes!
    LeetCode Link: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
"""
from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        low = 0
        high = len(nums) - 1

        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = (low + high) // 2
            if (mid == low or nums[mid] < nums[mid - 1]) and (mid == high or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

if __name__ == "__main__":
    s = Solution()
    nums = [4,5,6,7,0,1,2]

    ret = s.findMin(nums)
    assert ret == 0