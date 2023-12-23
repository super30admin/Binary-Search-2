#Time Complexity= O(log n)
#Space Complexity= O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # This function will find the elements in the Left Side
        def findLeftBound(nums, target):
            index = -1
            low, high = 0, len(nums) - 1

            # Perform Binary Search Operation
            while low <= high:
                mid = low + (high - low) // 2  # Prevent Overflow conditions

                # Check if nums[mid] == target
                if nums[mid] == target:
                    index = mid  # Set index = mid
                    high = mid - 1  # Look into the left subarray

                # Check if target is greater than nums[mid] or not
                elif nums[mid] < target:
                    low = mid + 1  # Set low = mid + 1
                else:
                    high = mid - 1  # Set high = mid - 1

            return index  # This would return the first Index

        # This function will find the elements in the Right Side
        def findRightBound(nums, target):
            index = -1
            low, high = 0, len(nums) - 1  # low = 0 and high = len(nums) - 1

            # Standard binary Search
            while low <= high:
                mid = low + (high - low) // 2  # Prevent Overflow Condition

                # Check if nums[mid] == target
                if nums[mid] == target:
                    index = mid  # Set index to mid
                    low = mid + 1  # Look in the right sub-array

                # Check if nums[mid] < target
                elif nums[mid] < target:
                    low = mid + 1  # Set low = mid + 1
                else:
                    high = mid - 1  # Set high = mid - 1

            return index  # Return the last Index

        left = findLeftBound(nums, target)
        right = findRightBound(nums, target)
        return [left, right]
