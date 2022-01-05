T = int(input())

def ans(n):
    dp = [1, 2, 4]
    if(n <= 3):
        return dp[n-1]
    else:
        return ans(n-1) + ans(n-2) + ans(n-3)
        

for i in range(T):
    n = int(input())
    print(ans(n))
