from collections import deque

def solution(begin, target, words):
    if target not in words:
        return 0

    return search(begin, target, words)

def search(begin, target, words):
    
    queue = deque()
    queue.append([begin, 0]) # 시작 단어, depth
    
    while queue:
        cur, depth = queue.popleft()
        
        if cur == target:
            return depth
        
        for word in words:
            cnt = 0
            for idx, part in enumerate(cur):
                if part != word[idx]:
                    cnt += 1
            
            if cnt == 1:
                queue.append([word, depth + 1])