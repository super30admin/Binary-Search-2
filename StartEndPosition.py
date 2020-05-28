# Time Complexity :  O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this : I had trouble with understanding
# the concept but it was easier to code the solution after the session

# Your code here along with comments explaining your approach
class Solution(object):
    def searchRange(self, nums, target):
        # if array empty return [-1, -1]
        if(len(nums) == 0):
            return [-1, -1]
        # binary search to find start index
        start = self.binarySearchLeft(nums, target, 0, len(nums)-1)
        # binary search to find end index
        end = self.binarySearchRight(nums, target, 0, len(nums)-1)
        return [start, end]

    def binarySearchLeft(self, nums, target, left, right):
        while left <= right:
            mid = left + (right - left) / 2
            # if target at mid
            if nums[mid] == target:
                # check if mid is the first occurrence of the target
                if mid == 0 or nums[mid] > nums[mid-1]:
                    return mid
                # else there is another occurrence of target
                # before mid index, search in left array.
                else:
                    right = mid - 1
            # else if first occurrence of target in left array
            elif nums[mid] > target:
                right = mid - 1
            # else first occurrence of target in right array
            else:
                left = mid + 1
        return -1

    def binarySearchRight(self, nums, target, left, right):
        while left <= right:
            mid = left + (right - left) / 2
            # if target at mid
            if nums[mid] == target:
                # check if mid is the last occurrence of the target
                if mid == len(nums)-1 or nums[mid] < nums[mid+1]:
                    return mid
                # else there is another occurrence of target
                # after mid index, search in right array
                else:
                    left = mid + 1
            # else if last occurrence of target in left array.
            elif nums[mid] > target:
                right = mid - 1
            # else last occurrence of target in right array.
            else:
                left = mid + 1
        return -1

nums = [5, 7, 8, 8, 8, 9, 10]
target = 8
s = Solution()
print s.searchRange(nums, target)

