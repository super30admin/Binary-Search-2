# // Time Complexity : O(log n )
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
class Solution:
    def findMin(self, nums: List[int]) -> int:
        start, end = 0, len(nums) - 1
        
        while(start <= end):
            #if start is less than or equal to end
            if(nums[start]<=nums[end]):
                return nums[start]
            
            
            mid = (start + end) // 2
            
            #if mid-1 is GT mid than mid is the minimum element
            if(mid != 0 and nums[mid] < nums[mid-1]):
                return nums[mid]
            
            #if array is left sorted then move to right
            if nums[start] <= nums[mid]: #left sorted
                start = mid + 1
            else:
                end = mid - 1
        return -1