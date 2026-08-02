"""
Approach:
-> If array is sorted, return first element.

-> Compare nums[mid] with it's neighbors. If mid element is smaller than mid - 1 and smaller than mid + 1, mid is smallest element and return mid

-> After dry running few examples, we find min element is always present in unsorted part of array
Aim: to find sorted array and eliminate it

Compare nums[mid] with nums[low]. If nums[mid] >= nums[low], then left side is sorted and we eliminate by updating low pointer. else eliminate right side (right sorted array) by updating high pointer.

Eventually you will reach unsorted array and element will be smaller than it's neighbors.

Time complexity:
O(logn)

Space complexity:
O(1)
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:

            # Base Case: first check if array is sorted, if so return low. nums[low] <= nums[high] because consider [1,1,1,1] - we return 1 since 1 <= 1.
            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high - low)//2

            # check for index bounds and check if mid is smaller than neighboring elements; if so mid is minimum and return mid
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == high or nums[mid] < nums[mid+1]):
                return nums[mid]
            
            # min element will always lies in unsorted subarray; if you find a sorted array, eliminate it using pointers
            # check if left side is sorted; if so eliminate that
            if nums[mid] >= nums[low]:
                low = mid + 1
            # check if left side is sorted; if so eliminate that
            else:
                high = mid - 1
        return -1