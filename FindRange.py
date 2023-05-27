from ast import List


class Solution:

    def firstOccurance(self, arr, n, target):
        start = 0
        end = n - 1
        mid = start + (end - start) // 2
        ans = -1

        while start <= end:
            if arr[mid] == target:
                ans = mid
                end = mid - 1
            elif arr[mid] < target:
                start = mid + 1
            elif arr[mid] > target:
                end = mid - 1
            mid = start + (end - start) // 2

        return ans

    def lastOccurance(self, arr, n, target):
        start = 0
        end = n - 1
        mid = start + (end - start) // 2
        ans = -1

        while start <= end:
            if arr[mid] == target:
                ans = mid
                start = mid + 1
            elif arr[mid] < target:
                start = mid + 1
            elif arr[mid] > target:
                end = mid - 1
            mid = start + (end - start) // 2

        return ans



    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.firstOccurance(nums, len(nums), target), self.lastOccurance(nums, len(nums), target)]