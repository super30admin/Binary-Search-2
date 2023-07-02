# // Time Complexity :  O(log(N))
# // Space Complexity : no extra space used
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :  

# // Your code here along with comments explaining your approach:
# 1) check id its 1 length array.
# 2) check if lowest is a peak both in and out of the loop.
# 3) check if highest is peak both in and out of the loop.
# 4) check if mid is peak.
# 5) check if mid's left is greater slope, move left.
# 6) check if mid's right is greater slope move right.
# 7) check if mis is a valley, if left greater equal on both sides move left.
# 8) else move right.
# 
# 


class Solution:
    def findPeakElement(self, nums) -> int:
        l=0
        h=len(nums)-1
        if(l==h):
            return l
        if(h!=0 and nums[l]>nums[l+1]):
            return l
        if(nums[h]>nums[h-1]):
            return h
        
        while(l<=h):
            mid=l+(h-l)//2
            if(h!=0 and nums[l]>nums[l+1]):
                return l
            if(nums[h]>nums[h-1]):
                return h
            if(mid!=h and nums[mid]>nums[mid-1] and nums[mid]>nums[mid+1]):
                return mid
            if(nums[mid]<nums[mid-1] and nums[mid]>nums[mid+1]):
                # print(mid)
                h=mid-1
                # print(h)
            if(nums[mid]<nums[mid+1] and nums[mid]>nums[mid-1]):
                l=mid+1
            if(nums[mid]<nums[mid+1] and nums[mid]<nums[mid-1]):
                if(nums[mid-1]>=nums[mid+1]):
                    h=mid-1
                else:
                    l=mid+1

# sol= Solution()
# print(sol.findPeakElement([3,4,3,2,1]))