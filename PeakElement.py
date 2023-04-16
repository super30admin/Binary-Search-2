# ## Problem 3: (https://leetcode.com/problems/find-peak-element/)

# # Time Complexity : O(logn)
# # Space Complexity : O(1)
# # Did this code successfully run on Leetcode : Yes
# # Any problem you faced while coding this : No

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return 0

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low)//2

            if (mid == low or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1]):
                return mid
            elif nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1

        return -1


if __name__ == "__main__":
    s = Solution()
    print(s.findPeakElement([1,2,3,1]))