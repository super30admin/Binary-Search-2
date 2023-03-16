#Time complexity :O(logn)
#Space Complexity : O(1)


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        lowerBound = Solution.binarySearch(nums,target,True)
        if(lowerBound==-1):
            return [-1,-1]
        upperBound = Solution.binarySearch(nums,target,False)
        return [lowerBound,upperBound]
    def binarySearch(nums,target,isLowerBound):
        n = len(nums)
        l = 0
        r = n-1
        while(l<=r):
            mid = (l+r)//2
            if(nums[mid]==target):
                if isLowerBound:
                    if mid==l or nums[mid-1]<target:
                        return mid
                    r = mid-1
                else:
                    if mid==r or nums[mid+1]>target:
                        return mid
                    l = mid+1
            elif nums[mid]>target:
                r = mid-1
            else:
                l = mid+1
        return -1

        