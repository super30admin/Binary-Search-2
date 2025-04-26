# Time Complexity :  O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes      
# Any problem you faced while coding this : No  

# Your code here along with comments explaining your approach: This code implements a modified binary search to find the minimum element in a rotated sorted array. It compares the middle element with its neighbors to check if it's the minimum, and adjusts the search range based on whether the right half is sorted (moving left) or not (moving right). The algorithm runs in O(log n) time and returns the minimum element when found or when the search range narrows to one element.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        n = len(nums) - 1

        while(low < high):
            if nums[low] < nums[high]:
                return nums[low]
            
            mid = low + (high - low) // 2
            if ((mid == 0 or nums[mid] < nums[mid - 1] ) and nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif (nums[mid] < nums[high]):
                high = mid - 1
            else:
                low = mid + 1
        
        return nums[low]
