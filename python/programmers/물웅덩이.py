def solution(m, n, puddles):
    map = [[0] * m for _ in range(n)]
    dp = [[0] * m for _ in range(n)]
    
    for puddle in puddles:
        map[puddle[1] - 1][puddle[0] - 1] = 1
    
    dp[0][0] = 1
    for y in range(n):
        for x in range(m):
            # 물웅덩이 pass
            if map[y][x] == 1:
                continue
            if y == 0 and x == 0:
                continue
            
            dpValue = 0
            if check(x, y - 1, n, m):
                dpValue += dp[y - 1][x] if map[y - 1][x] != 1 else 0
            if check(x - 1, y, n, m):
                dpValue += dp[y][x - 1] if map[y][x - 1] != 1 else 0
            dp[y][x] = dpValue % 1000000007

    return dp[n - 1][m - 1]

def check(x, y, n, m):
    return 0 <= x < m and 0 <= y < n