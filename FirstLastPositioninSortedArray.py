#traverse and find the target and after that check for right and left element of mid 
#whichever side has same ele as target traverse in that side of array. 
#After finding the first position perform binary search on the other side of the array. 

#Time complexity: o (logn)
#space complexity : o(1) 
#Successfully ran on leetcode 


class Solution:
    def checkFirstPosition(self, nums , target):
        low =0 
        high = len(nums) -1 
        while(low <= high):
            #mid = low + (high-low) //2 
            mid = (low + high)//2
            if(nums[mid] == target):
                if(mid == 0 or nums[mid]> nums[mid -1]):
                    return mid
                else:
                    #because that means we have same elements on the left 
                    #hence we keep moving left to find first target element
                    high = mid-1
            elif nums[mid] < target:
                low = mid +1 
            else:
                high = mid -1 

        return -1 

    def checkSecondPosition(self, nums, low, high, target):
        while low <=high: 
            #mid = low + (high- low) //2
            mid = (low + high)//2
            if (nums[mid] == target):
                if mid == len(nums) -1 or nums[mid] < nums[mid+1]:
                    return mid 
                else:
                    low = mid+1
            elif nums[mid] < target:
                low = mid+ 1
            else:
                high = mid -1
                

        return -1
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        n = len(nums)
        #check if nums exist 
        if(nums == 0 or n == 0):
            return (-1,-1)
        if(nums[0] > target or nums[n-1] < target):
            return (-1,-1)
        
        first = self.checkFirstPosition(nums, target)
        #if there is no first ele, there won't be second as well
        #hence return -1 
        print(first)
        if(first == -1):
            return (-1,-1)
        #firstElement = first 

        second = self.checkSecondPosition(nums, first, n-1, target)
        #secondElement = second 

        return (first, second)