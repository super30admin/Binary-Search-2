# time complexity: O( 2 * log (n)) where n is the number of elements in the array = O(log(n))
# space complexity: O(1) as no additional space used. Only hi, lo, mid ptrs introduced
# # Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No


class Solution(object):

    def searchFirstIndex(self, nums, target):
        n = len(nums)
        low = 0
        high = n - 1

        while low <= high:
            mid = (low + high) // 2

            # check if mid is the target?
            if nums[mid] == target:
                # if mid is the first idx, return mid
                if mid == 0:
                    return mid
                # check if mid is the first occurence of the target or not by comparing with left neighbor
                if nums[mid - 1] == nums[mid]:
                    high = mid - 1
                else:
                    return mid    # if left neighbor != tgt, then its first occurence of the tgt

            # if mid != target, check whether it is on LHS or RHS of the array by comparing
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1  # if tgt not found, return -1

    def searchlastIndex(self, nums, target):
        n = len(nums)
        low = 0
        high = n - 1

        while low <= high:
            mid = (low + high) // 2

            # check if mid is the target?
            if nums[mid] == target:
                # if mid is the last element of the array, return it
                if mid == n-1:
                    return mid
                # check if mid is the first occurence of the target or not by comparing with right neighbor
                if (nums[mid + 1] == nums[mid]):
                    low = mid + 1
                else:
                    return mid   # if right neighbor != tgt, then its first occurence of the tgt

             # if mid != target, check whether it is on LHS or RHS of the array by comparing
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1  # if tgt not found, return -1

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        # do two binary searches to find first idx and last idx. but we do discard half range so still a valid BS.
        first = self.searchFirstIndex(nums, target)
        last = self.searchlastIndex(nums, target)
        return (first, last)


obj = Solution()
print(obj.searchRange([5, 5, 5, 5, 5, 5, 7, 7, 8, 8, 8, 8, 8, 8, 8], 5))
