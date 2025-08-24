"""
Space Complexity: O(1)
Time Complexity: O(log(n))
"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        low = 0
        high = len(nums) - 1

        while low <= high: 
            mid = low + (high - low) // 2

            # Check if the current element is peak, if so, return it
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]): 
                return mid

            # Move towards the side which is greater than the current. In this case, if the right hand side is greater than 
            # current, move there, as we are bound to get a solution in that space. 
            elif nums[mid] < nums[mid+1]: 
                low = mid + 1
    
            else: 
                high = mid - 1

        
