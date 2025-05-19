# 2 separate Binary Searches. 1st to find fist position, 2nd to find last position.
# TC: (log(n) + log(n)) = O(log(n))

class Solution:

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)

        # # Edge case: empty array/null check
        if nums == None or n == 0:
            return [-1,-1]

        # Early check: if target is out of bounds
        if target < nums[0] or target > nums[n-1]:
            return [-1,-1]

        firstidx = self.binarySearchFirst(nums,0,n-1,target)
        lastidx = self.binarySearchLast(nums,0,n-1,target)

        return [firstidx,lastidx]

    def binarySearchFirst(self, nums, low, high, target):
        while(low<=high):
            mid = low + (high - low)//2

            if nums[mid] == target:
                # Check if it's the first occurrence
                if low == mid or nums[mid - 1] < nums[mid]:
                    return mid
                else:
                    # Continue searching on the left half
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binarySearchLast(self, nums, low, high, target):
        while(low<=high):
            mid = low + (high - low)//2
            if nums[mid] == target:
                # Check if it's the last occurrence
                if high == mid or nums[mid] < nums[mid + 1]:
                    return mid
                else:
                    # Continue searching on the right half
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
