
# Time Complexity:O(logn)
# Space Complexity:O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums)==1:
            return 0
        l,h=0,len(nums)-1
        while l<=h:
            mid=(h+l)//2
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]> nums[mid+1]):
                return mid
            elif nums[mid] <nums[mid+1]:
                l=mid+1
            else:
                h=mid-1

            

























       
        