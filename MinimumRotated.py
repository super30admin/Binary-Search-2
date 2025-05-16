"""
Apply BS to reduce search space to where rotation happened.
If nums[mid] > nums[right], discard the leftside by moving left.
Else keep mid and search leftside  by moving right.
"""

"""
Time Complexity:
O(log n) — Each step halves the search space.
Space Complexity:
O(1) — Only constant space used
"""


class MinimumRotated:
    def findMin(self, nums: list[int]) -> int:

        left = 0
        right = len(nums) - 1

        while left < right:
            mid = (left + right) // 2

            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid

        return nums[left]
        
if __name__=="__main__":

    obj = MinimumRotated()
    nums = [11,13,15,17]
    print(obj.findMin(nums))
