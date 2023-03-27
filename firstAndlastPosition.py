class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums == None and len(nums) == 0:
            return [-1,-1]
        
        first = self.BinarySearchFirst(nums,target)
        if first == -1:
            return [-1,-1]
        second = self.BinarySearchSecond(nums,target)
        return [first,second]
    
    def BinarySearchFirst(self,nums,target):
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low+(high-low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] < nums[mid]:
                    return mid
                high = mid-1
            elif target > nums[mid]:
                low = mid+1
            else:
                high = mid-1
        return -1
    
    def BinarySearchSecond(self,nums,target):
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low+(high-low)//2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid+1] > nums[mid]:
                    return mid
                low=mid+1
            elif target<nums[mid]:
                high = mid-1
            else:
                low = mid+1
        return -1
            
            
