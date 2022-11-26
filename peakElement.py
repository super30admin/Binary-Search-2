#Time Complexity :  log(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach in three sentences only
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0             #initializing low and high pointers
        high = len(nums)-1
        length = len(nums)  #taking length of the array
        
        while low <= high:          #running binary search algorithm
            mid = low + (high-low)//2           #computing mid
            
            #if mid is the peak and checking edge cases if mid is 0th index or last index then return mid index
            if (mid == length - 1 or nums[mid] > nums[mid+1]) and (mid == 0 or nums[mid] > nums[mid-1]):
                return mid
            
            elif nums[mid+1] > nums[mid]: #if element at mid+1 is greater than mid we shift low to mid + 1 and check right half of the array
                low = mid + 1
            
            else:   #otherwise we shift high to mid - 1 and check left half of array 
                high = mid - 1
        
        return -1   #we will not be reaching this line