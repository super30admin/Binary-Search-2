# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach

# Keep climbing towards the peak
#loop continues as long as low < high. When low == high, peak found
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
		low = 0



		high = len(arr) - 1



		while low <= high:



			mid = low + (high - low)//2



			if (mid == 0 or arr[mid] > arr[mid - 1]) and (mid == len(arr) - 1 or arr[mid] > arr[mid + 1]):



				return mid



			elif mid > 0 and arr[mid] < arr[mid - 1]:



				high = mid - 1



			else:



				low = mid + 1



		return -1