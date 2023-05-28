#Time Complexity: O(logn)
#Space complexity: O(1)
#Program ran successfully on leet code compiler
#Faced no problems while coding this programs


#Finding the minimum value in the rotated array
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.left=0
        self.right=len(nums)-1
        while(self.left<=self.right):
            #if the array is already sorted, we can return the inital value 
            if(nums[self.left]<=nums[self.right]):
                return nums[self.left]
            #Finding the mid value
            self.mid=self.left+(self.right-self.left)//2
            #if the mid value is less than previous and next value, return nums[mid]
            if((self.mid==0 or nums[self.mid]<nums[self.mid-1]) and (self.mid==len(nums)-1 or nums[self.mid]<nums[self.mid+1])):
                return nums[self.mid]
            #moving towards left if the mid value is gretaer than nums[left]
            elif(nums[self.left]<=nums[self.mid]):
                self.left=self.mid+1
            #Other wise move towards right 
            else:
                self.right=self.mid-1
        #returns dummy value
        return 12345