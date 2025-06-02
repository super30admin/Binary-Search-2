# # Problem 3: (https://leetcode.com/problems/find-peak-element/)
# // Time Complexity :O(Logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach in three sentences only
# here we need to find peak, there will be multiple peaks we can return any one ..for more clarity put input values on graph and check, we will do modified BS we will comapre mid with prev and 
# next elements or we will move to side where ele is greater than mid ..like we are climbing peak
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, h = 0, len(nums) - 1
        
        while l < h:
            mid = l + (h - l) // 2
            if nums[mid] > nums[mid + 1]:
                h = mid  # Peak is in the left half (including mid)
            else:
                l = mid + 1  # Peak is in the right half
        return l
