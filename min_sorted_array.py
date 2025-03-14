"""
This solution finds the minimum element in a rotated sorted array using binary search. 
It maintains a `result` variable to track the minimum and leverages the fact that in a rotated array, the smallest element lies in the unsorted half. 
By comparing `nums[mid]` with `nums[left]`, it adjusts the search range efficiently, achieving an O(log N) time complexity.
Space Complexity: O(1)
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        result = nums[0]
        left = 0
        right = len(nums) - 1

        while left <= right:
            if nums[left] < nums[right]:
                result = min(result, nums[left])
                break
            
            mid = (left + right) // 2
            result = min(result, nums[mid])

            if nums[mid] >= nums[left]:
                left = mid + 1
            else:
                right = mid - 1
        
        return result