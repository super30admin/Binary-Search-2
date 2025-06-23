# Time Complexity:O(logn)
# Space Complexity:O(1)
#Approach: If nums[mid] is less than it's adjacent elements then nums[mid] is the minimum element.


class Solution:
    def findMin(self, nums: List[int]) -> int:
        n=len(nums)

        if nums[0]<=nums[-1]:
            return nums[0]

        l,r=0, n-1

        while l<=r:
            mid=(l+r)//2
            if nums[mid]>nums[r]:
                l=mid+1
            elif nums[mid]<nums[r]:
                r=mid
            else:
                return nums[mid]
        