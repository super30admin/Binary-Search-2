# minimum will be where the immediate left element is greater than current value.
# If we take the mid, then minimum value will not be present in the sorted part of the array, it will always be in the part of the array in reference to mid point, where the array is not sorted
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            # When comparing mid with right, if mid is greater then right that means this array is not sorted and so the pivot element will be on the right of the mid, so we move left to mid + 1
            if nums[mid] > nums[right]:
                left = mid + 1
            # This else indicates that the mid element is less than the right
            # So the minimum is in [left, mid] (mid could be the pivot), so we set right = mid and keep mid.
            else:
                right = mid
        return nums[left]
