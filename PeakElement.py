"""
Apply BS to find a mid where the shift happens.
If nums[mid] > nums[mid+1], move right = mid.
Else move left = mid + 1; doing so, left == right is the peak.
"""

"""
Time Complexity:
O(log n) — Binary Search
Space Complexity:
O(1) — Only constant space used
"""


class PeakElement:
    def findPeakElement(self, nums: list[int]) -> int:
        left, right = 0, len(nums) - 1

        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[mid + 1]:
                right = mid
            else:
                left = mid + 1

        return left
    
if __name__=="__main__":

    obj = PeakElement()
    nums = [1,2,1,3,5,6,4]
    print(obj.findPeakElement(nums))
