## Time Complexity = O(LogN)
class Solution:
    def Find_Peak_Element(self,nums:list)->int:
        l,r = 0, len(nums)-1
        while l<=r:
            m = l + ((r-l))//2
            ##left side is greater
            if (m>0 and nums[m]<nums[m-1]):
                r= m-1
            ##right side is greater
            elif (m<len(nums)-1 and nums[m]<nums[m+1]):
                l= m+1
            return m        
            
