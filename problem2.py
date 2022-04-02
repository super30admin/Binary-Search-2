#find-minimum-in-rotated-sorted-array

# // Time Complexity : O(N)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :havent found the optimal solution yet

def findMin(nums):
    mini = float('infinity')
    for i in nums:
        if(i <mini):
            mini=i
    return mini


print(findMin([4,5,6,7,0,1,2]))