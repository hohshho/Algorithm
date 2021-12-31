input_arr = list(map(int, input().split()))

if input_arr == sorted(input_arr):
    print('ascending')
elif input_arr == sorted(input_arr, reverse=True):
    print('descending')
else:
    print('mixed')