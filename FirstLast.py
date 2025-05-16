"""
Apply BS for the first index where nums[mid] == target and move right to smalll left side.
Apply BS again for the last index and move left to small right side.
Return both positions. If not found, both will be -1.
"""
"""
Time Complexity:
O(log n) for each binary search - Total: O(log n)
Space Complexity:
O(1) — No extra space used.
"""

class FirstLast:
    def searchRange(self, nums: list[int], target: int) -> list[int]:

        def find_first():
            left, right = 0, len(nums) - 1
            first = -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
                if nums[mid] == target:
                    first = mid
            return first

        def find_last():
            left, right = 0, len(nums) - 1
            last = -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] > target:
                    right = mid - 1
                else:
                    left = mid + 1
                if nums[mid] == target:
                    last = mid
            return last

        return [find_first(), find_last()]


if __name__=="__main__":

    obj = FirstLast()
    nums = [5,7,7,8,8,10]
    target = 8
    print(obj.searchRange(nums,target))
    print(obj.searchRange(nums,6))


