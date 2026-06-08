# LEETCODE PROBLEM 34. FIND FIRST AND LAST POSITION OF ELEMENT IN SORTED ARRAY
# TIME COMPLEXITY: O(log N) where N is the number of elements in the array
# SPACE COMPLEXITY: O(1)
# Any problem you faced while coding this: Tried a new methdology on how can I avoid using
# two different function, I had some hiccups with the logic but later was successful

class Solution(object):              
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """

        def findTarget(nums,start,end,target,isFirst):
            bestFound=-1
            while start<=end:
                mid=(start+end)//2
                if nums[mid]<target:
                    start=mid+1
                elif nums[mid]>target:
                    end=mid-1
                else:
                    bestFound=mid
                    if isFirst:
                        end=mid-1
                    else:
                        start=mid+1
            return bestFound

        high=len(nums)-1
        firstValue=findTarget(nums,0,high,target,True)
        if firstValue==-1:
            return[-1,-1]
        secondValue=findTarget(nums,firstValue,high,target,False)
        return [firstValue,secondValue]
        
