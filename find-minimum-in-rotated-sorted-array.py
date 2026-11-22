class Solution:
    def findMin(self, nums: list[int]) -> int:
        low =0
        high=len(nums)-1
        while low<=high:
            #if its the first elemtent and the smallest then retrun that element
            if nums[low]<=nums[high]:
                return nums[low]
            mid=(low+high)//2
            #check out of bounds as well
            if ((mid==0 or nums[mid]<nums[mid-1]) and (mid ==len(nums)-1 or nums[mid]<nums[mid+1])):
                return nums[mid]
            elif nums[low]<=nums[mid]:
                low=mid+1
            else:
                high=mid-1
        return -1

        