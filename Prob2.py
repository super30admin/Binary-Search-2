# -Time Complexity : O(logN)
# -Space Complexity : O(1)
# -Did this code successfully run on Leetcode : Yes
# -Any problem you faced while coding this : No
# -Your code here along with comments explaining your approach
#  1. Key logic, is that min always lies in the unsorted part of the array, unless the entire array is sorted, in which case just return arr[0]
#     Now, we can apply Binary search to find the lowest element.    
#  2. To check if mid is the min element, check if it's lesser than it's neighbouring element, to do this make sure mid isn't 0 or len(arr)-1
#  3. Else, check if left half is sorted, if yes move to the right half
#  4. Else, check if right half is sorted, if yes move to the left half


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            if nums[low]<=nums[high]: #sorted array
                return nums[low]
            else:
                mid=low+(high-low)//2
                if 0<mid<len(nums)-1 and nums[mid-1]>nums[mid]<nums[mid+1]:
                    return nums[mid]
                elif nums[low]<=nums[mid]: #Left half is sorted, so move to the right half
                    low=mid+1
                elif nums[mid]<=nums[high]: #Right half is sorted, so move to the left half
                    high=mid-1
        return -1


        
