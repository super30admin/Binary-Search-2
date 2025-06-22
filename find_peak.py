class Solution:
    '''
    Time Complexity: O(log n)
    Space Complexity: O(1)
    Notes: Practcie atleat 5 times to understand this pattern.
    '''
    def findPeakElement(self, nums: List[int]) -> int:

        low = 0
        high = len(nums)-1

        while(low<=high):

            mid = (low+high)//2

            if((mid ==0 or nums[mid]>nums[mid-1]) and (mid==high or nums[mid]>nums[mid+1])):
                return mid

            if(nums[mid]>=nums[mid-1] or mid==0):
                low=mid+1
            else:
                high = mid-1
