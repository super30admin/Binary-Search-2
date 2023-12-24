# Solution

# // Time Complexity : O(log(n)) - Though we are using logn multiple times
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to first find the target once in array, consider that as the point and recursively check if we can find target on
# the left part of the array from where we previously found the target. This helps us find the start index. If we do the same
# on the right part of the index from where we got the value initially, it gives us end position of the target.
def searchRange(nums, target):

    def binarySearch(low,high,target,nums):
        while low<=high:
            mid = (low+high)//2

            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
            
        return -1

    if not nums:
        return [-1,-1]

    low = 0
    high = len(nums)-1
    start = -1
    end = -1
    firstFind = -1

    mid = binarySearch(low,high,target,nums)
    
    if mid == -1:
        return [-1,-1]
    
    firstFind = mid

    low = 0
    high = firstFind-1
    prev = firstFind
    while start == -1:  
        mid = binarySearch(low,high,target,nums)
        if mid == -1:
            start = prev
        else:
            prev = mid
            high = mid-1

    low = firstFind+1
    high = len(nums)-1
    prev = firstFind
    while end == -1:
        mid = binarySearch(low,high,target,nums)
        if mid == -1:
            end = prev
        else:
            prev = mid
            low = mid+1
    
    return [start,end]

if __name__ == "__main__":
    nums = [5,7,7,8,8,10]
    target = 8
    print(searchRange(nums,target))