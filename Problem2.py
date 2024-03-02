#  T.C : O(logn)
#  S.C: O(1)
# This approach checks if the array is already sorted and then finds the mid point till all the conditions are satisfied

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1

        while(low <=high):
            #check if array is already sorted
            if nums[low] <= nums[high]:
                return nums[low]
            mid = (low + high) //2
            # Check if mid is minimum
            if (mid != 0 and nums[mid] < nums[mid - 1]):
                return nums[mid]
            
            if(nums[low] <= nums[mid]):
                low = mid + 1
            else:
                high = mid - 1

        return -1
