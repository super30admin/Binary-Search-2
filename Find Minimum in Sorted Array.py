# Time complexity: O(log n)
# Space Complexity: O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        # Time complexity: O(log n)
        start = 0
        end = len(nums) - 1
        minele = float('inf')
        while start <= end:
            mid = (start + end) // 2
            if nums[mid] >= nums[end]:
                minele = min(minele, nums[mid])
                start = mid + 1
            elif nums[mid] <= nums[end]:
                minele = min(minele, nums[mid])
                end = mid - 1
        return minele
