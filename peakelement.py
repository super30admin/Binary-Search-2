class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        #you are doing a binary search here
        #checking the middle element and checking if its greater than its neighbour
        #if yes return the element
        #else move towards the element which is greater than middle elements and not towards the element smaller than middle element
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=(low+high)//2
            if ((mid==0) or (nums[mid]>nums[mid-1])) and (mid==(len(nums)-1) or (nums[mid]>nums[mid+1])): #checking th neighbouts of
                return mid  #of middle elements and the bpundary conditions
            elif (mid > 0 and nums[mid]<nums[mid-1]): #moving towards the greater element
                high=mid-1
            else:
                low=mid+1
        return -1
