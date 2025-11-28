class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l=0
        r=len(nums)-1
        flag=False
        #Doing binary search to see if the target is present or not
        while l<=r:
            m=l+(r-l)//2
            if nums[m]==target:
                flag=True
                break
            elif nums[m]>target:
                r=m-1
            else:
                l=m+1
        if flag==False:
            return [-1,-1]
        
        # Doing binary search to find a target less than target
        # we can do it in space[l,m]
        left= l
        right = m
        while left<=right:
            mid= left+ (right-left)//2
            if nums[mid]<target:
                left=mid+1
            else:
                right=mid-1
        res1=left
        # Do binary search to find a target greater than target
        # we can do it in space[m,r]
        left= m
        right = r
        while left<=right:
            mid= left+ (right-left)//2
            if nums[mid]<=target:
                left=mid+1
            else:
                right=mid-1
        res2=right
        return [res1,res2]
        