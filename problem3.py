# LEETCODE PROBLEM 162. FIND PEAK ELEMENT
# TIME COMPLEXITY: O(log N) where N is the number of elements in the array
# SPACE COMPLEXITY: O(1)
# Any problem you faced while coding this: Had a bit issue when I was making the edge cases 
# ie the index 0 and index n-1 logic

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low=0
        high=len(nums)-1
        while (low<=high):
            mid=(low+high)//2
            if (mid==0 or nums[mid-1]<nums[mid]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            elif (mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                low=mid+1
            else:
                high=mid-1
        return -1