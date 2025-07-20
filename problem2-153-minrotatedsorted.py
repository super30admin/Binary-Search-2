#Time Complexity : logn2n
#Space Complexity 0(1)
#here rotated sorted array if we deide from mid we will get one sorted array and one normal array and min never lies in sorted array so go with other part and do binary sear
#min how you can find if it's min from from previous and next element then it's min
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        if len(nums) == 1:
            return nums[0]

        while low <= high:
            mid = (low + high) // 2
            if nums[low] <= nums[high]:
                return nums[low]
            elif (mid == low or nums[mid] < nums[mid - 1]) and (mid == high or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:  # left sorted
                low = mid + 1
            else:
                high = mid - 1