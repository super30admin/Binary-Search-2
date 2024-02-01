class Solution:
    def binarysearchFirst(
        self, numarr: List[int], low: int, high: int, target: int
    ) -> int:
        while low <= high:
            mid = low + (high - low) // 2
            if numarr[mid] == target:
                if mid == 0 or numarr[mid] > numarr[mid - 1]:
                    return mid
                else:
                    high = mid - 1
            elif numarr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binarysearchLast(
        self, numarr: List[int], low: int, high: int, target: int
    ) -> int:
        n = len(numarr)
        while low <= high:
            mid = low + (high - low) // 2
            if numarr[mid] == target:
                if mid == n - 1 or numarr[mid] < numarr[mid + 1]:
                    return mid
                else:
                    low = mid + 1
            elif numarr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1, -1]
        n = len(nums)
        if target < nums[0] or nums[n - 1] < target:
            return [-1, -1]

        first = self.binarysearchFirst(nums, 0, n - 1, target)
        if first == -1:
            return [-1, -1]
        last = self.binarysearchLast(nums, first, n - 1, target)
        return [first, last]
