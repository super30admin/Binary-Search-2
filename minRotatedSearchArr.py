#to find min value in rotated sorted array we first check if array is empty or not 
#in loop when low index value less than high index value we find the min val and return that
#if mid value is less than mid-1 or mid+1 means mid value is min given that its not first and last position
#if low index val is less or equal to mid serach right part else left part
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums ==None or len(nums)==0:
            return -1
        
        low=0
        high=len(nums)-1

        while low<=high:
            if nums[low]<=nums[high]:
                return nums[low]
            mid=low+(high-low)//2
            if(mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            if nums[low]<=nums[mid]:
                low=mid+1
            else:
                high=mid-1
        
        return 123