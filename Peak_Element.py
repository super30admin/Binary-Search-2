#Time Complexity=O(logn)
#Spece Complexity=O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        #Check if the list is null or the lenght of the list
        if nums is None or len(nums)==0:  
            return -1 #Return -1 if the list is None or has length 0

        low=0 #Set low=0
        high=len(nums)-1 #Set high=len(nums)-1 

        while(low<=high): #Loop until low<=high
            mid=low+(high-low)//2 #Set mid=low+(high-low)//2

            #Check for the following conditions
            if((mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1])):     
               return mid #If the following condition is true return mid

            #Check if nums[mid+1]> nums[mid] 
            elif(nums[mid+1]>nums[mid]):
                low=mid+1 #Set low=mid+1

            else:
                high=mid-1 #Set high=mid-1

        return -1 #If the peak element is not found than return -1
        
