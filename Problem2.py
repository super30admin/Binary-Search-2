# Solution is based on the fact that the minimum is present at the unsorted side. If low is less than high, return 0th index as it is sorted
# Compare the left and right element of mid, if both are lesser than mid then return

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1

        while low <= high :
            mid = low + (high - low)//2
            if nums[low] <= nums[high]:
                return nums[low]
            if ((mid==0 or nums[mid]< nums[mid-1]) and (nums[mid]< nums[mid+1])):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1

            else:
                high = mid-1


        return -1