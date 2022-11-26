#Time Complexity :  2log(n) -> log(n) 
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach in three sentences only
class Solution:
    def binarySearchLeft(self, nums, low, high, target):
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:                         #if middle elem is target
                if mid == 0 or nums[mid-1] < nums[mid]:     #and if the mid is 0 or element at mid-1 is less than mid
                    return mid
                else:
                    high = mid - 1                          #keep moving left
            elif nums[mid] > target:                        #change high pointer and look left    
                high = mid - 1
            else:                                           #change low pointer and look right
                low = mid + 1
        return -1
    
    def binarySearchRight(self, nums, low, high, target):
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:                         #if middle elem is target
                if mid == len(nums)-1 or nums[mid+1] > nums[mid]:     #and if the mid is last index or elem at mid+1 is > than mid
                    return mid
                else:
                    low = mid + 1                           #keep moving right
            elif nums[mid] > target:                        #change high ptr and look left
                high = mid - 1
            else:                                           #change low ptr and look right
                low = mid + 1
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums)-1
        length = len(nums)

        if not nums or len(nums) == 0: return [-1, -1]  #base case
        if nums[0] > target and nums[length-1] < target: return [-1, -1]    #edge case if target is not found in two types of sorted arrays
        
        left = self.binarySearchLeft(nums, low, high, target)
        if left == -1:                                  #if left returns -1 we do not have to perform binarySearchRight
            return [-1, -1]
        right = self.binarySearchRight(nums, left, high, target)
        return [left, right]                            #finally we return [left, right] as the result