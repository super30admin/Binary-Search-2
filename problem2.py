# UNSUCCESSFUL : :-(

class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        l = 0
        h = n-1
        
        while l<=h:
            m = (l+h)//2
            if m-1 >=0 and m+1 <= n-1:
                if nums[m-1] > nums[m] < nums[m+1]:
                    return nums[m]
                elif nums[m-1] < nums[m] < nums[m+1]:
                    h = m-1
                else:
                    l = m+1
            elif m==0:
                if nums[m] <= nums[h]:
                    return nums[m]
                else:
                    return nums[h]
            elif m==n-1:
                if nums[m] <= nums[m-1]:
                    return nums[m]
                else:
                    return nums[m-1]
            
            
                
        
            
        
        
        
