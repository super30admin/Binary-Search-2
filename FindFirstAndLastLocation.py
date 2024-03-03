# TC = O(logn)
# SC = O(1)


class Solution:

    def findFirstIndex(self, nums, low, high, target):

        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid] != nums[mid - 1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1

    def findSecondIndex(self, nums, low, high, target):
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == high or nums[mid] != nums[mid + 1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if len(nums) == 1:
                    return [0, 0]
                idx1 = self.findFirstIndex(nums, low, mid, target)
                idx2 = self.findSecondIndex(nums, mid, high, target)
                print("indices", idx1, idx2)
                return [idx1, idx2]
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return [-1, -1]
