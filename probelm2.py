#Time Complexity : O(log n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#With the binary search based approach, I tried to find on which side does the minimum element lie as a rotated array would have two sorted halves. Iteratively, I then used then same approach to find the min element. Additionally, I added an exception case for two elements where only one O(1) comparison is needed.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums)-1
        minEle = 0

        if len(nums) == 2:
            return min(nums[0],nums[1])
            
        while low <= high:
            mid = (low + high)//2
            if nums[mid] <= nums[minEle]:
                minEle = mid
                high = mid - 1
            else:
                low = mid + 1
        
        return nums[minEle]
        