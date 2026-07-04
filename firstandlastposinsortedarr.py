class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def binarySearch(leftBias):
            left, right = 0, len(nums) - 1
            ans = -1

            while left <= right:
                mid = (left + right) // 2

                if nums[mid] < target:
                    left = mid + 1
                elif nums[mid] > target:
                    right = mid - 1
                else:
                    ans = mid
                    if leftBias:
                        right = mid - 1
                    else:
                        left = mid + 1

            return ans

        return [binarySearch(True), binarySearch(False)]

    # TC - O(logN)
    # SC - O(1)