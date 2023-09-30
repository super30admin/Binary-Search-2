# Time Complexity - O(log n)
# Space Complexity - O(1)

# Approach - we can find the first occurrence and last occurrence of the element using binary search
# and when searching for the first time if there was not match we return -1

class Solution:

    def findFirstOccurrence(self, nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] != target:
                    return mid
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
    def findLastOccurrence(self, nums: List[int], target: int, start: int) -> int:
        low, high = start, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] != target:
                    return mid
                low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first_occurrence = self.findFirstOccurrence(nums, target)
        if first_occurrence == -1:  # If the target is not found
            return [-1, -1]
        last_occurrence = self.findLastOccurrence(nums, target, first_occurrence)
        return [first_occurrence, last_occurrence]             

