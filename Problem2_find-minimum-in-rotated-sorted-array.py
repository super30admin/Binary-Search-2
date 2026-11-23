# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#Approach: 1. We start two pointers low and high at each end of the array. The first check if when low pointer is smaller than high pointer, which makes the array/subarray sorted and we return the low index element.
#          2. If the first case is not true, we find a mid and check if the current mid value is smaller than its left and right elements, and we also make sure mid - 1 and mid + 1 are within the array range to avoid IOB exceptions.
#          3. Last two cases cover all the other cases where a low is not less than high, mid is not smaller than both the elements to its left and right. So, that means, the mid we found is either bigger or smaller than the low and we move the low and high pointers accordingly.
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        low, high = 0, n - 1

        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]

            mid = (low+ high) // 2

            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == n-1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[mid] >= nums[low]:
                low = mid + 1
            else:
                high = mid - 1
        return float("inf")

        