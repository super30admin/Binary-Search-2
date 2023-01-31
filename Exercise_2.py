#Time Complexity : O(logN), N being length of array. 
#Space Complexity : O(1ogN), because using recursion.
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Fiddled search function because it didn't 
#have a target. 


#Your code here along with comments explaining your approach in three sentences only
'''Using binary search, if left value is greater than right value, return left index. 
Else, search in half where the left value is greater than the right value, because
that's where the lowest is. 
'''
class Solution:
    def search(self, nums, low, high):
        if high-low<=1:
            if nums[high]>nums[low]:
                return low
            else:
                return high
        else:
            mid = int((low+high)/2)
            # if left less than the right. 
            if nums[low]<nums[high]: 
                return low
            else:
                # search in half where left is greater than right. 
                if nums[mid]>nums[high]:
                    return self.search(nums,mid,high)
                else:
                    return self.search(nums,low,mid)

    def findMin(self, nums: List[int]) -> int:
        index = self.search(nums, 0, len(nums)-1)
        return nums[index]