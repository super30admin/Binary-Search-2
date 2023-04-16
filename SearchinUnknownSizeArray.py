# https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/


# Compare this snippet from Binary-Search-1\SearchInfiniteArray.py:
# # Search in Infinite Array (https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/)
#
# # Time Complexity : O(logn)
# # Space Complexity : O(1)
# # Did this code successfully run on Leetcode : Yes
# # Any problem you faced while coding this : No

class Solution(object):
    def search(self, reader, target):
        """
        :type reader: ArrayReader
        :type target: int
        :rtype: int
        """

        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high = high * 2

        while low <= high:
            mid = low + (high - low)//2

            if reader.get(mid) == target:
                return mid

            elif reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1

