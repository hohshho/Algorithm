def solution(sizes):
    minSize = 0
    maxSize = 0
    
    for size in sizes:
        temp_min = min(size)
        temp_max = max(size)
        
        if((temp_min) > minSize or (temp_max) > maxSize):
            minSize = max(temp_min, minSize)
            maxSize = max(temp_max, maxSize)
    
    return minSize * maxSize