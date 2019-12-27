class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        """
        // Time Complexity :
                            O(logn) 'n' is the number of elements in the list
        // Space Complexity :
                            O(1) Constant
        // Did this code successfully run on Leetcode :
                            Yes
        // Any problem you faced while coding this :
                            Took a long time to handle two elements in the list
        // Your code here along with comments explaining the approach
            We do a simple binary search. The interesting thing about the problem
            is we will always have one peak for sure. If the list is in increasing
            order the last number is the peak and if decreasing the first number is
            the peak. With this pattern, we just need to check after finding the mid
            (if it is not greater than its neighbour) which ever is greater than it
            we go towards that because doing so we are 100% sure there are only two
            options ie. a number can be greater than it or lesser than it. We keep
            doing this recursively.
        """
        start = 0
        end = len(nums) - 1
        while start < end:
            mid = (start + end) // 2
            if nums[mid - 1] < nums[mid] and nums[mid + 1] < nums[mid]:
                return mid
            if nums[mid + 1] > nums[mid]:
                start = mid + 1
            elif nums[mid - 1] > nums[mid]:
                end = mid - 1
        return start
