#Time complexity: O(log n) because 1 bin search
#Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums) ==0 or nums is None:
            return [-1,-1]
        
        if nums[0]>target or target>nums[-1]:
            return [-1,-1]
        
        def binSearchLeft(nums,target,low,high):
            while low<= high:
                mid = low + (high-low)//2
                if nums[mid] == target:
                    if mid == 0 or nums[mid-1]< target:
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid]<target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1
        
        def binSearchRight(nums,target,low,high):
            while low<= high:
                mid = low + (high-low)//2
                if nums[mid] == target:
                    if mid == high or nums[mid+1]> target:
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid]<target:
                    low = mid + 1
                else:
                    high = mid - 1
            return -1
        
            
        leftIdx = binSearchLeft(nums,target,0,len(nums)-1)
        if leftIdx == -1:
            return [-1,-1]
        rightIdx = binSearchRight(nums,target,leftIdx,len(nums)-1)
        
        return [leftIdx,rightIdx]
        