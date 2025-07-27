#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : syntax issues 

#Your code here along with comments explaining your approach
# 

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        firstIndex=self.binarySearchFirst(nums,0,len(nums)-1,target)   #search for the first index
        if firstIndex==-1:                                             # check if it does not exists then return here
            return [-1,-1]
        secondIndex=self.binarySearchSecond(nums,firstIndex,len(nums)-1,target)  # check for the second index starting with low as the first index
        return [firstIndex,secondIndex]
    
    def binarySearchFirst(self,nums,low,high,target):      # binary search for the first index
        while low<=high:
            mid=low+(high-low)/2
            if nums[mid]==target:
                if mid==0 or nums[mid]!=nums[mid-1]:       # if the mid is the target and is not equal to the prev element
                    return mid                             # return it as the starting index
                else:
                    high=mid-1                            # if the prev element is also the same then need to search the left half
            elif nums[mid]>target:                        # if the mid element is greater than the target
                high=mid-1                                # need to check the left half
            else:                                           
                low=mid+1                                 # check the right half 
        return -1                                         # if not found return -1
    
    def binarySearchSecond(self,nums,low,high,target):
        while low<=high:
            mid=low+(high-low)/2
            if nums[mid]==target:
                if mid==len(nums)-1 or nums[mid]!=nums[mid+1]: # if mid is the target and is not equal to the next element
                    return mid                                 # mid the last position of the element and return it 
                else:
                    low=mid+1                                  # if mid is the target and is equal to the next element need to search the right part 
            elif nums[mid]>target:                             # if the element is greater than the target
                high=mid-1                                     # search the left part
            else:
                low=mid+1                                      # search the right part 
        return -1                                              # if not found return -1
         