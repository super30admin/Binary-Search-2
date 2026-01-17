# Time Complexity: O(logn)
# Space Complexity:O(1)
# Approach: 1st occ apply binary search, when mid = target check if it is greater than mid-1 then return mid and for 2nd occ apply binary search and
# target= mid then check if next element is greater then return second occ otherwise move low to mid+1

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        low = 0
        high = n-1
        li = [-1,-1]
        
        #first occurrence
        while low <= high:
            mid  = low + (high-low)//2            
            if nums[mid] ==target:
                if mid==0 or nums[mid]>nums[mid-1] :
                    li[0]=mid
                    break
                else:
                    high = mid - 1
            elif nums[mid]> target:
                high = mid -1
            else:
                low = mid+1

        if li[0] ==-1:
            return li

        low= li[0]
        high=n-1
        
        #second occurrence
        while low <= high:
            print("second")
            mid  = low + (high-low)//2
            print(mid)
            if nums[mid] ==target:
                if mid ==n-1 or nums[mid]<nums[mid+1]:
                    li[1]=mid
                    break
                else:
                    low = mid + 1
            elif nums[mid]> target:
                high = mid -1
            else:
                low = mid+1  

        return li
       