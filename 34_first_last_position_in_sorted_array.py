class Solution:
    def searchRange(self, nums: list, target: int) -> [int]:
        result = [-1, -1]
        if not nums:
            return result
        start = 0
        end = len(nums) - 1
        # find left bound
        while start < end:
            mid = (start + end) // 2
            if nums[mid] < target:
                start = mid + 1
            else:
                end = mid
        if nums[start] != target:
            return result
        else:
            result[0] = start
        # find right bound
        end = len(nums) - 1
        while start < end:
            mid = (start + end + 1) // 2
            if nums[mid] > target:
                end = mid - 1
            else:
                start = mid
        result[1] = end
        return result


if __name__ == '__main__':
    h = Solution()
    print(h.searchRange([1, 2, 3, 3, 3, 3, 4, 5, 9], 3))
