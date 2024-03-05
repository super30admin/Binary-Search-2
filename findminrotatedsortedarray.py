## Time complexity is O(logN) and space complexity is O(1)
class FindMin:
    def MinInSortedArray(self, nums):
        l =0
        r = len(nums)-1
        res = nums[0]
        
        while l<=r:
            if nums[l]<nums[r]:
                res = min(res, nums[l])
                break
            mid = (l+r)//2
            res =  min(res, nums[mid])
            if nums[l]<nums[mid]:
                r=  mid-1
            else:
                l = mid+1
        return res