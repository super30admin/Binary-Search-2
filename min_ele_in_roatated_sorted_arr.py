class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==0 or nums==None:
            return int(sys.maxsize)
        
        low=0
        high=len(nums)-1
        while low<=high:
            if nums[low]<=nums[high]: #check if arr is already sorted. (Less than eq to beacuse i there is only1 element)
                return nums[low]
            
            mid=low+(high-low)//2
            if (mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]): #check if mid is smallest
                return nums[mid]
            
            if nums[low]<=nums[mid]: #if left sorted
                low=mid+1 #go to unsorted side
            else:
                high=mid-1 #means right is sorted, go to left
        
        return 54535
        

#time_complexity 0(logN)
#space complexity = 0(1)