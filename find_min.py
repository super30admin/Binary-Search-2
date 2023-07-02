# // Time Complexity :  O(log(N))
# // Space Complexity : no extra space used
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :  

# // Your code here along with comments explaining your approach:   
# 1) check if array is sorted, put in the while loop so the narrowers arrays also get checked.
# 2) if we get a mid which is a valley then return that or break.
# 3) if left side is sorted move right.
# 4) else move left.


class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        h=len(nums)-1
        if(len(nums)==0 or nums==None):
            return 
        
        while(l<=h):
            if(nums[l]<=nums[h]):
                return nums[l]
            
            mid= l+(h-l)//2
            if(mid!=0 and mid != h and nums[mid-1]>nums[mid] and nums[mid]<nums[mid+1]):
                break
            if(nums[l]<=nums[mid]):
                l=mid+1
            else:
                h=mid-1
        
        return nums[mid]