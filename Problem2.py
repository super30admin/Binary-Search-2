''' Time complexity : O(log N)
Space Complexity: O(1)


Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No.

Your code here along with comments explaining your approach
Approach : Use Binary Search. Find mid -  check the side of misd which is not sorted. Minimum element lies in the part.'''

class Solution:
    def findMin(self, nums: List[int]) -> int:
        check if nums is not empty
        if nums==[] or len(nums)==0:
            return -1
        low = 0
        high =len(nums)-1
        
        while(low <=high):
            if nums[low]<=nums[high]:
                return nums[low]
            mid = low+(high-low)//2
            # if mid is the minimum element
            if (mid==0 or nums[mid]<nums[mid-1]) and nums[mid]<nums[mid+1]:
                return nums[mid]
            #chck left side is sorted
            elif nums[low]<=nums[mid]:
                low = mid+1
            else:
                #  right side is unsorted
                high = mid-1      
        return -1