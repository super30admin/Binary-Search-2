"""
LC:34
#T:O(n)
"""

#Brute force
#T:O(n)
"""
def getIndex(nums,target):
  res=[]
  arr=nums
  for i in range(len(nums)):
    j=i+1
    if arr[i]==target and j<len(arr) and arr[j]==target :
      res.append(i)
      res.append(i+1)
      return res
  res=[-1,-1]
  return res
"""
#T:O(log n)
def getIndex(nums,target,l,h):
  mid=int(l+h/2)
  result=[]
  #base
  while(l<=h):
   print(nums[l],nums[h],nums[mid])
   if target==nums[mid]:
     result.append(mid)
     previous=mid-1
     nxt=mid+1
     if nums[previous]==target:
       result.append(previous)
     elif nums[nxt]==target:
       result.append(nxt)
     else:
       result=[-1,-1]
   return result

   if target<nums[mid]:
     r=mid-1
   else:
     l=mid+1

nums = [5,7,7,8,8,10]
target = 7
h=len(nums)-1
r=getIndex(nums,target,0,h)
print(r)





nums = [5,7,7,8,8,10]
target = 10
r=getIndex(nums,target)
print(r)
