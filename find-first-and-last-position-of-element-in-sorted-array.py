# Use 2 binary search to find the start index of the target
# Use binary search to find the end index of the target
class Solution:

    def searchStartIndex(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = start + ((end-start)//2)
            if nums[mid] == target:
                if mid > 0 and nums[mid-1] == target:
                    end = mid - 1
                else:
                    return mid
            elif nums[mid] < target:
                start = mid + 1
            else:
                end = mid - 1

        return -1

    def searchEndIndex(self, nums: List[int], target: int) -> int:
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = start + ((end-start)//2)
            if nums[mid] == target:
                if mid < (len(nums)-1) and nums[mid+1] == target:
                    start = mid + 1
                else:
                    return mid
            elif nums[mid] < target:
                start = mid + 1
            else:
                end = mid - 1

        return -1


    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = [-1, -1]
        if len(nums) < 1:
            return res

        return [self.searchStartIndex(nums, target), self.searchEndIndex(nums, target)]

