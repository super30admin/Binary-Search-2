# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def BinarySearchFirst(nums: List[int], low: int, high: int, target: int)->int:
            while low<=high:
                mid = (low+high)//2
                if nums[mid]==target: 
                    if mid==0 or nums[mid]>nums[mid-1]: #To check if that's the first occurence of target
                        return mid
                    else:
                        high=mid-1                      #Move towards left since finding the first occurence
                elif nums[mid]>target:
                        high = mid-1
                else:
                    low = mid+1
            return -1
        def BinarySearchLast(nums: List[int], low: int, high: int, target: int)->int:
            while low<=high:
                mid = (low+high)//2
                if nums[mid]==target:
                    if mid==len(nums)-1 or nums[mid]<nums[mid+1]:     #Tocheck if that's the last occurence of target
                        return mid
                    else:
                        low=mid+1                           #Move towards right since we are finding last occurence
                elif nums[mid]>target:
                    high = mid-1
                else:
                    low = mid+1
            return -1

        low = 0
        high = len(nums)-1
        first_idx = BinarySearchFirst(nums,0,len(nums)-1,target) #To find index of first occurence
        last_idx = BinarySearchLast(nums,0,len(nums)-1,target)
        return [first_idx,last_idx]
   
                   


        