#TimeComplexity: logN + logN
#SpaceComplexity: O(1)
#It successfully runs on leetcode

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or nums[0] > target or nums[-1] < target: return [-1,-1]
        low = 0
        high = len(nums)-1
        first=-1
        while low <= high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid==0 or (mid!=0 and nums[mid-1]<nums[mid]):
                    first = mid
                    break
                else:
                    high=mid-1
            elif nums[mid]<target:
                low=mid+1
            else:
                high=mid-1
        
        if first==-1: return [-1,-1]
                    
        low = first
        high = len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                if mid==len(nums)-1 or (mid!=len(nums)-1 and  nums[mid+1]>nums[mid]):
                    last=mid
                    break
                if nums[mid+1]==nums[mid]:
                    low=mid+1
            elif nums[mid]<=target:
                low=mid+1
            else:
                high=mid-1
        
        return [first,last]