"""
    Problem Statement: Write an efficient algorithm that searched for a peak element in the array.

    Approach: Since the problem is asked to solve in O(log n) we tend to implement binary search. We need to
              find the element index where value at (index - 1) is smaller than value at index and value at 
              (index + 1) is smaller than value at index. Since the indices out of bounds are negative infinity
              we assure that the problem always has a solution. Using binary search we ignore the half where the
              value at (index - 1) or (index + 1) is smaller and change our pointers until we reach the peak element.

    Time complexity: log(n)
    
    Space complexity: O(1).

    Accepted on LeetCode? Yes!
    LeetCode Link: https://leetcode.com/problems/find-peak-element/
"""

from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        if len(nums) == 1:
            return 0
        while low <= high:
            mid = (low + high) // 2
            if (mid == low or nums[mid] > nums[mid -1]) and (mid == high or nums[mid] > nums[mid+1]):
                return mid
            elif nums[mid] <= nums[mid+1]:
                low = mid + 1
            else:
                high = mid - 1

if __name__ == "__main__":
    s = Solution()
    nums = [1,2,1,3,5,6,4]
    ret = s.findPeakElement(nums)

    assert ret == 1 or ret == 5

    nums = [1, 2]
    ret = s.findPeakElement(nums)
    assert ret == 1