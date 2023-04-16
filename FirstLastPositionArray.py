# ## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

# # Time Complexity : O(logn)
# # Space Complexity : O(1)
# # Did this code successfully run on Leetcode : Yes
# # Any problem you faced while coding this : No

class Solution(object):
    def searchRange(self, nums, target):
        #         """
        #         :type nums: List[int]
        #         :type target: int
        #         :rtype: List[int]
        #         """

        if not nums:
            return [-1, -1]

        first = self.binarySearch(nums, target, True)
        if first == -1:
            return [-1, -1]
        last = self.binarySearch(nums, target, False)
        return [first, last]

    def binarySearch(self, nums, target, isFirst):
        low = 0
        high = len(nums) - 1
        result = -1

        while low <= high:
            mid = low + (high - low)//2

            if nums[mid] == target:
                result = mid

                if isFirst:
                    high = mid - 1
                else:
                    low = mid + 1

            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return result


if __name__ == "__main__":
    s = Solution()
    print(s.searchRange([5, 7, 7, 8, 8, 10], 7))
