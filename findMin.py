class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1
        while l <= h:
            mid = (l+h)//2

            if nums[l] <= nums[h]:
                return nums[l]
            elif (mid != 0 and nums[mid] < nums[mid-1]) and (mid != len(nums)-1 and nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[l] <= nums[mid]:
                l = mid + 1
            else:
                h = mid -1

        return -1