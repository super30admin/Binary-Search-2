class Solution:
    def findFirst(self, nums, target):
        low = 0
        n = len(nums)
        high =  n-1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1]!= target:
                    return mid
                else:    
                    high = mid-1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def findLast(self, nums,target,low):
        n = len(nums)
        high =  n-1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                if mid == n-1 or nums[mid+1]!=target:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1


    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        if n == 0:
            return -1,-1
        elif n == 1:
            if nums[0] == target:
                return 0,0
            else:
                return -1,-1
        
        first = self.findFirst(nums,target)
        if first == -1:
            return -1,-1
        last = self.findLast(nums, target, first)
        if last == -1:
            return first,first
        
        return first,last

