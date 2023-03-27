"""
when we look at the array. it is noted than one part is always sorted
we need to find the place of zero so that we can know how mamy times it is sorted
main logic is if the left element is greater than right element we found the value we are looking for

#tc: o(logn)
#sc: 0(1)
"""



class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 123456

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if nums[low] <= nums[high]:
                return nums[low]
            if (mid == 0 or nums[mid] < nums[mid - 1]):
                return nums[mid]
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return 7654321