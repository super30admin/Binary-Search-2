class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]

        Time complexity:
        Space complexity:
        Did this code successfully run on Leetcode: Yes
    
        Any problem you faced while coding this: Understanding the boundary conditions
        """
        
        def findBound( nums, target, isLeft):
            n = len(nums)
            left, right = 0, n-1
            while left <= right:
                mid = left + (right-left)/2

                if nums[mid] == target:
                    if isLeft:
                        # This means that we have to find the Left Bound
                        if mid == left or nums[mid-1] < target:
                            return mid
                        # search on left side for the bound
                        right = mid - 1
                    else:
                        # This means that we have to find the Right bound
                        if mid == right or nums[mid+1] > target:
                            return mid
                        left = mid + 1
                elif nums[mid] > target:
                    right = mid - 1
                else: 
                    left = mid + 1
            return -1 


        lower_bound = findBound(nums, target, isLeft = True)
        if lower_bound == -1:
            return[-1,-1]
        
        upper_bound = findBound(nums, target, isLeft=False)

        return[lower_bound, upper_bound]
