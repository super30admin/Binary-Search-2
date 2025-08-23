## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

# (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

# Find the minimum element.

# You may assume no duplicate exists in the array.

# Example 1:
# Input: [3,4,5,1,2]
# Output: 1

# Example 2:
# Input: [4,5,6,7,0,1,2]
# Output: 0

# Time Complexity : O(Log(base2)N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Divide the problem into cases. If array is already sorted, which we can check by low and high, then minimum would be at low index
# Then we get the mid. We check if mid is the minimum element by comparing it with its neighbors. If it is minimum, then we return the min
# else we check which half is sorted. The min will always lie in the unsorted half. So in this case reduce the search space to the 
# unsorted half and let go of the sorted half

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # In rotated sorted array, at least one half would always be sorted
        # If the part we are into is completed sorted, then 
        # minimum would be at low index
        # Then we find the mid. Check if it is itself the minimum
        # If yes then return else check for sorted side
        # If we have one side sorted and other side unsorted, then minimum
        # would always exist of the unsorted side
        # eg: [3,4,5,1,2], [4,5,6,7,0,1,2]. So in this case we check which is the sorted half and search the other half
        low = 0
        high = len(nums) - 1
        while(low <= high):
            if(nums[low] <= nums[high]):
                # this half is already sorted
                # low index element would be my lowest
                return nums[low]

            # we check which half is sorted
            mid = int(low + ((high - low) / 2))
            # check if the mid is the minimum
            if((mid == 0 or nums[mid - 1] > nums[mid]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1])):
                # middle is the minimum element
                return nums[mid]
            if(nums[low] <= nums[mid]):
                # left half is sorted
                # our minimum would exist on the right half
                low = mid + 1
            else:
                # right half is sorted
                # our minimum would exist on the left half
                high = mid - 1

        # return is not relevant, as minimum would always exist
        return -1


sol = Solution()
print(sol.findMin([3,4,5,1,2]))
print(sol.findMin([3]))
print(sol.findMin([4,5,6,7,0,1,2]))
print(sol.findMin([11,13,15,17]))