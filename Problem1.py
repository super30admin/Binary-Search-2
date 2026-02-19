#Find First and Last Position of Element in Sorted Array
# Time complexity O(logn) 

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        #1st using binary array search for the starting index

        left = 0
        right = len(nums) - 1
        leftIndex = -1
        rightIndex = -1
        while left <= right:
            mid = left + (right-left)//2
            if target == nums[mid]:
                if mid == left or target != nums[mid-1]:
                    leftIndex = mid
                    break
            if target > nums[mid]:
                left = mid+1
            else:
                right = mid - 1
        

        # if leftindex does not get updated, menas target is not present return [-1,-1]
        if leftIndex == -1:
            return [leftIndex, rightIndex]
        #then using the binary search starting from the left index, the mid can point either to same or bigger number
        left = leftIndex
        right = len(nums) - 1
        while left <= right:
            mid = left + (right-left)//2

            # if mid is pointing to same number move the left index ahead
            if target == nums[mid]:
                if mid==right or nums[mid+1] != target:
                    rightIndex = mid
                    break
                left = mid+1
            else:
                right = mid - 1
        

        return [leftIndex, rightIndex]