# using binary search implementation
# time complexity is o(logn)

class Solution(object):
    def findMin(self, nums):
        if len(nums)==1: #case where only one element is present
            return nums[0]
        left=0
        right=len(nums)-1
        
        if nums[right]>nums[0]: # case where no rotation happens
            return nums[0]
        
        while right>=left:
            mid=left+(right-left)//2
            
            if nums[mid]>nums[mid+1]:# case where middle element is greater than next
                return nums[mid+1]
            if nums[mid-1]>nums[mid]: #case where element before is greater than middle element
                return nums[mid]
            if nums[mid]> nums[0]: # if middle element is greater than starting index then the lowest element is present in right half
                left=mid+1
            else:
                right=mid-1
    