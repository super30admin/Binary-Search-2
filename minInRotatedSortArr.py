#Time Complexity :  log(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach in three sentences only
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        
        while low <= high:
            mid = low + (high-low)//2
            if nums[low] < nums[high]: return nums[low]  #sorted array 0th index is the min
            
            #check edge cases and if min is at mid where elem at mid < mid+1 and mid< mid-1 we return mid elem
            if (mid == len(nums)-1 or nums[mid] < nums[mid+1]) and (mid == 0 or nums[mid] < nums[mid-1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:                #if left half is sorted we look for pivot in right half
                low = mid + 1
            else:                                       #else we look at left half
                high = mid - 1
        return -1