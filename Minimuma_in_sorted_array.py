'''class Solution with a method findMin, which uses a modified binary search to locate the minimum element in the rotated sorted array. The algorithm identifies the sorted half (left or right) and narrows down the search until the left and right pointers meet. The element at the left pointer will be the minimum element in the array.

The time complexity of this algorithm is O(log n) since it uses a binary search approach.
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = left + (right - left) // 2

            if nums[mid] < nums[right]:  # Right half is sorted
                right = mid
            else:  # Left half is sorted
                left = mid + 1

        return nums[left]
