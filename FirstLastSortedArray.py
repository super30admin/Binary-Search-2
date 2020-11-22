class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums)==0:
            return [-1,-1]
        first = self.binarySearchFirst(nums, target)
        last = self.binarySearchLast(nums, target)
        return [first,last]
    
    def binarySearchFirst(self, nums, target):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low) //2
            if nums[mid] == target:
                if mid == low or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
        
        
    def binarySearchLast(self, nums, target):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low) //2
            if nums[mid] == target:
                if mid == high or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1