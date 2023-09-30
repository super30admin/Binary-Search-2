# Time Complexity - O(log n)
# Space Complexity - O(1)

# Approach - Based on multiple examples, we can understand that if the array is rotated, the 
# minimum will always be in non-sorted half of the array. We need to find the half that is not 
# sorted and check for smallest value using binary search

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0; high = len(nums) - 1
        min_ele = float('inf')
        while (low <= high):
            mid = low + (high - low) // 2
            min_ele = min(min_ele, nums[mid])
            if nums[low] <= nums[mid]:
                # Left half is sorted and need to check in the other half for the minimum element
                if nums[mid] <= nums[high]:
                    high = mid - 1
                else:
                    low = mid + 1
            else:
                # right half is sorted and need to check the other half for the min element
                if nums[low] <= nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1
            
        return min_ele
    