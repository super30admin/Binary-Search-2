# Find first and last pos in sorted array.

# // Time Complexity : O(log(N))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach in three sentences only


# Use binary search to find leftmost occurance and rightmost occurance.
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = []

        # Find LeftMost
        left = 0
        right = len(nums) - 1
        leftIdx = len(nums)
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                leftIdx = min(leftIdx,mid)
                right = mid - 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1

        # Find RightMost
        left = 0
        right = len(nums) - 1
        rightIdx = -1
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] == target:
                rightIdx = max(rightIdx,mid)
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        
        if leftIdx == len(nums):
            return [-1,-1]
        return [leftIdx,rightIdx]
    



# Find minimum in rotated sorted array

# // Time Complexity : O(log(N))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach in three sentences only


class Solution:
    def findMin(self, nums: List[int]) -> int:
        N = len(nums)
        start = 0
        end = N - 1
        if N == 1:
            return nums[0]
        res = float('inf')
        while start <= end:
            if nums[start] <= nums[end]:
                return min(res, nums[start])
            mid = start + (end - start) // 2
            res = min(res, nums[mid])
            if nums[mid] >= nums[start]:
                start = mid + 1
            else:
                end = mid - 1
        return res 
    

# Find PEAK ELEMENT

# // Time Complexity : O(log(N))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach in three sentences only
# Peak element would be bigger than both it's neighbours. We just have to take care of the edge cases where the neighbours would give out of bounds.
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1

        if len(nums) == 1:
            return 0

        while left <= right:
            mid = (left + right) // 2
            
            elementLeft = -float('inf') if mid-1 == -1 else nums[mid-1]
            elementRight = -float('inf') if mid+1 == len(nums) else nums[mid+1]
            

            if nums[mid] > elementLeft and nums[mid] > elementRight:
                return mid 
            else:
                if elementLeft > elementRight:
                    right = mid - 1
                else:
                    left = mid + 1