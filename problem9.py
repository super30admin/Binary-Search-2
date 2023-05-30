#Time Complexity : O(logn)
#Space Complexity : O(1)

#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarySearchLeft(nums, target):
            l, r = 0, len(nums) - 1
            while l <= r:
                mid =l+ (r-l) // 2
                if nums[mid] < target:
                    l = mid + 1
                
                else:
                    r = mid - 1

            return l

        def binarySearchRight(nums, target):
            l, r = 0, len(nums) - 1
            while l <= r:
                mid = (l + r) // 2
                if nums[mid] <= target:
                    l = mid + 1
                
                else:
                    r = mid - 1

            return r

        left = binarySearchLeft(nums, target)
        right = binarySearchRight(nums, target)
        if left <= right:
            return [left, right]
        
        return [-1, -1]