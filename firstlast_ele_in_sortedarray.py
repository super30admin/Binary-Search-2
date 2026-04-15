#Time complexity : O(log n)
#Space complexity : O(1)
#Leet code: Yes
#Solution: The idea is to use binary search twice, once to find the first occurrence of the target and once to find the last occurrence of the target. We will define two helper functions, `firstSearch` and `lastSearch`, to perform these searches. The main function will call these helper functions and return the results as a list.
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums:
            return [-1,-1]   
        
        def fisrtSearch(l, r): 
             
            while l < r:
                m = (l + r)//2
                if nums[m] < target :
                    l = m + 1
                else:
                    r = m
            return l if nums[l] == target else -1
        
        def lastSearch(l, r): 
            
            while l < r:
                m = (l + r + 1)//2
                if nums[m] > target :
                    r = m - 1
                else:
                    l = m
            return l if nums[l] == target else -1
                
        first = fisrtSearch(0, len(nums) - 1)
        last = lastSearch(0, len(nums) - 1)
        return [first, last]