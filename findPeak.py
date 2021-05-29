# Time Complexity : O(logn) 
# Space Complexity :    O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def BS(self,nums,left,right):
        
        if left==right:
            return left
        mid = left+(right-left)//2

        #check if ele at mid index is greater than ele to its right
        #recursive search for any other ele matching that condition to its left
        if nums[mid]>nums[mid+1]:
            return self.BS(nums,left,mid)
        #else recursive search for any other ele matching the required condition to its right
        return self.BS(nums,mid+1,right)
        
    
    def findPeakElement(self, nums) -> int:
        return self.BS(nums,0,len(nums)-1)
        
obj = Solution()
nums = [10,20,40,30,50,60]
print(obj.findPeakElement(nums))