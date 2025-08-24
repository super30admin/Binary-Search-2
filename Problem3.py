# // Time Complexity :O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


class Problem3(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # peak elememt is the elene twhich is greater thna its neighbors 
        # the array is not a sorted array, but we know nums[-1] = nums[n] = -∞
       # said an element is always considered to be strictly greater than a neighbor that is outside the array.

        low = 0
        high = len(nums)-1

        while (low<=high):
            mid = low + (high-low)//2

            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]): # th evalue is greater then its neighours we found the peak
                return mid # return the index 
            
            # else if mid is not the peak which side of the array should we look 
            # here i will move to the arry which value is greater, because lets walk through the example
            # nums = [1,2,1,3,5,6,4] here the peak elements are 2,6 so intial th emid is 3 and comapring the 1,5 , 5 is greater so elminated the left half and
            # moved to right half which gives me 6 as the peak which is a valid peak
            # even in other example [1,2,3,1], intial mid is 2, and the next elimating left and moving to righ array as it is high value and found peak 3 
            # so everytime when we move t the array with highest value will always return the peak, like even in the edge case
            # [1,2,3,5] 5 is the peak 

            if mid >0 and nums[mid-1] > nums[mid]:
                high = mid-1 # iterate to left array to find the peak
            else:
                low = mid + 1 # iterate to right array to find the peak 

        #return -1 # nums[i] != nums[i + 1] so we will always have a peak so no required this fallback mechanism
