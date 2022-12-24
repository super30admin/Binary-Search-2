# Time Complexity :
# O(log N)

# Space Complexity :
# O(N) - 

# Did this code successfully run on Leetcode :
#Yes

# Any problem you faced while coding this :
#No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        middle = int(low + (high-low)/2)
        min_val = 100000


        while low <= high :
            #Check if left half is sorted
            if nums[low] <= nums[middle]:
                #Check if right half is also sorted - then fully sorted - return first elem
                if nums[middle] <= nums[high]:
                    return min(nums[low],min_val)
                else :
                    #Otherwise, store mid as it might be minimum
                    min_val =min(nums[middle],min_val)
                    #print (min_val)
                    low = middle+1
                    middle = int(low + (high-low)/2)
            else :
                #Check if left half is also sorted(this is assuming right half is already sorted) - 
                #then fully sorted - return first elem
                if nums[low] <= nums[middle]:
                    return min(nums[low],min_val)
                else:
                    #Otherwise, store mid as it might be minimum
                    min_val =min(nums[middle],min_val)
                    #print ("pos 2",min_val)
                    high = middle-1
                    middle = int(low + (high-low)/2)
