'''


Peak element is an element which is larger than its neighbor.
For example:
1. [1, 2, 3, 5, 4, 3, 7, 4] -> Peak elements [5, 7].
2. [1, 2] -> Peak element is 2.
3. [2, 1] -> Peak element is 2.


Time complexity: O(log n)
Space complexity: O(1)
'''
from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if (mid == 0 or (nums[mid - 1] < nums[mid])) and (mid == len(nums) - 1 or (nums[mid] > nums[mid+1])):
                return mid

            elif nums[mid] < nums[mid + 1]:
                low = mid + 1

            else:
                high = mid - 1
        return 55555555


# Driver code
solution = Solution()
l = [1, 2, 3, 5, 4, 3, 7, 4]
print(f'Original list: {l}')
print(f'Peak elements from the list are: {solution.findPeakElement(l)}')
