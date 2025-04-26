# Time Complexity :  O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes      
# Any problem you faced while coding this : No  

# Your code here along with comments explaining your approach: We use Binary Search to achieve time complexity of log time. For this when mid element is calculated, if that element is greater than its immediate neighbors, return that index. Otherwise if the mid element is lesser than its left element, then peak will occur in the left part because-the left element can be 0th index in which case 0th index would be peak. Also if the left element is lesser than left's left element, somewhere in the left chunk we will find the peak.Similarly, if mid element is lesser than its right element, then peak occurs somewhere in the right part with the same logic.


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        n = len(nums) - 1

        while low < high:
            mid = low + (high - low) // 2
            if ((mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):
                return mid
            elif mid > 0 and nums[mid] < nums[mid - 1]:
                high = mid - 1
            elif nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                break

        return low  