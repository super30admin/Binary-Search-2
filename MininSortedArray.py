#time complexity = O(logn) 
#space complexity : o(1) 
#Successfully ran on leetcode 

#Binary search based on finding if I want to traverse the left side or 
#right side of array, comparing the middle element to mid-1  or mid + 1 to decide. 

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low =0
        high = len(nums) - 1

        if len(nums) ==1:
            return nums[0]

        if(nums[high] > nums[low]):
            return nums[low]
        while(low <=high):
            mid= (low+high)//2
            #mid = low + (high-low) //2
            if(nums[mid] > nums[mid+1]):
                return nums[mid+1]
            if(nums[mid-1] > nums[mid]):
                return nums[mid]

            if(nums[mid] > nums[0]):
                low = mid+1
            else:
                high = mid-1