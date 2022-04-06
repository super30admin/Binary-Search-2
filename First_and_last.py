# Time Complexity:O(log N) as we used only one binary search.

class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:

        lower_bound = self.findBound(nums, target, True)
        if (lower_bound == -1):
            return [-1, -1]

        upper_bound = self.findBound(nums, target, False)

        return [lower_bound, upper_bound]

    def findBound(self, nums: list[int], target: int, isFirst: bool) -> int:

        N = len(nums)
        begin, end = 0, N - 1
        while begin <= end:
            mid = int((begin + end) / 2)

            if nums[mid] == target:

                if isFirst:
                    # found our lower bound.
                    if mid == begin or nums[mid - 1] < target:
                        return mid

                    # Search on the left side.
                    end = mid - 1
                else:

                    # we found our upper bound.
                    if mid == end or nums[mid + 1] > target:
                        return mid

                    # Search on the right side.
                    begin = mid + 1

            elif nums[mid] > target:
                end = mid - 1
            else:
                begin = mid + 1

        return -1
