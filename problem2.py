""" The alogorithm uses binary search to find the minumum element in the given rotated array.
    We first check the array to see if we reached the sorted range, by doing so we get the low pointer.
    Then I did a binary search from that lowest to the highest (last) element of the array to get the
    element.
    Time Complexcity: O(log n)
    Space Complexcity: O(1)
"""


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if (nums == None or len(nums) == 0):
            return -1
        n = len(nums)
        low = 0
        high = n - 1
        while(low <= high):
            #checking if we reached a range that is sorted
            if(nums[low] <= nums[high]):
                return nums[low]
            mid = low + (high -low) //2
            # checking the neighbors
            if((mid == 0 or nums[mid] < nums[mid - 1]) and (nums[mid] < nums[mid + 1])):
                return nums[mid]
            elif (nums[low] <= nums[mid]):
                low = mid + 1
            else:
                high = mid - 1
        