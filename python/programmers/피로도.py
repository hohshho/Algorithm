answer = 0
def solution(k, dungeons):
    global answer
    
    visited = [False for i in range(len(dungeons))]

    search(k, dungeons, visited, 0)
    
    return answer

def search(k, dungeons, visited, cnt):
    global answer
    
    for i in range(len(dungeons)):
        if visited[i] or k < dungeons[i][0]:
            continue
        answer = max(answer, cnt + 1)
        
        if(k - dungeons[i][1] < 0):
            continue

        visited[i] = True
        search(k - dungeons[i][1], dungeons, visited, cnt + 1)
        visited[i] = False