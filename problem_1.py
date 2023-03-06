class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = 0
        right = len(nums)-1 
       
        while left <= right and len(nums) > 1 : 
                mid = (left+right)//2  
           

                if target == nums[mid]: 
                    start = mid 
                    while start >= left and target == nums[start]:
                        start -= 1 
                    end = mid 
                    while end <= right and target == nums[end]: 
                        end += 1
                    return [start+1,end-1]
                    
                elif target < nums[mid] : 
                    right = mid -1 
                else :
                    left = mid + 1


        if len(nums) == 1 and target == nums[0]: 
            return [0,0]

        

            
             
        return [-1,-1]

