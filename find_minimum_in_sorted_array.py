class Solution:
    '''
    Time Complexity: O(log n) because of binary search
    Space Complexity: O(1)
    '''
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums)
        
        while l < r:
            m = l + (r-l) // 2
            
            # you need to use nums[-1] for the last element in the sequence
            if nums[m] <= nums[-1]:
                # if you check this, you can start at the sorted area
                r = m
            else:
                l = m + 1
        return nums[l]