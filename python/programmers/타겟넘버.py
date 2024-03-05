answer = 0
def solution(numbers, target):
    bfs(numbers, 0, 0, target)
    
    return answer

def bfs(numbers, depth, sum, target):
    global answer
    
    if(depth == len(numbers)):
        if(sum == target):
            answer += 1
        return
    
    bfs(numbers, depth + 1, sum + numbers[depth], target)
    bfs(numbers, depth + 1, sum - numbers[depth], target)
    