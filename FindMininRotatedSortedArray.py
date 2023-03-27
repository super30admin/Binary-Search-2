#Time Complexity: O(log n)
# Space Complexity: O(1)
# Approach: In each iteration of the binary search, we check if the middle element is smaller than the previous element. 
# If this condition is true, then the middle element is the minimum value. 
# Otherwise, we need to check which half of the array the minimum value is in and continue the binary search in that half.


class Solution:
    def findMin(self, nums: List[int]) -> int: 
        if not nums:
            return -1
        
        low = 0
        high = len(nums) - 1
        minimum = nums[0]

        while low<=high:
            mid = (low + high) // 2
            if nums[mid] < minimum:
                minimum = nums[mid]
                
            if nums[mid] >= nums[0]:
                low = mid + 1
            else:
                high = mid - 1

        return minimum
        