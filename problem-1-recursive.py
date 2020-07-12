"""
Approach

1. perform 2 binary search to find the first and last occurence of the target
2. to find first occurence, if middle element and its left neighbour is same then perform binary search on the left part to find the first occurence of target
3. to find last occurence,if middle element and its right neighbour is same then perform binary search on the right part to find the last occurence of target

"""


# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def findFirst(self,nums,low,high,target):
        if low>high:
            return -1
        mid = low + (high-low)//2 
        if(target==nums[mid]):
            if(mid==0 or nums[mid-1]<nums[mid]):
                return mid
            else:
                high = mid-1
        elif(target>nums[mid]):
            low =mid+1
        else:
            high = mid-1
        return self.findFirst(nums,low,high,target)
        
    def findSecond(self,nums,low,high,target):
        if low>high:
            return -1
        mid = low + (high-low)//2 
        if(target==nums[mid]):
            if(mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                return mid
            else:
                low = mid+1     
        elif (target>nums[mid]):
            low =mid+1
        else:
            high = mid-1
        return self.findSecond(nums,low,high,target)
            
            
            
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first  = self.findFirst(nums,0,len(nums)-1,target)
        second  = self.findSecond(nums,0,len(nums)-1,target)
        return [first,second]
        
            
            
            
        
        
    
            
                        
        