""" 
    Binary Searchs
        
    if mid belongs to left portion then minumum will be on right so 
        l =m +1
    else:
        search on right for min
    keep a variable to keep track of minumums

"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        res = nums[0]
        l, r = 0, len(nums)-1

        while l <= r:
            # if subarray is sorted already
            if nums[l] < nums[r]:
                res = min(res, nums[l])
                break
            #if not sorted -> do Binary Search
            m = (l+r)//2
            res = min(res, nums[m])
            if nums[l] <= nums[m]:
                l = m + 1
            else:
                r = m - 1
        return res