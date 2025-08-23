'''
2 Binary search, one for First element and second for last element
    - 4 possibilities for each:
        - target found, respective (first or last element) - Bingo
        - target found, but still not the first or last element
            - For first element -> move left
            - for last element -> move right
        - target not found, mid>target ->move left 
        - target not found, mid<target ->move right
# Time Complexity : 
    O(log n)+O(log n) = O(log n) - 2 Binary searches (First and last element)
# Space Complexity :
    O(1), just 3 pointers (left, right, mid)   
# Did this code successfully run on Leetcode :
    - yes
# Any problem you faced while coding this :
    - No
'''


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        ans = []
        # binary search for starting position
        left = 0
        right = len(nums)-1

        while left<=right:
            mid = left + (right-left)//2
            if nums[mid]==target and (mid==0 or nums[mid]>nums[mid-1]): #first index found
                ans.append(mid)
                break 
            elif nums[mid]==target and nums[mid]==nums[mid-1]: #target found but still start not found
                right = mid-1 # surely present to left side 
            elif nums[mid]>target: #need to move left
                right = mid-1
            else: #move right
                left = mid +1
        
        if len(ans)==0:
            # target not found
            return [-1,-1]
        
        # binary search for last position
        left = 0
        right = len(nums)-1

        while left<=right:
            mid = left + (right - left)//2
            if nums[mid]==target and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):#found the last element
                ans.append(mid)
                break
            elif nums[mid]==target and nums[mid]==nums[mid+1]: #target found but still last index not found
                left = mid+1
            elif nums[mid]>target: # target lies in left partition
                right = mid-1
            else: # move to right
                left = mid+1
        
        return ans
