# TC : O(logn)
# SC : O(1)
# Leet code : Yes
# problems : 
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l = 0
        flag = 0
        h = len(nums) - 1
        if len(nums)==0:
            return [-1,-1]
        while l<=h:
            m = l + (h - l)//2
            if nums[m] < target:
                l = m + 1
            elif nums[m] > target:
                h = m - 1
            else:
                # print("target found", m, l, h)
                flag = 1
                break
        k, l = m-1, m+1
        maxi, mini = m, m
        # try:
        while (k >=0 and nums[k]==target):
            # if nums[k]==target:
            mini = k
            k -= 1
        while (l<=len(nums)-1 and nums[l]==target): #if nums[l]==target:
            maxi = l
            l += 1
        # except:
        #     pass
        if flag==1:
            return [mini, maxi]
        return [-1, -1]
        