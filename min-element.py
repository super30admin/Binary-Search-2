# Time Complexity : O(logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :None

# Your code here along with comments explaining your approach in three sentences only
# do binary search to find min element
# the main condition is if mid < mid-1 and mid < mid + 1
# check which side is sorted and move the opposite side of the sorted part as the min lie there

class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)-1
        low = 0
        high = n
        while (low<= high):
            if (nums[low]<= nums[high]):
                return nums[low]
            mid = (high+low)#2
            if((mid == 0 or nums[mid] <= nums[mid-1])and(mid == n or nums[mid] <= nums[mid+1])):
                return nums[mid]
            elif (nums[low] <= nums[mid]):
                low = mid + 1
            else:
                high = mid -1
        return 77777
        
        