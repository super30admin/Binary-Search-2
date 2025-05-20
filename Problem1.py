class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        # first position is nums[mid]==target and nums[mid-1] is not element
        # last position is nums[mid] == target and nums[mid+1] is not element
        N = len(nums)
        low = 0
        high = N - 1
        firstPosition = -1
        lastPosition = -1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                firstPosition = mid
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        low = 0
        high = N - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                lastPosition = mid
                low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return [firstPosition, lastPosition]
