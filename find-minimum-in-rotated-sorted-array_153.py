#TimeComplexity: logN
#SpaceComplexity: O(1)
#It successfully runs on leetcode


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        mini=0
        while low <= high:
            if nums[low]<=nums[high]: return nums[low]
            mid=low+(high-low)//2
            if mid!=0 and nums[mid]<nums[mid-1]:
                return nums[mid]
            if nums[low] <= nums[mid]:
                low=mid+1
            else:
                high=mid-1