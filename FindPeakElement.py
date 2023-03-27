#Time Complexity: O(log n)
#Space Complexity: O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums or len(nums)==0:
            return int(sys.maxsize)

        low = 0
        high = len(nums) - 1
        while low<=high:
            mid = (low + high) // 2
            if (mid == high or nums[mid] > nums[mid+1]) and (mid == low or nums[mid] > nums[mid - 1]):
                return mid
            
            if nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1

        return mid
