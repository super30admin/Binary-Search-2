#Time Complexity : O(logn) 
#Space Complexity : O(1)

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums)-1

        while(low<=high):
            if (nums [low] <= nums[high]): # when given array is sorted
                return nums[low]

            mid = (low+high)//2

            if ((mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1])):
                return nums[mid]
            elif (nums[low] <= nums[mid]): #checking unsorted array
                low = mid +1
            else:
                high = mid -1
        return -1
