def findPeek(arr):
    peekarr = list()
    if arr is None:
        return -1
    if len(arr)==1:
        return arr
    for i in range(1,len(arr)-1):
        if (i!=0 and arr[i] is not None and arr[i-1] is not None and arr[i+1] is not None):
            if (arr[i-1]<arr[i] and arr[i+1]<arr[i]):
                peekarr.append(arr[i])
    return peekarr

arr = [1,2,1,3,5,6,4]
arr = findPeek(arr)
print(arr)