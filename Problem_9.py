# Time Complexity: O(log n) + O(log n) = 2*O(log n) ~ O(log n)
# Space Complexity: O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left, right = 0, len(nums) - 1
        idx1 = idx2 = - 1

        if nums == []:
            return [idx1, idx2]
            
        if target == nums[len(nums)-1] and target == nums[0]:
            return [0, len(nums)-1]

        while left <= right:
            mid = left + (right - left // 2 )
            if target > nums[mid]:
                left = mid + 1
            elif target < nums[mid]:
                right = mid - 1
            else:
                idx1 = mid
                right = mid - 1

        left, right = 0, len(nums) - 1
        while left <= right:
            mid = left + (right - left // 2 )
            if target > nums[mid]:
                left = mid + 1
            elif target < nums[mid]:
                right = mid - 1
            else:
                idx2 = mid
                left = mid + 1
        
        return [idx1, idx2]