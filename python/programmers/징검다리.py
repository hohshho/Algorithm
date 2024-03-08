def solution(distance, rocks, n):
    answer = 0
    left, right = 0, distance
    rocks.sort()

    while left <= right:
        mid = (left+right)//2
        current, removeRockCnt = 0,0

        for rock in rocks:
            diff = rock - current
            if diff < mid:
                removeRockCnt += 1
            else:
                current=rock
        
        if distance - current < mid:
            removeRockCnt += 1

        if removeRockCnt > n:
            right = mid-1
        else:
            left = mid+1
            answer = mid

    return answer