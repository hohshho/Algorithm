from collections import deque
def solution(tickets):
    answer = []
    q = deque()
    q.append(("ICN",["ICN"], []))
    
    while q:
        cur, path, visited = q.popleft()

        if len(visited) == len(tickets):
            answer.append(path)
        
        for idx, ticket in enumerate(tickets):
            if ticket[0] == cur and not idx in visited:
                q.append((ticket[1], path+[ticket[1]], visited+[idx]))
                
    
    answer.sort()

    return answer[0]