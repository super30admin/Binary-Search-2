# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on LeetCode: Yes

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        first = self.firstBS(nums, 0, len(nums) - 1, target)
        if first == -1:
            return [-1, -1]
        
        last = self.lastBS(nums, 0, len(nums) - 1, target)

        return [first, last]

    def firstBS(self, nums, l, h, target):
        while l <= h:
            mid = (l + h) // 2
            if nums[mid] == target:
                if mid == l or nums[mid] != nums[mid - 1]:
                    return mid
                else:
                    h = mid - 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                h = mid - 1
        return -1
    
    def lastBS(self, nums, l, h, target):
        while l <= h:
            mid = (l + h) // 2
            if nums[mid] == target:
                if mid == h or nums[mid] != nums[mid + 1]:
                    return mid
                else:
                    l = mid + 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                h = mid - 1
        return -1