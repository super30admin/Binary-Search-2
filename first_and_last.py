// Time Complexity :O(logn)
// Space Complexity :O(1)


// Your code here along with comments explaining your approach
def idx1(): //binary search to find the lower index
  low=0
  high=len(nums)-1
  index=-1

  while(low<=high):
      mid=low+(high-low)//2
      if(nums[mid]==target):
          index=mid
          high=mid-1//if the element is found decrement the right pointer 
      elif(nums[mid]<target):
          low=mid+1
      else:
          high=mid-1

  return index

def idx2()://binary search to find the upper index
  low=0
  high=len(nums)-1
  index=-1

  while(low<=high):
      mid=low+(high-low)//2
      if(nums[mid]==target):
          index=mid
          low=mid+1//if the element is found increment the left pointer 
      elif(nums[mid]<target):
          low=mid+1
      else:
          high=mid-1

  return index
    
idx1,idx2 = idx1(), idx2()
return [idx1, idx2]
