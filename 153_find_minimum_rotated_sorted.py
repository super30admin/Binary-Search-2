class Solution:
    def findMin(self, nums: [int]) -> int:
        """
        // Time Complexity :
                            O(logn) 'n' is the number of elements in the list
        // Space Complexity :
                            O(1) Constant
        // Did this code successfully run on Leetcode :
                            Yes
        // Any problem you faced while coding this :
                           Took a lot of time to understand the difference between
                           searching for a target in rotated sorted v/s this problem.
        // Your code here along with comments explaining the approach
            We do a simple binary search. The interesting thing about the problem
            is we will can completely omit one half after comparing the start end end
            values. The reason being this a sorted in a rotated manner with unique numbers.
            If the last element is greater than the current mid then all number after that
            are greater than the current mid. We donot need to search after mid and vice versa.
        """
        start = 0
        end = len(nums) - 1
        while start < end:
            mid = (start + end) // 2
            if nums[end] < nums[mid]:  # mid > end
                start = mid + 1
            else:
                # start < mid or mid > start
                end = mid
        return nums[start]


if __name__ == '__main__':
    h = Solution()
    # Sample test case for '''end = mid - 1 '''
    print(h.findMin([3, 1, 2]))
    print(h.findMin([1, 2]))
