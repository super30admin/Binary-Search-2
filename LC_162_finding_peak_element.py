#TC-O(log(N))

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0 or nums == []:
            return -1

        low = 0
        high = len(nums)-1 

        while(low<=high):
            mid = int(low+(high-low)/2)
            if (mid==len(nums)-1 or nums[mid] > nums[mid+1]) and (mid==len(nums)-1 or nums[mid] > nums[mid-1]): #basics or an and or operations
                return mid

            if nums[mid+1] >= nums[mid]:
                low = mid + 1
            else:
                high = mid-1
        return -1