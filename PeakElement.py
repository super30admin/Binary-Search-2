# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  yes
# Any problem you faced while coding this : no


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        #initialize the left and right
        left = 0
        right = len(nums) - 1

        #loop all elements
        while left <= right:

            #calculat mid - this way prevents the overflow
            mid = left + (right - left) // 2

            #this technically checks 3 condition: if first element and next element is smaller, last element and previous element is smaller, if previous and next of mid is smaller than mid
            if (mid == 0 or nums[mid - 1] < nums[mid]) and (mid == len(nums) - 1 or nums[mid + 1] < nums[mid]):
                return mid

            else:
                #if previous of the mid is greater we move the riight towards mid else we move left towards mid
                if mid > 0 and nums[mid] < nums[mid - 1]:

                    right = mid - 1

                else:

                    left = mid + 1

        return -1