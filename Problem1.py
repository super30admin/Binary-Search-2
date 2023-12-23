# Time Complexity: log(N) + log(K) (k is occurence count of the target) => log(N) ( worst case where the entire array is the target)
# Space: O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l, r = 0, len(nums) - 1
        first_idx = -1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                first_idx = mid
                r = mid - 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        if first_idx == -1:
            return [-1, -1]

        l, r = first_idx, len(nums) - 1
        last_idx = -1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                last_idx = mid
                l = mid + 1
            else:
                r = mid - 1
        
        return [first_idx, last_idx
