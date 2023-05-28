class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        length_of_array=len(nums)-1
        lp=0
        hp= length_of_array
        while(lp <= hp):
            mid=lp+(hp-lp)//2
            if((mid ==0 or nums[mid]>nums[mid-1]) and 
            (mid==length_of_array or nums[mid]>nums[mid+1])):
             return mid
            
            if(nums[mid] < nums[mid+1]):
                lp=mid+1
            else:
                hp=mid-1
        return mid