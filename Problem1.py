## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def findFirst(low: int, high: int) -> int:
            while low <= high:
                mid = low + (high - low) // 2
                
                if nums[mid] == target and (mid == 0 or nums[mid - 1] < nums[mid]):
                    return mid
                elif nums[mid] < target: # If it's too small, go right
                    low = mid + 1
                else: # If it's too big, OR it equals the target but isn't the first one, go left
                    high = mid - 1
            return None # Moved OUTSIDE the while loop

        def findLast(low: int, high: int) -> int:
            while low <= high:
                mid = low + (high - low) // 2
                
                if nums[mid] == target and (mid == n - 1 or nums[mid] < nums[mid + 1]):
                    return mid
                elif nums[mid] > target: # If it's too big, go left
                    high = mid - 1
                else: # If it's too small, OR it equals the target but isn't the last one, go right
                    low = mid + 1
            return None # Moved OUTSIDE the while loop



        # Get array length and set initial binary search pointers
        n = len(nums)
        left, right = 0, n - 1

        # Edge case 1: The array is empty
        if n == 0:
            return [-1, -1]

        # Edge case 2: The array has only one element, and it matches the target
        if n == 1 and nums[0] == target:
            return [0, 0]

        # Initialize default results in case the target is never found
        first = last = -1

        # Main binary search to find ANY occurrence of the target
        while left <= right:
            mid = left + (right - left) // 2
            
            # Target found! Now we need to find its exact start and end bounds
            if nums[mid] == target:
                
                # Search the left half (from 'left' to 'mid') to find the very first occurrence
                first = findFirst(left, mid)
                # If findFirst returns None, it means no earlier target exists, so 'mid' is the first
                first = first if first is not None else mid
                
                # Search the right half (from 'mid' to 'right') to find the very last occurrence
                last = findLast(mid, right)
                # If findLast returns None, it means no later target exists, so 'mid' is the last
                last = last if last is not None else mid
                
                # We found both bounds, exit the main loop
                break
                
            # If the current number is too small, search the right half
            elif nums[mid] < target:
                left = mid + 1
                
            # If the current number is too big, search the left half
            else:
                right = mid - 1

        # Return the final boundaries (will be [-1, -1] if target was never found)
        return [first, last]
    


obj = Solution()
arr = [1, 1, 2]
target = 1
print("target found at:", obj.searchRange(arr, target))