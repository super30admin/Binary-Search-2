class Solution(object):
    def searchRange(self, nums, target):
        # to solve this problem with O(long n), I'm using binary search

        def findFirst(nums, target):
            left, right = 0, len(nums) - 1
            index = -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    index = mid
                    right = mid - 1  # moves left to find the first
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return index

        def findLast(nums, target):
            left, right = 0, len(nums) - 1
            index = -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    index = mid
                    left = mid + 1  # moves right to find the last
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return index

        start = findFirst(nums, target)
        end = findLast(nums, target)
        return [start, end]


s = Solution()
print(s.searchRange([5, 7, 7, 8, 8, 10], 8))

