# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  yes but - I have commented a part of the code which is inverted condition check it fails with it,
#Can you please explain why it is failing?
# Any problem you faced while coding this : no




class Solution:
    def findMin(self, nums: List[int]) -> int:

        left = 0
        right = len(nums) - 1

        while left <= right:

            mid = left + (right - left) // 2

            if (mid == 0 or nums[mid - 1] > nums[mid]) and (mid == len(nums) - 1 or nums[mid + 1] > nums[mid]):
                return nums[mid]

            if nums[right] > nums[mid]:

                right = mid - 1
            else:

                left = mid + 1

        #             if nums[left] <= nums[mid]:

        #                 left = mid + 1

        #             else:

        #                 right = mid - 1

        return -1
