# Find First and Last Position of Element in Sorted Array

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        if nums == None or len(nums)==0:
            return [-1,-1]

        low = 0
        high = len(nums)-1
        firstElement = -1
        secondElement = -1

        firstElement = self.findFirstElement(nums, low, high, target)
        
        if firstElement == -1:
            return [-1,-1]
        
        secondElement = self.findLastElement(nums, firstElement, high, target)

        if secondElement == -1:
            return [-1,-1]
        
        return [firstElement, secondElement]


    def findFirstElement(self, nums, low, high, target):
        while low <= high:
            mid = (low+high)//2

            if nums[mid] == target:
                if mid==0 or nums[mid]>nums[mid-1]:
                    return mid
                else:
                    high = mid-1
            elif nums[mid]>target:
                high = mid-1
            else:
                low = mid+1
        return -1
    
    
    def findLastElement(self, nums, low, high, target):
        while low <= high:
            mid = (low+high)//2

            if nums[mid] == target:
                if mid==len(nums)-1 or nums[mid]<nums[mid+1]:
                    return mid
                else:
                    low = mid+1
            elif nums[mid]>target:
                high = mid-1
            else:
                low = mid+1
        return -1

# TC: O(logN)
# SC: O(1)