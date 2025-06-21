# Time Complexity: O(log n)
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        if not nums or len(nums) == 0:
            return None

        
        start = 0
        end = len(nums)-1

        while(start< end):
            mid = start + (end-start)//2
            # check if mid element is greater than its next element then assign end to mid, else assign start to mid+1
            # this way we are always moving towards the peak element
            if nums[mid] >= nums[mid+1]:
                end = mid
            else:
                start = mid + 1
        return start