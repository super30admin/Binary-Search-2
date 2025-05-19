# Find the middle element (mid).
# Decide which half to discard based on sorted properties.
# The minimum element lies in the unsorted half.
# Continue until find the smallest element.
# Time Complexity: O(log n)
# Space Complexity: O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        low = 0
        high = n - 1
        minimum = float("inf")
        
        while low <= high:
            mid = (low + high) // 2
            
            # If left half is sorted
            if nums[low] <= nums[mid]:
                minimum = min(minimum, nums[low])  # Update minimum
                low = mid + 1  # Search in the right half
            else:  # Right half is sorted
                minimum = min(minimum, nums[mid])  # Update minimum
                high = mid - 1  # Search in the left half
        
        return minimum  # Return the smallest element


# Approach2:
# It uses a modified binary search by checking if the middle element is smaller than its neighbors to identify the pivot. To handle duplicates, it reduces the search space when arr[low] == arr[high] instead of returning immediately, which avoids incorrect early termination.

    # def findMin(self, arr):
    #     low = 0
    #     high = len(arr) - 1

    #     while low <= high:
    #         # Handle duplicates: reduce search space conservatively
    #         if arr[low] == arr[high]:
    #             high -= 1
    #             continue

    #         mid = low + (high - low) // 2

    #         # Check if mid is the minimum
    #         if (mid == 0 or arr[mid] < arr[mid - 1]) and (mid == len(arr) - 1 or arr[mid] < arr[mid + 1]):
    #             return arr[mid]

    #         # Decide which half to search
    #         if arr[mid] > arr[high]:
    #             low = mid + 1
    #         else:
    #             high = mid - 1

    #     # Fallback if not found in loop
    #     return arr[low] if low < len(arr) else arr[0]
         