# Time Complexity : O(logN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach

    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
	low = 0
	high = len(nums) - 1

	while(low < high):

			if nums[low] == nums[high]:

				return nums[low]

			mid = low + (high - low)//2

			if (mid == 0 or nums[mid] < nums[mid - 1]) and nums[mid] < nums[mid + 1]:

				return nums[mid]

			else:

				if nums[mid] > nums[high]:

					low = mid + 1

				else:

					high = mid - 1

	return nums[low]