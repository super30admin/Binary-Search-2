# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No issues

from typing import List

class Solution:

    def findPeakElement(self, nums: List[int]) -> int:

        n = len(nums)

        # handle tiny arrays first
        if n == 1:
            return 0
        
        # check peak at the very beginning
        if nums[0] > nums[1]:
            return 0
        
        # check peak at the very end
        if nums[n-1] > nums[n-2]:
            return n-1
        

        # now the peak must be somewhere in between 1 & n-1
        low = 1
        high = n-2

        while low <= high:

            mid = (low + high) // 2
            
            # found a peak
            if nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                return mid
            
            # if the slope is rising to the right, go right
            if nums[mid] < nums[mid + 1]:
                low = mid + 1
            # otherwise go left
            else:
                high = mid - 1

if __name__ == "__main__":

    sol = Solution()

    print(sol.findPeakElement([1,2,3,1]))          # expects 2
    print(sol.findPeakElement([1,2,1,3,5,6,4]))    # expects 1 or 5
    print(sol.findPeakElement([42]))               # expects 0
    print(sol.findPeakElement([5,4,3,2,1]))        # expects 0 (first is peak)
    print(sol.findPeakElement([1,2,3,4,5]))        # expects 4 (last is peak)
