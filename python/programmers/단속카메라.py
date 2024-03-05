def solution(routes):
    routes.sort()
    
    answer = 0
    max = 0
    for route in routes:
        if(answer == 0 or max < route[0]):
            max = route[1]
            answer += 1
        max = min(max, route[1])

    return answer