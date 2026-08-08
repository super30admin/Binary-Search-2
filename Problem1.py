#Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
# Time Complexity: O(log n),We run two separate binary searches, one for the first occurrence and one for the last occurrence. Each binary search cuts the search range in half every step, so each one takes O(log n) on its own and doing two of them one after another is still O(log n) overall.
# Space Complexity: O(1),We only use a few variables like low, high and mid. No extra data structures are created that grow with input size.
# Approach:
# A normal binary search finds any one index where the target sits, but here we need the first and last index of a run of duplicate values. 
#So we do binary search twice with a small twist each time.
# For the first occurrence, when we land on the target we check if there is another target sitting right before it.
# If yes we keep searching left, if no this is the first one.
# For the last occurrence, we check if there is another target sitting right after it.
# If yes we keep searching right, if no this is the last one.
# If the first search does not find the target at all, we know it does not exist in the array, so we skip the second search.


class Solution:
    def searchRange(self, nums, target):
        def binarySearchFirst(nums, target, low, high):
            # Standard binary search loop, keep going while there is still a valid range to check
            while low <= high:
                # Find the middle index of the current range
                mid = low + (high-low)//2
                if nums[mid] == target:
                    # We found a target, but there might be an earlier one to the left
                    # Check if this is the very first index of the array, or if the value before it is different from target
                    if mid == 0 or nums[mid-1] !=target:
                        # Nothing matching to the left, so this must be the first occurrence
                        return mid
                    else:
                        # There is another target right before mid, so keep searching further left
                        high = mid -1     
                elif nums[mid]>= target:
                    # The middle value is bigger than target, so the target if it exists must be to the left
                    high = mid -1
                
                else:
                    # The middle value is smaller than target, so the target must be to the right
                    low = mid +1
            # Loop finished without finding the target anywhere, it does not exist in the array
            return -1

        def binarySearchLast(nums,target,low,high):
            # Same idea as binarySearchFirst but mirrored to find the last occurrence
            while low <= high:
                # Find the middle index of the current range
                mid = low+ (high-low)//2
                if nums[mid] == target:
                    # We found a target, but there might be another one further right
                    # Check if this is the very last index of the array, or if the value after it is different from target
                    if  mid == len(nums)-1 or nums[mid+1]!=target:
                        # Nothing matching to the right, so this must be the last occurrence
                        return mid
                    else:
                        # There is another target right after mid, so keep searching further right
                        low = mid +1
                elif nums[mid]>= target:
                    # The middle value is bigger than target, so we move the upper bound down
                    high = mid -1
                else:
                    # The middle value is smaller than target, so we move the lower bound up
                    low = mid +1
            # Loop finished without finding the target anywhere in this range
            return -1
        
        # Run the first search across the whole array
        first = binarySearchFirst(nums, target, 0, len(nums)-1)
        if first == -1:
            # Target does not exist at all, no point running the last search
            return [-1,-1]
        
        # Target exists, so search for the last occurrence starting from where we found the first one
        # Starting at first instead of 0 saves us from rechecking indexes we already know are too small
        last = binarySearchLast(nums, target, first, len(nums) - 1)
        return [first,last]

