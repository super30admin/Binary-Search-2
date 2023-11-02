#Time Complexity:O(log n)
#space Complexity:O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left=0
        right=len(nums)-1

        while left<=right:
            mid=left+(right-left)//2
            #check whether the middle element is greater than mid-1 and mid+1 element or not
            if  (mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            #check if th peak element present in left side of the list then move towards left else right.
            elif mid !=0 and nums[mid]<nums[mid-1]:
                right=mid-1
            else:
                left=mid+1
        #if you dont anything return any random value.
        return 10
            
            