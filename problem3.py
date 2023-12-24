""" The algorithm uses a binary search to find the peak element in an unsorted array. We uses binary
    search such if the first or the last element are not the peaks, then we keep checking the mids until
    we find the peak through binary search.
    Time Complexcity: O(log n)
    Space Complexcity: O(1)
"""


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if (nums == None or len(nums) == 0):
            return -1
        n = len(nums)
        low = 0
        high = n - 1

        while(low < high):
            mid = low + int((high-low)/2)
            # edge cases to check if the first or the last element are the peaks
            if(mid == 0 and nums[mid] > nums[mid + 1]):
                return mid
            elif(mid == high and nums[mid] > nums[mid - 1]):
                return high
            elif nums[mid] < nums[mid+1]:
                low = mid+1
            else:
                high = mid
        return low


