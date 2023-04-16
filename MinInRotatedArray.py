# ## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

# # Time Complexity : O(logn)
# # Space Complexity : O(1)
# # Did this code successfully run on Leetcode : Yes
# # Any problem you faced while coding this : No

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return -1

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low)//2

            if (mid == low or nums[mid] < nums[mid - 1]) and (mid == high or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] < nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return -1


if __name__ == "__main__":
    s = Solution()
    print(s.findMin([3,4,5,1,2]))

