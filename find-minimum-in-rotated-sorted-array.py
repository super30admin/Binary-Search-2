# // Time Complexity : O(Log N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution:
    def findMin(self, nums: List[int]) -> int:
        start , end = 0, len(nums) - 1 
        curr_min = 5000 #Max Allowed Number in the question
        
        while start  <  end :
            mid = (start + end ) // 2
            curr_min = min(curr_min,nums[mid])
            
            # right has the min 
            if nums[mid] > nums[end]:
                start = mid + 1
                
            # left has the  min 
            else:
                end = mid - 1 
                
        return min(curr_min,nums[start])
