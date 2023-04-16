class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: 
        List[int]
        """
        if len(nums)==0 or self.binarySearchLeft(nums,target)==-1:
            return [-1,-1]
        else:
            return [self.binarySearchLeft(nums,target),self.binarySearchRight(nums,target)]

    def binarySearchLeft(self,nums,target):
        l=0
        h=len(nums)-1
        while(l<=h):
            mid=(l+h)//2
            if nums[mid]<target:
                l=mid+1
            elif nums[mid]>target:
                h=mid-1
            else:
                if mid==0 or nums[mid-1]!=target:
                    return mid
                h=mid-1
        return -1

    def binarySearchRight(self,nums,target):
        l=0
        h=len(nums)-1
        while(l<=h):
            mid=(l+h)//2
            if nums[mid]<target:
                l=mid+1
            elif nums[mid]>target:
                h=mid-1
            else:
                if mid==len(nums)-1 or nums[mid+1]!=target:
                    return mid
                l=mid+1
        return -1