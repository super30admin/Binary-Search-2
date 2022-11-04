# TC : O(logn)
# SC : O(1)
# Leet code : Yes
# problems : while using or & and
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1
        # maxi = -1
        while l <= r:
            # print(l, r)
            mid = l + (r - l)//2
            # print(mid==len(nums)-1, mid==0)
            if(mid==len(nums)-1 or nums[mid] > nums[mid + 1]) and (mid==0 or nums[mid - 1] < nums[mid]):
                # print("ok")
                return mid
            if nums[mid] < nums[mid + 1]:
                l = mid + 1
            elif nums[mid - 1] > nums[mid]:
                r = mid - 1