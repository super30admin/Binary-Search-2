# // Time Complexity : O(log n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only
# We are initally checking for base cases where if the array is empty or if the target exists inside the array
# If it exists then we are using binary search to determine the first occurence of the target element and same for the last occurence
# If the mid is equal to the target then we reduce our search to see if the target resides on the left or right side of the mid and then perform binary search ahead


class Solution:

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        if nums == None or n == 0:
            return [-1,-1]
        if nums[0] > target and nums[-1] < target:
            return [-1,-1]

        def binary_search_first(nums, target, n):
            l = 0
            h = n - 1
            while(l <= h):
                mid = int((l+h)/2)
                if nums[mid] == target:
                    if mid == 0 or nums[mid-1] < nums[mid]:
                        return mid
                    else:
                        h = mid - 1
                elif nums[mid] > target:
                    h = mid - 1
                else:
                    l = mid + 1
            return -1

        def binary_search_last(l, h, nums, target):
            while(l<=h):
                mid = int((l+h)/2)
                if nums[mid] == target:
                    if (mid == len(nums)-1) or (nums[mid] < nums[mid+1]):
                        return mid
                    else:
                        l = mid + 1
                elif nums[mid] < target:
                    l = mid + 1
                else:
                    h = mid - 1

        first = binary_search_first(nums, target, n)
        if first == -1:
            return [-1,-1]
        last = binary_search_last(first, n-1, nums, target)
        return [first, last]