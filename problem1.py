class Solution:
    def binarySearchFirst(self, nums, target):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid - 1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1

    def binarySearchLast(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                if mid == high or nums[mid] < nums[mid + 1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1

    def searchRange(self, nums, target):
        if nums is None or len(nums) == 0:
            return [-1, -1]

        n = len(nums)
        if nums[0] > target or nums[n - 1] < target:
            return [-1, -1]

        first = self.binarySearchFirst(nums, target)
        if first == -1:
            return [-1, -1]

        last = self.binarySearchLast(nums, first, n - 1, target)
        return [first, last]


solution = Solution()

# Example 1
nums1 = [5, 7, 7, 8, 8, 10]
target1 = 8
result1 = solution.searchRange(nums1, target1)
print("Input:", "nums =", nums1, "target =", target1)
print("Output:", result1)


# Example 2
nums2 = [5, 7, 7, 8, 8, 10]
target2 = 6
result2 = solution.searchRange(nums2, target2)
print("Input:", "nums =", nums2, "target =", target2)
print("Output:", result2)

