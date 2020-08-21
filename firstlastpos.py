# Perform 2 binary search. Once to find the low index of the target element. Return -1 if the value of the low index is not the same as target.
# Second binary search for finding the high (last) index of the target element.
# Time complexity - O(log n)
# Space complexity - O(1)
# Did this code run on leetcode? - yes
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums: return [-1,-1]
        # search for the leftmost index of target element in nums.
        low = self.__bsearch(0, nums, target, left=True)
        
        if nums[low] != target:
            return [-1,-1]
        
        # search for righmost index of target element in nums
        high = self.__bsearch(0, nums, target, left=False)
        return [low, high]
        
        
    def __bsearch(self, low, nums, target, left=False):
        high = len(nums)-1
        
        while low<=high:
            mid = low + (high-low)//2
            if nums[mid] == target: 
                if (left and mid == low) or (not left and mid==high):
                    return mid
                elif left: high = mid
                else: low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        return high
        