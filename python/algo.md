# 0. 기초

## 0.1 list

```python
# 리스트 길이 지정, 0으로 초기화
my_list = [0 for _ in range(n)] # 리스트 컴프리헨션
my_list = [0] * n

# 조건필터 추가
my_list = [1,2,3,4,5,6,7,8,9,10]
even = [i for i in my_list if i % 2 == 0]
# [2, 4, 6, 8, 10]

# 별도의 연산 추가
even = [i ** 2 for i in my_list if i % 2 == 0]
# [4, 16, 36, 64, 100]

my_list = ['a','b','c']

# 리스트 포함 여부 in
if 'b' in a:
    print("포함")
else:
    print("비포함")

# 마지막 값 가져오기
my_list[-1]

# 리스트 값 추가
my_list.append('d')
# ['a','b','c','d']

my_list.insert(2, "baba") # 2번 인덱스에 "baba" 추가
# ['a','b','baba','c','d']

# 리스트 값 업데이트 -> 그냥 바꾸면 됌

# 리스트 값 삭제
my_list.remove('a')

# 인덱스로 삭제
del my_list[-1]

## 리스트 마지막 요소 제거
deleted_value = my_list.pop()
my_list = my_list[:-1]

# 2차원 배열
dp = [[0 for _ in range(triDepth)] for _ in range(triDepth)]

# graph구조


```

## 0.2 for문

for case

```python
for i in range(n):
    output[i] = prefix
    prefix *= nums[i]

# 이게 초기식 조건식 증감식?
for i in range(n-1, -1, -1):
    output[i] *= postfix
    postfix *= nums[i]

for idx, val in enumerate(list):
    print(idx + ' ' + val)
```

## 0.3 while

## 0.4 대소문자

```python
a.lower() # a list 모두 소문자로

a.upper() # a list 모두 대문자로
```

## 0.5 형변환

```python
number = 10
# int to string
str(number)

a = "10"
# string to int
int(a)

# string to string list

a = "I love python"
print(a.split()) # 공백을 기준으로 나눈다.

a = "I/love/python"
print(a.split('/')) # /를 기준으로 나눈다

a = "I love python"
print(list(a)) # 한 문자씩 나눈다.

# string list to string
list = ['a', 'b', 'c']

print(''.join(list))
#-- print: abc

print(','.join(list))
#-- print: a,b,c

# string to char list
numbers[i] = list(str(numbers[i]))
```

## 0.6 슬라이싱

a[start : end : step]

각각 start, end, step 모두 양수와 음수 가능

- start: 시작 위치
- end: 끝낼 위치, end는 포함x
- step: 몇개 씩 끊어서 가져올지 (옵션)
  - step 양수 : 오른쪽으로 step만큼 이동
  - step 음수 : 왼쪽으로 step만큼 이동

```python
str = "asdfasdf"
my_list  = ['a', 'b', 'c', 'd', 'e']

str[:-1]         # 마지막 문자 제거

my_list[1:]         # 특정 시작위치부터 끝까지 가져오기

my_list[:2]         # 시작점부터 특정 위치까지 가져오기

my_list[2:4]        # 특정 위치에서 끝까지 가져오기

my_list[3:0:-1]     # 인덱스 1 ~ 3까지의 값을 거꾸로 가져오기

my_list[::2]        # 2칸씩 이동하며 가져오기
# ['a', 'c', 'e']

my_list[::-1]       # 전체 거꾸로 가져오기

my_list[3::-1]      # index 3부터 거꾸로 가져오기
# ['d', 'c', 'b', 'a']

```

## 0.7 3항연산자

```python
last_day = (29 if year % 400 == 0 or year % 4 == 0 and year % 100 else 28) \
          if (month==2) else (30 if month%2 else 31) \
          if (month>=8) else (31 if month%2 else 30)
```

## 0.8 문자열

