#Find Minimum in Rotated Sorted Array

class Solution:
    def findMin(self, nums: List[int]) -> int:
        # in case of rotated array the lowest will always lie in unsorted part
        # in case both parts are sorted then the smallest item will be on the left most element

        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = left + (right-left)//2
            #if both side elemnts of the mid are bigger means the mid is lowest point
            #in case of boundary elements if the other isde is bigger than also it is smallest

            val = nums[mid]
            if (mid  == 0 or val < nums[mid-1]) and (mid == len(nums)-1 or val < nums[mid+1]):
                return val
            
            if nums[right] >  nums[mid]:
                #right subarray is sorted, min will lie in left subarray
                right = mid-1
            else:
                left = mid+1
        
        # return anything as the code won't reach here
        return -1