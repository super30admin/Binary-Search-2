# Couldn't find the solution for when there is no peak Eg : [8,7,5,2,5,7,8]
# Curious about the case where nums[i] == nums[i+1]
# Time com : O(logn) Space Com : O(1)
# No leetcode link to run the code
# Didn't understand meaning of nums[-1] = nums[n] = -∞

class Solution:
    def findPeak(self,nums):
        low = 0
        high = len(nums)-1
        while low < high:
            mid = (low+high)//2


            if nums[mid-1] < nums[mid] and nums[mid] > nums[mid+1]:
                return mid
            elif nums[mid+1] > nums[mid]:
                low = mid+1
            else nums[mid-1] > nums[mid]:
                high = mid-1
