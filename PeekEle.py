# Time Complexity: O(logn)
# Space Complexity:O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while(low <= high):
            if len(nums) == 1:
                return 0
            if (nums[low] > nums[low +1]) :
                return low
            elif (nums[high]> nums[high -1]):
                return high
            mid = (low + high)//2
            if (nums[mid]< nums[mid +1]):
                low = mid + 1
            elif (nums[mid]< nums[mid -1]):
                high = mid -1
            elif (nums[mid - 1]< nums[mid] > nums[mid +1]):
                return mid


                
        
