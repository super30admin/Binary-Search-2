

#Approach - We do binary searhes twice. First to find the first index and then to find the second index with search starting from the first index found. For finding the first index if the mid == target we check if the mid-1 is also equal to target. If it is then we move the high pointer to mid-1. Similarly for finding the second index if the mid == target and also mid+1==target we move the low pointer to mid+1

class Solution:
    def firstBinarySearch(self,nums,l,h,target):

        while l<=h:
            m = l+(h-l)//2

            if nums[m]==target:
                if m!=0 and nums[m-1]==target:
                    h = m-1
                else:
                    return m
            if nums[m]<target:
                l = m + 1
            else:
                h = m - 1
        return -1

    def secondBinarySearch(self,nums,l,h,target):

        n = len(nums)
        while l<=h:
            m = l+(h-l)//2
            if nums[m]==target:
                if m!=n-1 and nums[m+1]==target:
                    
                    l = m+1
                else:
                    return m
            if nums[m]>target:
                h = m - 1
            else:
                l = m + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums)==0:
            return [-1,-1]
        
        l = 0
        n = len(nums)
        h = n-1

        if target<nums[l] or target>nums[h]:
            return [-1,-1]
        

        firstIdx = self.firstBinarySearch(nums,l,h,target)
        secondIdx = self.secondBinarySearch(nums,firstIdx,h,target)

        return [firstIdx, secondIdx]