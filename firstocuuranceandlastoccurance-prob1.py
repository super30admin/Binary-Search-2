class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        
        low = 0
        high = len(nums)-1
        
        first = self.BinarySearchFirstOccuence(nums,low,high,target)
        if first == -1:
            return [-1,-1]
        last = self.BinarySearchLastOccuence(nums,first,high,target)
        return[first,last]

    def BinarySearchFirstOccuence(self,nums,low,high,target):
        while low <= high:
            mid = low+ (high-low)//2
            if nums[mid] == target:
                if mid ==0 or nums[mid]>nums[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def BinarySearchLastOccuence(self,nums,low,high,target):
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid]<nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1       
