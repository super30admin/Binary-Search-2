#Time Comlpexity is O(logn)
#Space Complexity is O(1)
#Code ran successfully on Leetcode compiler
#Faced no problem while coding

class Solution(object):
    #Here we are going to check on the left hand side
    def binarySearchFirst(self,nums,low,high,target):
        while(low<=high):
            self.mid=low+(high-low)//2
            if(nums[self.mid]==target):
                #If the middle value is equal to target and if the left hand value is not equal to that or is at the begining
                if(self.mid==0 or nums[self.mid]!=nums[self.mid-1]):
                    return self.mid
                #If not we will be moving towards left of the mid
                else:
                    high=self.mid-1
            #If the value at the mid is greater than the target, we change the high to mid-1  
            elif(nums[self.mid]>target):
                high=self.mid-1
            #if not we will change low to mid +1
            else:
                low=self.mid+1
        return -1

    #Here we are going to check on the right hand side
    def binarySearchLast(self,nums,low,high,target):
        while(low<=high):
            self.mid=low+(high-low)//2
            if(nums[self.mid]==target):
                #If the middle value is at the end or is not equal to next value in the list
                if(self.mid==len(nums)-1 or nums[self.mid]!=nums[self.mid+1]):
                    return self.mid
                #If not move the low to the right
                else:
                    low=self.mid+1
            #If the value at the mid is greater than the target, we change the high to mid-1          
            elif(nums[self.mid]>target):
                high=self.mid-1
            #if not we will change low to mid +1   
            else:
                low=self.mid+1
        return -1
    

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        #If the nums array is empty the return [-1,-1]
        if(nums==None or len(nums)==0):
            return [-1,-1]
        #If the target is not present in the array
        elif(nums[0]>target or nums[len(nums)-1]<target):
            return [-1,-1]
        #we will find the first and second value and we will return that
        else:
            self.first=self.binarySearchFirst(nums,0,len(nums)-1,target)
            if(self.first==-1):
                return [-1,-1]
            self.last=self.binarySearchLast(nums,self.first,len(nums)-1,target)
            return [self.first,self.last]
        


        
        
        