```python
test_str = "asdfasdf"

# 슬라이싱 활용
test_str[0] # a
test_str[2] # c

# 문자열 값 변경
# 특정 패턴 값 변경
# 문자열.replace("검색 문자", "치환문자", 치환 횟수)
test_str.replace("a","b") # bsdfasdf

# 원하는 위치 문자 변경
test = list(test_str)
test[0] = "z"

# 정규 표현식으로 변경

# 문자열 연결 방법으로 문자 변경

```

## 0.9 기타 내장함수

```python

a / b # 나누기
a // b # 나누고 몫만 사용

import math # 수학 관련 함수

arr = ['a','b','c']

print(len(arr)) # 길이

min(arr) # 가장 작은 값
max(arr) # 가장 큰 값
range(A, B) # 범위 생성 -> A ... B - 1 까지 리스트로 생성

# 소수 판별


```

# 1. 날짜

# 2. 정렬

```python
# 본체 list 정렬

my_list.reverse() # 거꾸로

my_list.sort() # 오름차순

my_list.sort(reverse=True)

my_list.sort(key=lambda x : len(x)) # 길이 순으로 정렬

# 정렬된 결과 반환

my_list2 = sorted(my_list)

my_list2 = reversed(my_list)

# 특정 기준으로 리스트 정렬

arr = ['abc', 'bac', 'bca']
sorted(arr, key=lambda x : x) # 사전순으로 정렬
# arr -> 반복 할 단위 (x를 지정할 전체 단위)
# x) -> 앞서 반복할 단위의 각 원소를 x라고 할 때 어떤 기준으로 정렬할 지

# 람다함수 -> lambda <<매개변수>> : <<리턴 값>>
sorted(arr, key=lambda x : x[0]) # 원소의 첫글자 기준으로 정렬

```

# 3. 완전탐색

# 4. set, map

```python
# set
set_even = {i**2 for i in mylist if i % 2 == 0} # set 컴프리헨션
# {4, 16, 36, 64, 100}

my_set = {1, 2, 3, 4, 5}

# 그냥 가져오기
for element in my_set:
    print(element)

# 리스트 변환 후 가져오기
my_list = list(my_set)
for i in range(len(my_list)):
    print(my_list[i])

# set값 추가
my_set.add(6)

# set값 수정
my_set.update(1,2,3)

# set값 삭제
my_set.remove(3)

# ---

# map
# map 컴프리헨션
li = ['A','B','C']
di = {x:0 for x in li}
# {'A': 0, 'B': 0, 'C': 0}

my_list = [1,2,3,4,5,6,7,8,9,10]
dict_even = {i:i**2 for i in my_list if i % 2 == 0}
# {2: 4, 4: 16, 6: 36, 8: 64, 10: 100}


dictionary = {
  "apple" : 5,
  "banana" : 10,
  "grape" : 8
}

# key, value 사용
for key, value in dictionary.items() :
    print(key, value)

# key 사용
for key in dictionary :
    print(key, dictionary[key])

# value 사용
for value in dictionary.values() :
    print(value)

# dict값 추가
dict['papa'] = 3

# dict값 수정
dict['papa'] = 4

# dict값 삭제
dict.pop('papa')

# map 활용
a = {'a':1,'b':2,'c':3,'d':1}; #도치 대상
#딕셔너리 컬렉션 내포 표현식
b = {value:key for key,value in a.items()}
print(b);
 # {1: 'd', 2: 'b', 3: 'c'}
```

# 5. 스택, 큐, 덱

스택

```python
stack = []

# 값 추가
stack.append(item)

# 값 삭제
stack.pop()

# 맨 위 값 확인
stack[-1]

```

큐

```python

```

덱

```python

```

# 6. 조합

# 7. 백트래킹

# 8. DP

# 9. 누적합

# 10. 그리디

# 11. 분할정복

# 12. 이분탐색

# 13. 우선순위 큐

# 14. DFS / BFS

최소 경로일 경우 -> BFS활용

# 15. 그래프

# 16. 최단거리

# 17. 투포인터

# 18. 트리

# 19. 최소신장트리

# 20. 유니온파인드

# 21. 위상정렬
