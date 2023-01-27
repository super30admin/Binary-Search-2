#Time Complexity : O(logN), N being length of array. 
#Space Complexity : O(1), because input and output are not counted towards the space. 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Took a bit to figure out a strategy and then
#to handle the corner cases. 


#Your code here along with comments explaining your approach in three sentences only
'''Used binary search to find the side that definitely has a value higher than both
the mid and the edge. Because the edges are defined as next to a lower value by
definition, the side that definitely has a higher value is one where the mid
is lower than the edge. Or, if mid is higher than both edges, pick the side that has a 
higher value next to the mid. 
'''
class Solution:
    def isPeak(self, nums, index):
        left=index-1
        right=index+1
        left_true = False
        right_true = False
        if left<0:
            left_true = True
        elif nums[left]<nums[index]:
            left_true = True
        else:
            pass
        if right>len(nums)-1:
            right_true = True
        elif nums[right]<nums[index]:
            right_true = True
        else:
            pass
        return left_true and right_true

    def findPeakIndex(self, nums, low, high):
        # if values next to each other, see if either is peak. 
        if high-low<=1:
            if self.isPeak(nums, high):
                return high
            if self.isPeak(nums, low):
                return low
        else:
            mid = int((low+high)/2)
            # Pick the side where the mid is less than the edge. 
            if nums[mid]<=nums[low]:
                return self.findPeakIndex(nums, low, mid)
            elif nums[mid]<=nums[high]:
                return self.findPeakIndex(nums, mid, high)
            else:
                # else pick the side where the middle is next to a 
                # higher value. 
                if nums[mid+1]>=nums[mid]:
                    return self.findPeakIndex(nums, mid, high)
                else:
                    return self.findPeakIndex(nums, low, mid)          
    
    # used recursion function. 
    def findPeakElement(self, nums: List[int]) -> int:
        index = self.findPeakIndex(nums, 0, len(nums)-1)
        return index