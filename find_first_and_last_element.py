# avg TimeComplexity O(log n )
# SpaceComplexity O(1)

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        first = -1
        def binarysearchFirst(nums, target):
            low = 0
            high = len(nums)-1
            while low <= high:
                mid = (low + high)//2
                if nums[mid] == target:
                    if mid == 0 or nums[mid-1] != nums[mid]:
                        return mid
                    else:
                        high = mid-1
                elif nums[mid] > target:
                    high = mid-1
                else:
                    low = mid+1
            return -1
        
        def binarysearchLast(nums, target):
            low = first
            high = len(nums)-1
            while low <= high:
                mid = (low + high)//2
                if nums[mid] == target:
                    if mid == len(nums)-1 or nums[mid+1] != nums[mid]:
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] > target:
                    high = mid-1
                else:
                    low = mid+1
            return -1


        if len(nums) == 0: return [-1,-1]
        if nums[0] > target or nums[-1] < target: return [-1,-1]
        first = binarysearchFirst(nums, target)
        if first == -1: return [-1,-1]
        last = binarysearchLast(nums, target)
        return [first, last]