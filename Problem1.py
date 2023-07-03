# In a array of repeating elements, first index of the element can be found using binary search.
# second binary search for finding the last index of the element

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        elif target<nums[0] or target>nums[-1]:
            return [-1,-1]

        else:
            left=self.binarySearchLeft(nums,target)
            if (left==-1):
                return [-1,-1]
            else:
                right = self.binarySearchRight(nums,target)
                if right ==-1:
                    return [left, left]
            return [left,right]
        
    def binarySearchLeft(self, nums, target):
        low=0
        high = len(nums)-1
        while low<=high:
            mid = low + (high-low)//2
            if nums[mid]==target:
                if mid==0 or nums[mid-1]<target:
                    return mid
                else:
                    high=mid-1
            elif nums[mid]>target:
                high = mid-1
            else:
                low = mid+1
        return -1
    
    def binarySearchRight(self, nums, target):
        low=0
        high = len(nums)-1
        while low<=high:
            mid = low + (high-low)//2
            if nums[mid]==target:
                if mid==len(nums)-1 or nums[mid+1]>target:
                    return mid
                else:
                    low=mid+1
            elif nums[mid]>target:
                high = mid-1
            else:
                low = mid+1