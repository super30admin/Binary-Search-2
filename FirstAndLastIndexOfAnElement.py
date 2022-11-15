"""
    Problem Statement: Write an efficient algorithm that searches for a value target in a rotated sorted array.

    Approach: Since the array is rotated, we first need to determine in which part of the array our target lies.
              In order to do that we check which half of the array is sorted. Using the pointers low, mid and high
              we can check which half we are interested in. If the value at index low is smaller than value at 
              mid then we can say the left half of the array is sorted, otherwise right side is sorted. We apply 
              the same concept of updating the pointers and finding the target. If target is found we return the
              index otherwise return -1.

    Time complexity: log(n)
    
    Space complexity: O(1).

    Accepted on LeetCode? Yes!
    LeetCode Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
"""

from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) < 1:
            return [-1, -1]

        result = [self.findFirst(nums, target), self.findLast(nums, target)]
        if result[0] == -1 or result[1] == -1:
            return [-1, -1]
        else:
            return result

    def findFirst(self, nums, target):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if target == nums[mid]:
                if mid == 0 or target != nums[mid - 1]:
                    return mid
                high = mid - 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
    def findLast(self, nums, target):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if target == nums[mid]:
                if mid == len(nums)-1 or target != nums[mid + 1]:
                    return mid
                low = mid + 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1

if __name__ == "__main__":
    test_case1, target = [5,7,7,8,8,10], 8
    s = Solution()
    ret = s.searchRange(test_case1, target)
    assert ret == [3, 4]