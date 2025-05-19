# Time Complexity: O(log n), n defines number of elements in the array
# Space Complexity: O(1)

class Solution:
    def BSFirst(self, nums, low, high, target):
        while(low<=high):
            mid = low+(high-low)//2
            if nums[mid] == target:
                if mid == low or nums[mid-1] < nums[mid]:
                    return mid
                # Still go left
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else: 
                low = mid + 1
        return -1

    def BSSecond(self, nums, low, high, target):
        while(low<=high):
            mid = low+(high-low)//2
            if nums[mid] == target:
                if mid == high or nums[mid+1] > target:
                    return mid
                # Still go left
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else: 
                low = mid + 1
        return -1

    def searchRange(self, nums, target):
        left = self.BSFirst(nums, 0, len(nums)-1, target)
        right = self.BSSecond(nums, 0, len(nums)-1, target)
        return [left, right]