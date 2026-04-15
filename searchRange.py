class Solution:
    def SearchFirst(self, nums, target, low, high):

        while low<=high:
            mid = low + (high-low)//2
            if nums[mid]==target:
                if (mid==low or nums[mid-1]<nums[mid]):
                    return mid
                else:
                    high = mid-1
            elif nums[mid]<target:
                low = mid+1
            else:
                high = mid-1
        return -1
    
    def SearchLast(self, nums, target, low, high):

        while low<=high:
            mid = low + (high-low)//2
            if nums[mid]==target:
                if (mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                    return mid
                else:
                    low = mid+1
            elif nums[mid]<target:
                low = mid+1
            else:
                high = mid-1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums)-1

        if len(nums)==0 or target<nums[low] or target>nums[high]:
            return [-1,-1]

        firstIndex = self.SearchFirst(nums, target, low, high)
        if firstIndex == -1:
            return [-1,-1]
        LastIndex = self.SearchLast(nums, target, firstIndex, high)
        return [firstIndex,LastIndex] 

