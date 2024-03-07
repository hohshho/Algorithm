from collections import deque
    
class Node:
    def __init__(self, x, y, cnt):
        self.x = x
        self.y = y
        self.cnt = cnt

def solution(maps):
    return search(maps)

def search(maps):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    xLen = len(maps[0])
    yLen = len(maps)
    
    queue = deque()
    queue.append(Node(0, 0, 1))
    # visited = [[False] * xLen] * yLen
    visited = [[False for _ in range(xLen)] for _ in range(yLen)]
    visited[0][0] = True
    
    while queue:
        cur = queue.popleft()
        
        if cur.x == xLen - 1 and cur.y == yLen - 1:
            return cur.cnt
        
        for i in range(4):
            nx = cur.x + dx[i]
            ny = cur.y + dy[i]
            
            if(not check(nx, ny, xLen, yLen) or visited[ny][nx] or maps[ny][nx] == 0):
                continue
            
            visited[ny][nx] = True
            queue.append(Node(nx, ny, cur.cnt + 1))
                
    return -1
    

def check(x, y, xLen, yLen):
    return x >= 0 and y >= 0 and x < xLen and y < yLen
