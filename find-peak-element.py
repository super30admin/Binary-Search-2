# // Time Complexity : O(2 x Log N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        def binarySearch(lo, hi, leftBias, rightBias):
            res = 0
            while lo <= hi:
                mid = (lo+hi)//2

                midVal = nums[mid]
                midRight = nums[mid+1] if mid+1<=hi else float('-inf')
                midLeft = nums[mid-1] if mid-1>=lo else float('-inf')

                if midVal > midLeft and midVal > midRight:
                    res = mid
                    break
                elif midRight > midVal:
                    lo = mid + 1
                elif midLeft > midVal:
                    hi = mid - 1
                else:
                    if rightBias:   lo = mid + 1
                    if leftBias:    hi = mid - 1
            return res
        left = binarySearch(0, len(nums)-1, True, False)
        right = binarySearch(0, len(nums)-1, False, True)

        return max(left, right, -1)