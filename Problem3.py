#T.C: O(logn)
#S.C: O(1)
# Approach. finds the midpoint and checks if it's peak element or not. If not, checks if the number before mid point is smaller or greater. Moves where the greater side is.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        n = len(nums)
        high = len(nums) - 1

        while (low <= high):

            mid = (low + high)//2
        
            if ((mid==0 or nums[mid] > nums[mid-1]) and (mid == n -1 or nums[mid] > nums[mid + 1])):
                return mid
            elif(mid != 0 and nums[mid - 1] > nums[mid]):
                high = mid - 1
            else:
                low = mid + 1

        return -1
