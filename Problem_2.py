'''
We use the binary search, and then the idea is that the min will always be in the unsorted array

In case both the sides of the mid turns out to be sorted:

0 1 2

then we ignore the right side since the mid will always be on the left in such case.

We check if the mid is not at the edge and check if the neighboring numbers are bigger than mid
then we found our min number in the rotated sorted array.
'''

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1

        while l <= r:
            m = l + (r-l)//2
            if (m == 0 or nums[m-1] > nums[m]) and (m == len(nums)-1 or nums[m+1] > nums[m]):
                return nums[m]

            if nums[m] < nums[r]:
                r = m-1
            else:
                l = m+1

        return -1
