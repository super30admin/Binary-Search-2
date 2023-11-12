class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        #initalize pointer
        l, r = 0, len(nums) - 1

        while l < r:
            mid = (l + r) // 2

            # Compare mid element with its neighbors
            if nums[mid] > nums[mid + 1]:
                r = mid     #increaing peak on left side
            else:
                
                l = mid + 1   #increaing peak on right side

        #return any left or right index
        return l
    
#------------------------------------------------------------------------------------------
# Time Complexity: O(log n)