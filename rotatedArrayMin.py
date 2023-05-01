class Solution:
    def findMin(self, nums):

        low = 0
        high = len(nums) - 1

        while low <= high:
            if(nums[low] < nums[high]):
                return nums[low]

            med = low + (high - low) // 2

            if ((med == low or nums[med-1] > nums[med]) and (med == high or nums[med+1] > nums[med])):
                return nums[med]

            elif nums[low] <= nums[med]:
                low = med + 1
            else:
                high = med - 1

      

nums = [3, 4, 5, 1, 2]
res = Solution()
output = res.findMin(nums)
print(output)
