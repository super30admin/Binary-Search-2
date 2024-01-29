class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        firstIndex = -1
        lastIndex = -1
        n = len(nums)-1
        low = 0
        high = n

        while low <= high and firstIndex == -1:
            mid = low + (high - low)//2

            if nums[mid] == target:
                if mid == 0 or nums[mid-1] < nums[mid]:
                    firstIndex = mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        if firstIndex != -1:
            low = firstIndex
            high = n

            while low <= high and lastIndex == -1:
                mid = low + (high - low)//2

                if nums[mid] == target:
                    if mid == n or nums[mid] < nums[mid + 1]:
                        lastIndex = mid
                    else:
                        low = mid + 1
                elif nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1

        return [firstIndex, lastIndex]
