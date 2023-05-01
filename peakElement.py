#Time Complexity: O(log n)
#Space Complexity: O(1)

class Solution:
    def findPeakElement(self, nums):
        low = 0
        high = len(nums) - 1

        while low <= high:
            med = low + (high - low) // 2

            if ((med == low and nums[med] > nums[med+1]) or (med == high and nums[med] > nums[med-1]) or (nums[med] > nums[med-1] and nums[med] > nums[med+1])):
                return med
            
            elif (nums[med] < nums[med+1]):
                low = med + 1

            else:
                high = med - 1
            
        return -1
    

nums = [1, 2, 1, 3, 5, 6, 4]
res = Solution()
output = res.findPeakElement(nums)
print(output)

