# Time complexity : O(log(n)), we search half of the array at every time step
# Space complexity : O(1), space to maintain left and right pointers
# The code ran on github

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        l = 0; h = len(nums) - 1

        while l <= h:
            mid = l + (h-l)//2

            # One half of the array is always sorted. At any point, if the array is sorted in the range l and h, l points to the minimum value

            if nums[l] <= nums[h]:
                return nums[l]
            elif nums[mid+1] > nums[mid] and nums[mid-1] > nums[mid]:
                return nums[mid]
            # If the whole array is not sorted, the minimum element always lies in the unsorted portion

            elif nums[l] <= nums[mid]: # If this condition is true, left portion is sorted
                l = mid + 1
            else:
                h = mid - 1