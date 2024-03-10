"""Brute force linear Solution
TC: O(n)
SC: O(1) wheren n is the length of the input array"""
# class Solution:
#     def findPeakElement(self, nums: List[int]) -> int:
#         if len(nums)==1:
#             return 0
#         for i in range(0, len(nums)):
#             if i==0:
#                 if nums[i] > -math.inf and nums[i]>nums[i+1]:
#                     return i
#             elif i==len(nums)-1:
#                 if nums[i] > -math.inf and nums[i]>nums[i-1]:
#                     return i
#             if nums[i]>nums[i-1] and nums[i]>nums[i+1]:
#                 return i

"""Optimized Binary Search Solution
TC: O(logn)
SC: O(1) wheren n is the length of the input array"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums)==1:
            return 0
        low = 0
        high = len(nums)-1
        while low<high:
            mid_idx = (low + high)//2
            mid_val = nums[mid_idx]
            if mid_val > nums[mid_idx+1]:
                high=mid_idx
            else:
                low = mid_idx+1
        return high
