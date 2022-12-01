# // Time Complexity : O(log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only
def binarySearch(self, nums):

    low = 0 
    high = len(nums)-1

    while low <= high:

        mid = low + (high-low)//2
        ## check mid ==0 and nums[mid]> nums[mid+1] or mid = len-1 and nums[mid]>nums[mid-1]
        ## then return mid
        if (mid == len(nums)-1 or nums[mid] > nums[mid+1]) and (mid == 0 or  nums[mid] > nums[mid-1]):
            return mid
        
        ## move to right if right of mid is greater
        if nums[mid+1] > nums[mid]:
            low=mid+1
        ## else move to left
        else:
            high= mid-1