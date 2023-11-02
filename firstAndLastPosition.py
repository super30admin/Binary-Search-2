
#Time complexity:-O(n)
#Space Complexity:-O(1)
#Brute force method:-
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = -1
        end = -1
        for i in range(len(nums)):
            if nums[i] == target:
                if start == -1:
                    start = i
                end = i
        return [start, end]
        


#Time complexity:-O(logn)
#Space Complexity:-O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums==None or len(nums)==0:
            return [-1,-1]
        #initalizing two binary search for retreiving the first and last occurrence of the target element.
        first=self.binarySearchFirst(nums,target)
        if first== -1:
            return [-1,-1]
        second = self.binarySearchSecond(nums,target)
        return[first,second]
    
    #if the target element is one the left side, then do binary search 
    def binarySearchFirst(self,nums: List[int], target: int) -> List[int]:
        left=0
        right=len(nums)-1

        while left<=right:
            #finding the middle element of a list.
            mid=left+(right-left)//2
            if nums[mid]==target:
                #if there is only one number and if mid-1 element is less than target element then return that index of an element.
                if mid==left or nums[mid-1]<nums[mid]:
                    return mid
                else:
                    #else shift he lift towards left
                    left=mid-1
                #if target element is greater than middle element shift the left towards right side
            elif target>nums[mid]:
                left=mid+1
            else:
                right=mid-1
        #if nothing found return -1
        return -1
    
    def binarySearchSecond(self,nums: List[int], target: int) -> List[int]:
        left=0
        right=len(nums)-1

        while left<=right:
            mid=left+(right-left)//2
            if nums[mid]==target:
                #if middle element is the last element or middle element is less than middle+1 element then return the index of that element.
                if mid==right or nums[mid+1]> nums[mid]:
                    return mid
                else:
                    #if the above condition does not satisfied then shif the left index towards right
                    left=mid+1
                 #if middle element is not the target element then shif the left index towards right
            elif target>nums[mid]:
                left=mid+1
            else:
                right=mid-1
        #if the element is not found then return -1
        return -1        