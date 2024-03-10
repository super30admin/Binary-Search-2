"""A minimum element in an array is defined as the element which is the smallest out of all.
Since the given rotated array is originally sorted, we can assume that there is a point/index
in the given array where the original minimum element is lying. To find that we can compare the
current element(mid) to either side elements and smaller among them is the minimum element as well.
To maintain logarthimic time, we want to discard half the array each iteration. To do so we can discard
the sorted subarray becuae it is garaunteed that pivot woont lie on that side.

TC: O(log n)
SC: O(1)"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1: return nums[0]
        low, high = 0, len(nums)-1
        if nums[low]<nums[high]:
            return nums[low]
        while(low<=high):
            mid = low + (high-low)//2
            if nums[mid] < nums[mid-1]:
                return nums[mid]
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            if nums[low] < nums[mid]:
                low = mid+1
            else:
                high = mid-1
        return 1234