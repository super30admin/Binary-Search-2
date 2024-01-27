'''
Applying binary search, trying to find the unsorted side:
    if values of mid>r, we found the unsorted part and move l to mid+1
    else: we found the part where the mid will fall to the mid or left of mid.
TC: O(logn)
SC: O(1)
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l,r = 0, len(nums)-1
        while l<r:
            mid = (l+r)//2
            if nums[mid] > nums[r]:
                l = mid+1
            else:
                r = mid
        return nums[l]