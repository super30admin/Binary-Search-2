#Find First and Last Position of Element in Sorted Array
#O(N) approach
class Solution(object):
    def searchRange(self, nums, target):
        first=-1
        last=-1
        for i in range(0,len(nums)):
            if nums[i]==target:
                if first==-1:
                    first=i
                last=i
        return [first,last]

