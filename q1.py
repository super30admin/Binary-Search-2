from typing import List
#Time Complexity :O(log(n))
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Not anything specific
'''Approach:
For Finding the Finding the first and last occurance approach is very similar to binary search, 
Except if we find the index of target, we check wheter there is any occurance of the target on the left for finding the first occurance.
Similarly check in the right for last occurance 
''' 

class Solution:
    #This intermediate function takes Time Complexity of O(log(n))
    def first(self,arr, low, high, x):
        if(high >= low):
            mid = low + (high - low) // 2
            if(arr[mid] == x):
                #Here we have to check wheter it had occured further in the left
                if(self.first(arr,low,mid-1,x)==-1):
                    return mid
                else:
                    return self.first(arr,low,mid-1,x)
            elif(x > arr[mid]):
                return self.first(arr, (mid + 1), high, x)
            else:
                return self.first(arr, low, (mid - 1), x)

        return -1

    #This intermediate function takes Time Complexity of O(log(n))
    def last(self,arr, low, high, x):
        if (high >= low):
            mid = low + (high - low) // 2
            if (arr[mid] == x):
                #Here we have to check wheter it had occured further in the right 
                if(self.last(arr,mid+1,high,x)==-1):
                    return mid
                else:
                    return self.last(arr,mid+1,high,x)
            elif (x < arr[mid]):
                return self.last(arr, low, (mid - 1), x)
            else:
                return self.last(arr, (mid + 1), high, x)

        return -1

    #The Followinng function is the actual solution
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.first(nums,0,len(nums)-1,target),self.last(nums,0,len(nums)-1,target)]
 
