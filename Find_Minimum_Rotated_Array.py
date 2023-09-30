class Solutions:
    def findMin(self,num:list[int])-> int:
        N = len(num)
        l,r = 0,N-1
        
        while l<r:
            mid =(l+r)//2
            
            if num[mid] > num[r]:
                l = mid+1
            else:
                r = mid
        return num[l]
                
