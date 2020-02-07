time complexity: O(log n)
Space complexity: O(1)
Executed in Leetcode: Wrong answer. Still modifying

Comments: After sanity check, I used 2 loops to find the leftmost and rightmost index. 
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # Sanity check
        if len(nums) == 0:   # Do we need target is not provided?
            return [-1,1]
        
        # Initialize parameters
        left,right = 0, len(nums)-1
        s1, s2 =[],[]
        left_indicator, right_indicator = 0,0
        
        # leftmost search
        while left<right:
            middle = left+(right-left)//2     # Takes care of integer overflow problem
            if nums[middle] == target:
                if left_indicator == 0 or 2:
                    s1.append(middle)
                else:
                    s1.insert(0,middle)
            
            if nums[middle] > target:
                right = middle - 1
                indicator = 1
                continue
            else:
                left = middle + 1
                indicator = 2
                continue
            
            if len(s1) != 0:
                return s1[0]
            
        # rightmost search
        left,right = 0, len(nums)-1
        left_indicator, right_indicator = 0,0
        while left<right:
            middle = left+(right-left)//2     # Takes care of integer overflow problem
            if nums[middle] == target:
                if left_indicator == 0 or 2:
                    s2.append(middle)
                else:
                    s2.insert(0,middle)
            
            if nums[middle] < target:
                left = middle + 1
                indicator = 1
                continue
            else:
                right = middle - 1
                indicator = 2
                continue
            
        # Result time
        if len(s1) != 0 and len(s2) != 0:
            return [s1[0],s2[-1]]
        elif len(s1) == 0 and len(s2) != 0:
            return [s2[0],s2[-1]]
        elif len(s1) != 0 and len(s2) == 0:
            return [s1[0],s1[-1]]
        else:
            return [-1,-1]
            
                
