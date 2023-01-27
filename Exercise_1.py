#Time Complexity : O(logN), N being length of array. 
#Space Complexity : O(1), because input and output are not counted towards the space. 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Fiddled with the binaryRight portion 
#for a while due to an error in code, which was found later. 


#Your code here along with comments explaining your approach in three sentences only
'''Use binary search to find a value that is equal to target. Then, binary search to 
find the left mosvalue equal to target, same for the right most value equal to target. 
Return two indices of left most and right most. 
'''
class Solution:
    #find one value equal to target
    def binarySearch(self, nums, target, low, high):
        if high-low<=1:
            if nums[high]==target:
                return high
            elif nums[low]==target:
                return low
            else:
                return -1
        else:
            mid = int((low+high)/2)
            if nums[low]<=target and nums[mid]>=target:
                return self.binarySearch(nums, target, low, mid)
            else:
                return self.binarySearch(nums, target, mid+1, high)
    #find left most equal to target
    def binaryLeft(self, nums, target, low, high):
        if high-low<=1:
            if nums[low]<target:
                return high
            if nums[low]==target:
                return low
        else:
            mid = int((low+high)/2)
            if nums[mid]==target:
                return self.binaryLeft(nums, target, low, mid)
            if nums[mid]<target:
                return self.binaryLeft(nums, target, mid, high)
                 
    #find right most equal to target
    def binaryRight(self, nums, target, low, high):
        if high-low<=1:
            if nums[high]>target:
                return low
            if nums[high]==target:
                return high
        else:
            mid = int((low+high)/2)
            if nums[mid]==target:
                return self.binaryRight(nums, target, mid, high)
            if target<nums[mid]:
                return self.binaryRight(nums, target, low, mid)

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums)==0:
            return [-1, -1]
        index = self.binarySearch(nums, target, 0, len(nums)-1)
        print(index)
        if index == -1:
            return [-1, -1]
        else:
            left = self.binaryLeft(nums, target, 0, index)
            right = self.binaryRight(nums, target, index, len(nums)-1)
            return [left, right]