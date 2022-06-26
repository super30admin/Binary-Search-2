# Time Complexity = O(logn)
# Space Complexity = O(1)

class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return 0
        
        low = 0
        high = len(nums) - 1
        
        while (low <= high):
            mid = low + ((high - low) // 2)
            
            # If middle element is peek element
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            
            # Check the elements before and after mid, proceed towards the larger element
            elif nums[mid + 1] > nums[mid] or mid == len(nums) - 1 :   # Move rightwards
                low = mid + 1
                
            else:
                high = mid - 1
                
        
            