## Time complexity : O(log(n)), we search half of the array at every time step
# Space complexity : O(1), space to maintain left and right pointers
# The code ran on github

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        l = 0; h = n - 1
        if len(nums) == 1:return 0
        while l <= h:
            mid = l + (h-l)//2
            # Check if the mid pointer is at beginning or end of the array and is a peak
            if (mid == 0 and nums[mid] > nums[mid+1]) or (mid == n-1 and nums[mid] > nums[mid-1]):
                return mid
            elif nums[mid-1] < nums[mid] and nums[mid] > nums[mid+1]:
                return mid 
            # Check elements in the neighborhood of mid and move towards the half with higher value. We will definitely find a peak in that direction
            elif nums[mid+1] > nums[mid - 1]:
                l = mid + 1
            else:
                h = mid - 1
        