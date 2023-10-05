#TC: O(logN) , n is length of arr, as binary search by reject lower inclien
#SC: O(1)
#executed on LC : yes 162
#problems: edge cases! , check if mid is first or last !
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        low = 0
        high = len(nums) - 1
        
        if len(nums) ==1:
            return 0
        
        while low <= high:
            
            mid = low + (high - low)//2
            
            if (mid-1 >= 0 and mid+1 <= len(nums) - 1):
                # mid is the peak!
                if (nums[mid-1] <= nums[mid] and nums[mid+1] <nums[mid]): 
                    return mid
                #move to the higher incline
                elif nums[mid]< nums[mid+1]:
                    low = mid + 1
                elif nums[mid-1] >= nums[mid]:
                    high = mid - 1
            #if you are first or last, just compare yourself to neighbour
            if mid == 0:
                return mid if (nums[mid] > nums[mid+1]) else mid+1
            elif mid == len(nums) -1:
                return mid if (nums[mid] > nums[mid-1]) else mid-1
        return mid