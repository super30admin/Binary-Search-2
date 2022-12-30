class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if len(nums) == 0 or nums == []:
            return -1

        low = 0
        high = len(nums)-1

        while(low<=high):
            if nums[low]<=nums[high]: return nums[low]
            mid = int(low + (high-low)/2)

            if (mid == 0 or nums[mid]<nums[mid-1]) and (mid == len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
           #checking if left side is sorted, if sorted: there is now way we will find minimum element here, so got to unsorted side
            elif nums[low]<=nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        
        return -1