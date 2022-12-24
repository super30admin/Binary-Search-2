# Time Complexity :
# O(log N)

# Space Complexity :
# O(N) 

# Did this code successfully run on Leetcode :
#Yes

# Any problem you faced while coding this :
#No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)- 1
        while low <= high :
            #If the middle element is the peak (unless it's an end element)
            middle = int(low + (high-low)/2)
            if (middle == 0 or nums[middle] > nums[middle-1]) and (middle==len(nums)-1 or nums[middle+1] < nums[middle]) :
                return middle
            #If the middle is part of descending list - then peak is on the left
            elif middle > 0 and nums[middle] < nums[middle-1]:
                high = middle -1
            else :
            #if the middle is part of the  ascending list
                low = middle+1
