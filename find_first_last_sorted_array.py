# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach in three sentences only

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # doing binary search which will traverse left side and get us the fist index of target
        def primaryBinarySearch(nums: List[int], target: int) -> int:
            low, high = 0, len(nums) - 1
            first = -1  # By default setting -1, if target not found it will return -1
            while low <= high:
                mid = low + (high - low) // 2  # preventing overflow
                if nums[mid] == target:  # Check if mid matches target
                    first = mid  # If target matches mid, setting first as mid
                    high = mid - 1  # Search left side to see if any target found
                elif nums[mid] < target:  # if mid element less than target, target is present right side
                    low = mid + 1  # Search on right side
                else:  # If mid element greater thean target, target is on the left side
                    high = mid - 1  # Search on left side
            return first  # return index

        # doing binary search which will traverse right side and get us the last index of target
        def secondaryBinarySearch(nums: List[int], target: int) -> int:
            low, high = 0, len(nums) - 1
            last = -1  # By default setting -1, if target not found it will return -1
            while low <= high:
                mid = low + (high - low) // 2  # preventing overflow
                if nums[mid] == target:  # Check if mid matches target
                    last = mid  # If target matches mid, setting last as mid
                    low = mid + 1  # Search right side to see if any target found
                elif nums[mid] < target:  # if mid element less than target, target is present right side
                    low = mid + 1  # Search on left side
                else:  # If mid element greater thean target, target is on the left side
                    high = mid - 1  # Search on right side
            return last  # return index
            # Get the output of each function as list

        return [primaryBinarySearch(nums, target), secondaryBinarySearch(nums, target)]

