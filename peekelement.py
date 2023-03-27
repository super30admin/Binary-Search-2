"""
peek element is where number is greater than left and right elemnet
we ar eusing binary search to find the element.
tc: o(logn)
sc:o(1)
"""



class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        if nums == None or len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            if (mid == low or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1]):
                return mid
            else:
                if nums[mid + 1] > nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1

        return 54545
