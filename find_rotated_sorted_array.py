def binarySearch(arr, l, r, x): 
    #write your code here
    print(l)
    print(r)
    print(x)
    while(l<=r):
        mid = int((l+r)/2)
        if (arr[mid]==x):
            return mid
        elif (x>arr[mid]):
            #search on the right side of the middle element
            l = mid + 1
        else:
            r = mid - 1
    return -1

def search(arr,target):
    low = 0
    high = len(arr)
    mid = int((low+high)/2)
    print(arr[mid])
    if (arr[mid]>target):
        idx = binarySearch(arr,low,mid,target)
        return idx
    else:
        idx = binarySearch(arr,mid+1,high,target)
        return idx

arr = [4,5,6,7,0,1,2]
index = search(arr,5)
print(index)