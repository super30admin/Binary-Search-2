# Time taken to Fully Solve = 16 mins
# Time Complexity = O(logn)
# Number of incorrect submissions = 1.
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        start = 0
        end = len(nums) -1
        while start <= end:
            mid = start + (end-start)//2
            # end condition - both sides low element of mid.
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid+1]):
                return mid
            # decision 1
            # 1. Find if there's an ascending slope on left. If there is then it must contain atleast 1 peak.
            if mid !=0 and nums[mid-1]> nums[mid]:
                end = mid - 1
            # decision 2
            # 2. else go right since right must be greater than mid. There will be a peak.
            else:
                start = mid + 1
        # return not found
        # condition never hit since array will always have atleast 1 peak - Given nums[i] != nums[i + 1] for all valid i.
        return 1234
        