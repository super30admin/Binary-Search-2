# Time Complexity : O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# do two binary searched- one to get start index and second one to get last index.
# we delete half of the elements if its not equal to the target and cut short the problem space accordingly

def firstbs(low, high, nums, target):
    while(low<=high):
        mid=low+(high-low)/2
        if(nums[mid]==target):
            if(mid==0 or nums[mid-1]<nums[mid]):
                return mid
            else:
                high=mid-1
        elif(nums[mid]>target):
            high=mid-1
        else:
            low=mid+1
    return -1

def secbs(low, high, nums, target):
    while(low<=high):
        mid=low+(high-low)/2
        if(nums[mid]==target):
            if(mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                return mid
            else:
                low=mid+1
        elif(nums[mid]>target):
            high=mid-1
        else:
            low=mid+1
    return -1

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        res=[-1,-1]
        n=len(nums)
        
        if(n==0 or nums[0]>target or nums[-1]<target):
            return res
        low=0
        high=n-1
        first=firstbs(low,high,nums,target)
        second=secbs(first,high,nums, target)
        res[0]=first
        res[1]=second
        return res