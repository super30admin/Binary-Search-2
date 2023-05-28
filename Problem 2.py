class Solution:
    def findMin(self, nums: List[int]) -> int:
        length_of_array= len(nums)-1
        lp=0
        hp=length_of_array
        while(lp <= hp):
            mid= lp+(hp-lp)//2
            if(nums[lp]< nums[hp]):
                return nums[lp]
            if((mid==length_of_array or nums[mid]< nums[mid+1]) 
            and( mid==0 or nums[mid]<nums[mid-1])):
                return nums[mid]

            if(nums[mid] >= nums[lp]):

                lp=mid+1
            else:

                hp=mid-1
        return nums[mid]