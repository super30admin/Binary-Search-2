class Solution(object):
    def findMin(self, nums):
        l = 0
        h = len(nums) - 1
        while l <= h:
            mid_index = (l + h) // 2
            mid = nums[mid_index]

            if mid > nums[h]:
                l = mid_index + 1
            
            elif nums [l] == mid:
                return nums[l]

            else:
                h = mid_index - 1
