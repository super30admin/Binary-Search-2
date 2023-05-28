#Time Complexity: O(logn)
#Space Complexity: O(1)
#Code ran successfully on leetcode compiler
#No problems faced while coding

#Finding the peak value in the given array
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        self.left=0
        self.right=len(nums)-1
        while(self.left<=self.right):
            self.mid=self.left+(self.right-self.left)//2
            #if the value is greater than the next value and the previous value return mid value
            if((self.mid==0 or nums[self.mid]>nums[self.mid-1]) and (self.mid==len(nums)-1 or nums[self.mid]>nums[self.mid+1])):
                return self.mid
            #If the left value is grater than mid, we will moving towardss left
            elif(self.mid>0 and nums[self.mid-1]>nums[self.mid]):
                self.right=self.mid-1
            #If not we will be oving towards left
            else:
                self.left=self.mid+1
        return 1235
