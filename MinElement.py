# Time Complexity: O(log n )
# Space Complexity: O(1)
# Procedure: first we check mid is less than mid -1 : if yes - return mid value
# -> if not : check which side is sorted , perfrorm bs on non sorted side and compare mid with its adjacent neighbour
# -> note minimum lies in unsoreted side
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = (low + high) // 2
            if nums[low] < nums[high]:
                return nums[low]
            
            # Check if mid is the minimum value
            if nums[mid] < nums[mid-1]:
                return nums[mid]
            
            # Check if the minimum value is in the right half
            if nums[mid] > nums[high]:
                low = mid + 1
            # Check if the minimum value is in the left half
            else:
                high = mid - 1
        
        # Return the minimum value at the end
        return nums[low]
