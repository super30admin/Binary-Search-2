# Check if the first elememt in the array < last elemet in the array. If it is, return the 
# first element. Else, take the mid and see if array[mid-1]>array[mid]. if it is, return mid. Else,
#  check which side of the array is sorted. If the left side is sorted, low = mid+1 else high = mid -1

#  Time complexity: O(logn)
#  Space complexity: O(1)


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums)-1

        while low<=high:
            if nums[low]<nums[high]:
                return nums[low]        
            mid = (low + high)//2
            if mid>0 and nums[mid-1]>nums[mid]:
                return nums[mid]
            else:
                if nums[low]<=nums[mid]:
                    low = mid+1
                else:
                    high=mid-1
        return nums[mid]


        