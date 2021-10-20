"""
TIme Complexity: o(log n)
Space Complexity: O(1)
"""


def findPeakElement(self, nums: List[int]) -> int:
    l = 0
    r = len(nums)-1
    while(l < r):
        mid = l+h//2
        if nums[mid] > nums[mid+1]:
            r = mid
        else:
            l = mid+1
    return l
