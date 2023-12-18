#time complexity = O(logn) 
#space complexity : o(1) 
#Successfully ran on leetcode 

#comparing mid with mid +1 and mid, change the value of high and low 
#based on that and return the lowest element


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low =0
        high = len(nums) - 1

        while(low < high):
            mid = (low+high) // 2
            if(nums[mid]> nums[mid+1]):
                high = mid
            else:
                low = mid+1 
        return low
		
