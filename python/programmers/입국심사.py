import math

answer = 1000000001
def solution(n, times):
    global answer
    
    start = 1
    end = max(times) * n
    
    while(end >= start):
        mid = (start + end) // 2
        cnt = 0
        for time in times:
            cnt += mid // time
            if(cnt >= n):
                break
        if(cnt >= n):
            end = mid - 1
            answer = mid
        else:
            start = mid + 1
    
    return answer
