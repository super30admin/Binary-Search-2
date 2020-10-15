#Search in Rotated Sorted Array
class Solution5:  #Complexity O(logn)
    def search(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        
        while low<=high:
            mid=(low+high)//2
            if nums[mid]==target: return mid
            else:
                if nums[low]<=nums[mid]: #left sorted

                    if nums[low]<=target & target <nums[mid]:
                        high=mid-1
                    else:
                        low=mid+1

                else:
                    if nums[mid]<target & target<=nums[high]:#right sorted
                        low=mid+1
                    else:
                        high=mid-1
        return -1
                    
                
        
			
#Get first and last index of element in array
class Solution7: 
    #worst case: Complexity O(n)
	#best case: Complexity O(number of target elements)
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start=0
        end=len(nums) - 1
        
        while start <= end: 
            mid = (start+end)//2
            # target in right
            if nums[mid] < target: 
                start = mid + 1
            # target in left
            elif nums[mid] > target:
                end = mid - 1
            else: 
                
                first = mid
                while (first > 0) and nums[first] == nums[first-1]:
                    first=first-1
                    
                last = mid
                while  last < len(nums) - 1 and nums[last] == nums[last+1]:
                    last += 1
                return [first, last]
        return [-1, -1]
		
		
		
#Problem #8 finding minimum in a rotated sorted array	
#Complexity-O(log(n))
class Solution8:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        
        while low<high:
            
            mid=(low+high)//2
            
            if nums[mid] <= nums[high]:
                high=mid
            else:
                low=mid+1
        return nums[low]
