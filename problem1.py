"""Approach=> binary search left and the right pointer. keep hoing left or right once the mid is found
go left to find the leftmost index and right to get the rightmost index
t.c.=> O(log n)
s.c.=> O(1)

"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
    
        def binSearch(leftBias):
            ret = -1
            n = len(nums)
            l, r = 0, n - 1
            while l <= r:
                mid = l + (r - l)//2
                if nums[mid] == target:
                    ret = mid
                    if leftBias:
                        r = mid - 1
                    else:
                        l = mid + 1
                elif nums[mid] > target:
                    r = mid - 1
                else:
                    l = mid + 1
            return ret
        return [binSearch(True), binSearch(False)]
