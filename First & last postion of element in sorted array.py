class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        first=self.binarySearchFirst(nums, target)
        if first ==-1:
            return [-1,-1]
        last=self.binarySearchLast(nums,target)
        if last==-1:
            return[-1,-1]
        return [first,last]

    def binarySearchFirst(self, nums: List[int], target: int) -> List[int]:
        l=0
        h=len(nums)-1

        while l<=h:
            m=(l+h)//2

            if target==nums[m]:
                if m==0 or nums[m-1]<nums[m]:
                    return m
                else:
                    h=m-1
            elif target>=nums[l] and target<nums[m]:
                h=m-1
            else:
                l=m+1
        return -1
    def binarySearchLast(self, nums: List[int], target: int) -> List[int]:
        l=0
        h=len(nums)-1

        while l<=h:
            m=(l+h)//2

            if target==nums[m]:
                if m==len(nums)-1 or nums[m]<nums[m+1]:
                    return m
                else:
                    l=m+1
            elif target>=nums[l] and target<nums[m]:
                h=m-1
            else:
                l=m+1
        return -1