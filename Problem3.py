#Time Complexity :O(log n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

#In Roated Sorted Array, half sub array would be sorted and half would be unsorted. The minimum value will be in the unsorted sub array
class Solution:
    def findMin(self, nums: List[int]) -> int:
        #check if array is empty
        if nums is None:
            return -1

        low=0
        high=len(nums)-1

        while(low<=high):
            mid=int(low+(high-low)/2)

            #check if the array is sorted and return lowest index's value
            if (nums[low]<=nums[high]):
                return nums[low]

            #check if mid is the minimum value and return mid value 
            #mid is less than neughbours
            if (mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]

            #check if left sub array is sorted then update the low pointer to mid +1
            elif nums[low]<=nums[mid]:
                # left is sorted array
                low=mid+1

            else:
                high=mid-1
        return -1