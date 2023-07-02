#Time Complexity :O(log n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#For Finding the peak we will use binary search, we select a sub array with slope having higher value
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums is None:
            return -1

        low=0
        high=len(nums)-1

        while(low<=high):
            #to avoid integer over flow - we dont need it in python
            mid=int(low+(high-low)/2)

            #check if neighbouring elements of mid are less than mid then return mid
            if ((mid==0 or nums[mid-1]<nums[mid]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1])):
                return mid

            #check right subarray by updating the low pointer to mid+1, if value of mid+1 is greater than mid
            elif (mid!=len(nums)-1 and nums[mid+1]>nums[mid]):
                low=mid+1


            else:
                high=mid-1

        return -1