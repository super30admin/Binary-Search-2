# // Time Complexity : O(log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only

def binarySearch(self, nums):

    low = 0 
    high = len(nums)-1

    while low<= high:
        mid = low + (high-low)//2
        # check if the given array is sorted, then return the first element
        if nums[low] <= nums[high]: return nums[low]

        ## check if mid == 0 and nums[mid] < nums[mid+1] or mid == len-1 andnums[mid] < nums[mid-1]
        ## return nums[mid]
        if ((mid == len(nums)-1 or nums[mid] < nums[mid+1]) and (mid == 0 or nums[mid] < nums[mid-1])):
            return nums[mid]


        # if left is sorted , search right
        if nums[low] <= nums[mid] :
            low = mid+1
        ## else search left
        else:
            high = mid-1
