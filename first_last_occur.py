class Solution:
     def searchRange(self, nums: List[int], target: int) -> List[int]:
            if nums==None or len(nums)==0:
                return [-1,-1]

            left=self.binarysearchleft(nums,target)
            if left==-1:
                return [-1,-1]
            right=self.binarysearchright(nums,target)
            return [left,right]
    
     def binarysearchleft(self,nums,target):
        left=0
        right=len(nums)-1
        while left<=right:
            mid=left+(right-left)//2
            if nums[mid]==target:
                if mid==0 or nums[mid-1]<nums[mid]: #first instance, checking if mid==0 to handle the case when mid point is at the start of arr and if we do mid-1, arr out of bound
                    return mid
                right=mid-1
            elif nums[mid]<target:
                low=mid+1
            else:
                high=mid-1
        return -1

        def binarysearchright(self,nums,target):
            left=0
            right=len(nums)-1
            while left<=right:
                mid=left+(right-left)//2
                if nums[mid]==target:
                    if mid==len(nums)-1 or nums[mid]<nums[mid+1]: #last instance, checking if mid==len-1 to handle the case when mid point is at the start of arr and if we do mid+1, arr out of bound
                        return mid
                    left=mid+1
                elif nums[mid]<target:
                    low=mid+1
                else:
                    high=mid-1
            return -1


