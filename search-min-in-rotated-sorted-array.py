# time complexity: O(log (n)) where n is the number of elements in the array
# space complexity: O(1) as no additional space used. Only hi, lo, mid ptrs introduced
# # Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        low = 0
        high = len(nums) - 1

        while low <= high:
            # array is perfectly sorted, then return low since array is in ascending order & element at low will be the minimum
            if nums[low] <= nums[high]:
                return nums[low]

            # check if mid is the minimum element by comparing with its neighbors & return if yes
            mid = (low + high) // 2
            if ((nums[mid] < nums[mid - 1]) or (mid == 0)) and ((nums[mid] < nums[mid + 1]) or (mid == len(nums) - 1)):
                return nums[mid]

            # Since this is binary search one side will always be sorted, check which one it is. Minimul element will always lie on the unsorted side
            if nums[low] <= nums[mid]:
                # LHS is sorted
                low = mid + 1
            else:
                # RHS is sorted
                high = mid - 1

        return -1  # if low crosses high, return -1


obj = Solution()
print(obj.findMin([4, 5, 6, 7, -1, 1, 2]))
