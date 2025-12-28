# Problem 1: Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
# Time Complexity : O(Log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        ## Start with trying to find the first occourance of the target
        ## since the search space can be reduced to half, intution is to use binary search 
        ## how to search second occurance ? again search by using binary search

        def first_binary_search(self,nums,target):
            l=0
            r= len(nums)-1
            while (l<=r):
    
                mid = l + (r-l)/2
                ## check if mid is the target, now that we have the target we need to figure if this is first occurance
                if nums[mid] == target:
                    ## checking first occurance by checking with neighbors since array is non decreasing
                    if (mid ==0 or nums[mid] > nums[mid-1]):
                        return mid
                    ## if not first occurance keep moving 
                    else:
                        r = mid -1
                ## moving left since mid is bigger never going to find in right side        
                elif nums[mid] > target:
                    r=mid-1
                ## move right    
                else:
                    l= mid+1
            return -1
        
        def second_binary_search(self,nums,target,first):
            ## once we are done with first occurance its time to find the last ocurance

            l=first
            r= len(nums)-1
            while (l<=r):
                mid = l + (r-l)/2
                ## if mid is target check if last occurance by comparing to right neighbour 
                if nums[mid] == target and (mid== len(nums)-1 or nums[mid] < nums[mid+1]):
                    return mid
                ## move left if greater than target    
                elif nums[mid] > target:
                    r = mid-1
                ## move right    
                else:
                    l = mid+1
            return -1
        
        ## start with the base condition, if size 0 return
        if len(nums) ==0 :
            return [-1,-1]

        first = first_binary_search(self,nums,target)
        ## if no first index found, no need to do second binary search
        if first == -1:
            return [-1,-1]

        second= second_binary_search(self,nums,target,first)
        return [first,second]




#####################################
# Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
# Time Complexity : O(Logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ## We can reduce the search space by half either looking into left or right side since we have 
        ## rotated sorted, Intution is to use binary search
        left, right = 0, len(nums)-1
    
        while left <= right:
            
            if nums[left]<= nums[right]:
                return nums[left]

            mid = left + (right-left)/2
            ## checking if mid is smaller than both the neighbours, if yes return index
            if (nums[mid] < nums[mid+1]) and nums[mid] < nums[mid-1]:
                return nums[mid]
            
            ## check if left side is sorted and check there
            if nums[left] <= nums[mid]:
                left = mid+1
            ## else check the right side    
            else:
                right= mid -1
        return -1


            


#####################################

# Problem 3: (https://leetcode.com/problems/find-peak-element/)
# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        ## we can start with binary search why ?
        ## because we want to reduce the search space everytime by half
        ## how do I know if I have reached the peak? - check the neighbors
        ## if highest from both the neighbours then we can say we have reached a peak
        ## where to go in case we are not at peak? go to the higher side and we will surely reach the peak
        ## we can go either side, to find a peak, but for this we will traverse to higher side
        l=0
        r=len(nums)-1

        while (l<=r):
            if len(nums) ==1:
                return 0

            mid = l + (r-l)/2
            ## if mid is greater than both left and right neighbour
            if (mid ==0 or nums[mid] > nums[mid-1]) and (mid ==len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            ## if left is higher move right
            if mid!=0 and nums[mid-1] > nums[mid]:
                r = mid-1
            ## if right is higher move left
            else:
                l = mid+1
        return -1
        