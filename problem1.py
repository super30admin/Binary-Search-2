# Time Complexity : O(log n)  its log n because we are doing binary search twice, once for finding the first occurrence and once for finding the last occurrence
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes 
# Any problem you faced while coding this : No


class Solution:
    def searchRange(self, nums, target):
        #first search for the first occurrence of the target, if we find it, then we will search for the last occurrence of the target, if we don't find it, then we will return [-1, -1]
        def firstbinarysearch(nums, target, low, high):
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == 0 or nums[mid - 1] != target:
                        return mid
                    else:
                        high = mid - 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        def lastbinarysearch(nums, target, low, high):
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    if mid == len(nums) - 1 or nums[mid + 1] != target:
                        return mid
                    else:
                        low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return -1

        first = firstbinarysearch(nums, target, 0, len(nums) - 1)
        if first == -1:
            return [-1, -1]
        last = lastbinarysearch(nums, target, first, len(nums) - 1)
        return [first, last]#
