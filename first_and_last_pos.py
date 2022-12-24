# Time Complexity :
# O(log N)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

# Any problem you faced while coding this :
#No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        answer = [-1,-1]
        if len(nums) == 0:
            return answer

        #Find leftmost occurance of target
        leftmost =  self.find_index(nums,'first',target)
        #Find rightmost occurance of target
        rightmost = self.find_index(nums,'last',target)
        #print ("left,right",leftmost,rightmost)
        if leftmost == -1 or rightmost == -1:
            return answer
        else :
            return [leftmost,rightmost]

    def find_index(self,nums,first_last,target):
        low = 0
        high = len(nums) -1
        while low <= high :
            middle = int(low + (high-low)/2)
            #print (low,middle,high)
            if nums[middle] > target :
                high = middle-1
            elif nums[middle] < target :
                low = middle+1
            elif nums[middle] == target :
                if first_last == 'first':
                    # if middle is bigger than left, then it's the leftmost target position
                    if middle == 0 or nums[middle] > nums[middle-1]:
                        return middle
                    else :
                        high = middle-1
                else :
                    #if middle is smaller than it's right - then it's righmost target position
                    if middle == len(nums)-1 or nums[middle] < nums[middle+1]:
                        return middle
                    else :
                        low = middle+1
                
        return -1
