'''
Time Complexity : O(LogN)
Space Complexity : O(1)
'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if(len(nums)<1):
            return [-1,-1]
        elif(target<nums[0] or target>nums[-1]):
            return [-1,-1]
        #first i will check for the first occurence
        first  = self.firstocc(nums,target)
        if(first == -1):
            return [-1,-1]
        # if i find 1st occurence then i will check last occurence using binary search
        last = self.lastocc(nums,target)
        return [first,last]
        # function to check first occurence
    def firstocc(self,nums,target):
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = low + (high-low)//2
            if(nums[mid]==target):
                if(mid == 0 or nums[mid-1]<target):
                    return mid
                else :
                    high = mid -1
            elif(nums[mid]>target):
                high = mid -1
            else :
                low = mid + 1
        return -1
        # Function to check last occurence
    def lastocc(self,nums,target):
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = low + (high-low)//2
            if(nums[mid]==target):
                if(mid == len(nums)-1 or nums[mid+1]>target):
                    return mid
                else :
                    low = mid +  1
            elif(nums[mid]>target):
                high = mid -1
            else :
                low = mid + 1
        return -1