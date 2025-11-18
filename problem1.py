""""
We do a two binary search here, first for finding the first occurence and second one for the second occurene, 
if nums[mid] = target, we will return m, but only if there doesnt exist any element previous to it (on the left side) and if there exists, it shoulndt be equal to the target.
do a regular binary search halving then if the mid != target. Do a similar approach for last occurence and shift pointers accordingly
TC for this is O(logn + logn) which is o(logn) plus constant time for calculating whether the mid - 1 and mid + 1 is equal to target or not. Also  constant space.
"""

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def binarysearchFirst(nums, target, l, r):
            while l <= r:
                m = l +( r - l) // 2
                if nums[m] == target:
                    if ( m == 0 or nums[m - 1] != target ):
                        return m
                    else:
                        r = m - 1
                elif nums[m] > target:
                    r = m -1
                else:
                    l = m + 1
            return -1
        def binarysearchLast(nums, target, l, r):
            while l <= r:
                m = l + ( r - l) // 2
                if nums[m] == target:
                    if (m == len(nums) - 1 or nums[m + 1] != target ):
                        return m
                    else:
                        l = m + 1
                elif nums[m] > target:
                    r = m -1
                else:
                    l = m + 1
            return -1
        
        firstidx = binarysearchFirst(nums, target, 0, len(nums)-1)
        if firstidx == -1:
            return [-1, -1]
        lastidx = binarysearchLast(nums, target, firstidx, len(nums) -1)
        return [firstidx, lastidx]
        