# // Time Complexity :O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


class Problem2(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # minimum in the array is the first index in a sorted array so if we 
        # find pivot that is if we find the index where the rotation of the array hapens is the pivot which is the min index
        # we know in the rotated array atleast one side of the array is sorted 
        # so pivot is the element whrre its previous element is greater than it and, the value is also less than the next element
        # nums[pivot-1] > nums[pivot] and nums[pivot] < nums[pivot+1] we found the pivot

       
        low = 0
        high = len(nums)-1

        while (low<=high):
             # if the arr is sorted we can return the low index simple
            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high-low)//2

            # looking for pivot
            # boundary conditions 
            if((mid == 0 or  nums[mid] < nums[mid - 1]) and (mid == len(nums)-1 or nums[mid] < nums[mid + 1])):
                return nums[mid]

            # if mid is not the pivot iterate to find the pivot 
            if nums[low] <= nums[mid]: # the left array is sorted and the min value is not in it so move to the right side
                low = mid +1
            else: # the min is left side of the array
                high = mid-1

        # said its a sorted array so we will always find the min element so the while loop will return the min value


         


        

        


