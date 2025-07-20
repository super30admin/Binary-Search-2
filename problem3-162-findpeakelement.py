#Time Complexity : logn2n
#Space Complexity 0(1)
#here we want to find peak element and when we get mid and if it's not peak element then compare it's neighbour and always go to higher element side
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        if nums == None or len(nums) == 0:
            return -1

        if len(nums) == 1:
            return 0

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if (mid == low or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1]):
                return mid
            elif nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1
