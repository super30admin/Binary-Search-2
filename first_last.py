# // Time Complexity : binarysearch_fo = O(log(N)), binarysearch_lo = O(log(N))
# // Space Complexity : no extra space used
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :  

# // Your code here along with comments explaining your approach:   
# 1) check for edge cases. 
# 2) find the first appearance, if not found return -1.
# 3) now the first appearance becomes the low index, and the array end high, check if the first appearance is the only appearance
# 4) next check for mid and mid's next element moving right in both cases i.e mid==target or mid!=target
# 5) also keep a check for mid==high and mid==low

class Solution:
    def binarysearch_fo(self, nums, target):
        l=0
        h=len(nums)-1
        while(l<=h):
            mid=l+(h-l)//2
            if(nums[mid]==target):
                if(mid==0 or nums[mid]>nums[mid-1]):
                    # print(mid)
                    return mid
                else:
                    h=mid-1
            else:
                if(nums[mid]>target):
                    h=mid-1
                else:
                    l=mid+1
        return -1
    def binarysearch_lo(self, nums, fo, target):
        l=fo
        h=len(nums)-1
        if(fo==h or nums[fo]<nums[fo+1]):
            return fo
        while(l<=h):
            mid=l+(h-l)//2
            if(nums[mid]==target):
                if(mid==h or nums[mid]<nums[mid+1]):
                    return mid
                else:
                    l=mid+1
            else:
                if(nums[mid]>target):
                    h=mid-1
                else:
                    l=mid+1
                

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if(nums==None or len(nums)==0):
            return [-1,-1]
        first_occurance= self.binarysearch_fo(nums, target)
        # print(first_occurance)
        if(first_occurance==-1):
            return [-1,-1]
        second_occurance= self.binarysearch_lo(nums, first_occurance, target)
        return [first_occurance, second_occurance]
        pass