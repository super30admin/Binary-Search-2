# Problem-2:  #153. Find Minimum in Rotated Sorted Array
# Author : Akaash Trivedi
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes #153
# Any problem you faced while coding this : No

# Approach:
# Min is the Pivot element in rotated sorted array. 
# Check if the current range is sorted, yes then min is array[low] or starting idx
# Find mid and check which side is sorted. Check on unsorted side. **Min will always be on on the unsorted side**


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = n = len(nums) -1

        while (low <= high):
            # check if current range is sorted
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high - low) //2
            # print(low, " + ", high, "-", low, "/ 2 = ",mid)

            # check if mid is the min with its neighbors 
            if ( mid == 0 or nums[mid] <= nums[mid-1]) and (nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[mid] >= nums[low]:
                low = mid + 1
            else:
                high = mid - 1
        return -1