"""
time complexity:
space complexity:
Did your code run on leetcode?: yes
issues faced: finding conditions for edge cases
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        h = len(nums)-1
        while(l<=h):
            mid = l + (h-l)//2
            if((mid == 0 or nums[mid] < nums[mid - 1]) and (mid == (len(nums) - 1) or nums[mid] < nums[mid +1])):
                return nums[mid]
            elif nums[mid] > nums[h]:
                l = mid + 1
            elif nums[mid] < nums[h]:
                h = mid - 1
            else:
                return -1
