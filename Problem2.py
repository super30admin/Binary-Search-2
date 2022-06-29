'''
Time Complexity : O (Log N)
Space Complexity : O(1)
'''
class Solution:
    '''
    Check if the left part is sorted or not 
    if not sorted move towards the unsorted part 
    check if mid is less than its neibhours if yes return mid
    '''
    def findMin(self, nums: List[int]) -> int:
        if(len(nums)==1):
            return nums[0]
        elif(nums[0]<=nums[-1]):
            return nums[0]
        low = 0
        high = len(nums) - 1
        while(low<=high):
            if(nums[low]<=nums[high]):
                return nums[low]
            mid = low + (high-low)//2
            if((nums[mid]<nums[mid-1] or mid ==0) and (nums[mid]<nums[mid+1] or mid == len(nums)-1)):
                return nums[mid]
            elif(nums[high]>=nums[mid]):
                high = mid - 1
                
            else :
                low = mid + 1
            