"""
Time Complexity -> There are 2 binary searches happening. So TC = 2log(N) ~ log(N)
Space Complexity -> O(1), no extra space
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def first_occurrence():
            res1 = -1
            l = 0
            h = len(nums) - 1
            while (l <= h):
                mid = l + (h - l) // 2
                if nums[mid] == target:
                    res1 = mid
                    h = mid - 1
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    h = mid - 1
            return res1

        def last_occurrence():
            res1 = -1
            l = 0
            h = len(nums) - 1
            while l <= h:
                mid = l + (h - l) // 2
                if nums[mid] == target:
                    res1 = mid
                    l = mid + 1
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    h = mid - 1
            return res1

        return [first_occurrence(), last_occurrence()]