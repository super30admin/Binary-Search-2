class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums[0]<nums[-1]:
            return nums[0]
        if nums==None or len(nums)==0:
            return -1

        print("hello")
        low=0
        high=len(nums)-1
        while low<=high:
            mid=(low+high)//2
            if nums[low]<=nums[high]:
                return nums[low]
            if (mid==high or nums[mid]<nums[mid+1]) and (mid==low or nums[mid]<nums[mid-1]):
                return nums[mid]
            elif nums[low]<=nums[mid]:
                low=mid+1
            else:
                high=mid-1




        