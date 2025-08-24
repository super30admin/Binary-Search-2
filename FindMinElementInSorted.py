# Time Complexity : O(log n) as we do binary search to determine the pivot(Min value)
# Space Complexity : O(1) no extra space used.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while (low <= high):
            if (nums[low] <= nums[high]):
                return nums[low]

            mid = low + (high - low) // 2

            if ((mid == 0 or nums[mid] < nums[mid - 1])
                    and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1])):
                return nums[mid]
            elif nums[mid] >= nums[low]:
                low = mid + 1
            else:
                high = mid - 1

        return 2727