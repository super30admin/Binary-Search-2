class Solution:
    def findMin(self, nums: list[int]) -> int:
        if nums[0] <= nums[-1]:
            return nums[0]
        else:
            start = 0
            end = len(nums) - 1
            while start <= end:
                mid = start + (end-start)//2
                if nums[mid] > nums[mid+1]:
                    return nums[mid + 1]
                elif nums[start] <= nums[mid]:
                    start = mid + 1
                else:
                    end = mid - 1


check = Solution()
print(check.findMin([4, 5, 6, 7, 0, 1, 2]))
