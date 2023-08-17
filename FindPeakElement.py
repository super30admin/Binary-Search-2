#Time Complexity : O(logn) where n is the number of elements in nums - Binary Search
#Space Complexity : O(1) since we dont use any extra space
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: Here we need to find a peak element which is greater than both of its neighbours. There can be multiple peak elements,
#but we return anyone of them. We use a property of array which states that, we 100% find the peak element on the side where the
#element is greater than mid. So we move our pointer to that half in binary search. 

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low = 0  
        high = n-1
        while low <= high:
            mid = (low+high) // 2
            if (mid == n-1 or nums[mid] > nums[mid+1]) and (mid == 0 or nums[mid] > nums[mid-1]):
                return mid
            elif mid < n-1 and nums[mid] < nums[mid+1]:
                low = mid + 1
            else:
                high = mid - 1  
