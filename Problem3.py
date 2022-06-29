'''
Time Complexity : O(LogN)
Space Complexity : O(1)
'''


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        #first check mid if it is > both mid+1 and mid-1 then return mid
        # else go towards greater element and perform binary search
        while(low<=high):
            mid = low + ((high-low)//2)
            if((mid ==0 or nums[mid]>nums[mid-1] ) and (mid == len(nums)-1 or nums[mid]>nums[mid+1])):
                return mid
            elif(nums[mid]<nums[mid+1]) :
                low = mid +1
            else :
                high = mid -1 