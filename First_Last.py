# Time Complexity : O(logn) -> 2 binary search = O(2logn) = O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Your code here along with comments explaining your approach
# Find first occurence of target using firstposition function- returns the first index
# Check if firstposition function returns -1 then no target exists.
# Else find the last position of the target using other lastposition function similar to first.
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def firstposition(nums,target,l,r):
            while l <= r:
                mid = l + (r - l)// 2
                if nums[mid] == target:
                    if mid == 0 or nums[mid -1] != target:
                        return mid
                    else:
                        r = mid - 1
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    r = mid - 1
            return -1

        def lastposition(nums,target,l ,r):
            while l <= r:
                mid = l + (r - l) // 2
                if nums[mid] == target:
                    if mid == n or nums[mid+1] != target:
                        return mid
                    else:
                        l = mid + 1
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    r = mid - 1
            return -1

        n = len(nums) -1
        first = firstposition(nums,target,0,n)
        if first == -1:
            return [-1,-1]
        last = lastposition(nums,target,0 ,n)
        return [first,last]
        