class Solution:

    def searchLeft(self,nums,target):
        start=0;end=len(nums)-1
        while start<=end:
            mid = (start+end)//2
            if target==nums[mid]:
                if (mid==start or nums[mid]>nums[mid-1]):
                    return mid
                else:
                    end=mid-1
            elif nums[mid]>target:
                end=mid-1
            else:
                start=mid+1

        return -1

    def searchRight(self,nums,target):
        start=0;end=len(nums)-1
        while start<=end:
            mid = (start+end)//2
            if target==nums[mid]:
                if (mid==end or nums[mid]<nums[mid+1]):
                    return mid
                else:
                    start=mid+1
            elif nums[mid]>target:
                end=mid-1
            else:
                start=mid+1

        return -1



    def searchRange(self, nums, target: int):
        res=[]
        if nums is None or len(nums)==0:
            return [-1,-1]
        left = self.searchLeft(nums,target)
        right= self.searchRight(nums,target)
        res.append(left,right)
        return res


a=Solution()
res = a.searchRange([5,7,7,8,8,10],6)
print(res)
