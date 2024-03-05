def solution(n, computers):
    answer = 0
    
    visited = [False] * len(computers)
    q = []
    
    for cIdx, computer in enumerate(computers):
        for idx, value in enumerate(computer):
            if cIdx == idx:
                continue
            if visited[idx] == True:
                continue
            q.append(idx)
            visited[idx] = True
            answer += 1
            
            while(len(q) != 0):
                cur = q.pop()
                for i in range(0, n):
                    if cur == i:
                        continue
                    if visited[i] == False and computers[cur][i] == 1:
                        visited[i] = True
                        q.append(i)
    
    for visit in visited:
        if(visit == False):
            answer += 1
    
    return answer