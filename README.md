# JAVA Algorithm

## Directory

- backjoon : 백준 알고리즘 단계별 풀이
- dataStructure : 자료구조, 알고리즘 예제 정리
- programmers : 프로그래머스 고득점kit 풀이

# 알고리즘 성능 표현 방법

## 효율적인 알고리즘이란?

- 시간이 짧고, 자원을 덜 사용하는 것이 효율적인 알고리즘이다.

## Big - O는 알고리즘의 성능을 수학적으로 표기해주는 표기법

(실제 러닝타임을 표시하는 것 보다 데이터나 사용자의 증가율에 따른 알고리즘의 성능을 예측하는 게 목표이다.)  
-> 상수와 같은 숫자들은 모두 1이 된다.

1. 시간 복잡도

- 연산을 숫자로 표기한 것을 말합니다.
  (시간 복잡도를 더 중요하게 생각하기 때문에, 별다른 말이 없으면 시간복잡도를 뜻한다.)

2. 공간 복잡도

- 프로그램을 실행시킨 후 완료하는데 필요한 자원의 공간

입력이 n일 때 연산 횟수 -> 알고리즘 속도

- 연산이 커지면 계수는 의미없어지고, 차수가 중요하다!

O(1) /배열의 요소 참조
: 입력 데이터 타입의 크기에 상관 없이 언제나 일정한 시간이 걸리는 알고리즘을 말한다.

- 데이터가 증가함에 따라 성능 변화가 없다.

O(n) /순차탐색
: 입력 데이터의 크기에 비례해서 처리 시간이 걸리는 알고리즘을 표현할 때 사용

- N의 크기만큼 처리 시간이 늘게된다.

O(n 스퀘어(2승)) /bubble sort
: n을 돌리면서, n으로 또 돌릴 때 사용한다.

O(nm)
: m을 n만큼 돌린다.

O(n의 3제곱)
: n을 3제곱 만큼 시간이 더 걸린다.

O(2의 n승)
:
ex) 피보나치 수열
(재귀적으로 구현 가능! / 함수를 호출할 때마다, 바로 전의 숫자와 전전숫자를 알아야 하기 때문에 매 번 함수를 호출할 때마다, 2번씩 호출한다. -> 2진트리의 형태 -> 트리의 높이만큼 반복한다.

O(log n) / 2진 검색
: 처리를 할 때마다, 처리 해야 할 데이터 양이 반씩 줄어드는 경우
( 함수 (키, 배열, 시작, 끝)

O(스퀘어 루트 엔)

# 프로그래머스 고득점 Kit 개념 정리

# 1. 해시

- '키'와 '값'을 저장하는 자료 구조
- 해시 함수를 통해 '키'와 '값'이 저장되는 위치를 결정하므로, 사용자는 그 위치를 알 수 없고, 삽입되는 순서와 들어 있는 위치 또한 관계가 없다.
- <b>검색</b> 과 <b>저장</b>의 평균적인 시간 복잡도가 O(1)에 수렴하게 된다.
- 값이 추가로 들어오면 List처럼 저장공간을 한 칸씩 늘리지 않고 약 두배로 늘린다.  
  -> 이 과정이 과부하가 많이 걸리기 때문에 초기에 저장해주는 것이 좋다.

- ex) HashMap<Integer,String> map = new HashMap<>(10);

## 주요 메소드

- put() : HashMap에 키와 값을 저장
- get() : 지정된 키값을 반환한다.
- remove() : HashMap에서 지정된 키로 지정된 값을 제거한다
- clear() : HashMap의 모든 객체를 제거한다.
- containsKey() : HashMap에 지정된 키가 포함되어 있는지 알림
- isEmpty() : HashMap이 비어있는지 확인
- size() : HashMap에저장된 요소의 개수를 반환한다.
- keySet() : HashMap에 저장된 모든 키가 있는 Set을 반환한다.
- 참고 https://vaert.tistory.com/107

# 2. 스택/큐

# Stack

## Stack<T> stack = new Stack<>();

- LIFO
- Top

## 특징

- 원소 추가 O(1)
- 원소 제거 O(1)
- 원소 확인(TOP) O(1)

## 주요 메소드

- pop() : 가장 나중에 넣은 데이터 삭제
- push() : 데이터 추가
- peek() : 가장 나중에 넣은 데이터 확인
- isEmpty() : 비어있는지 확인
- size() : 스택에 있는 요소 크기 반환

## Tip!!

1. stack 2개 써서 LinkedList처럼 사용 가능! (데이터 추가/삭제 -> O(1))

# Queue

## Queue<T> queue = new LinkedList<>();

## 특징

- FIFO
- head, tail

## 주요 메소드

- add() : 가장 앞에 데이터 추가
- remove() : 가장 나중에 값 삭제
- peek() : 가장 앞 데이터 확인
- isEmpty() : 비어있는지 확인
- size() : 큐에 있는 요소 반환

# Deque

## Deque<T> deque = new LinkedList<>();

# 3. 트리

# Tree

- 이진트리 : 각 노드가 자식을 최대 2명을 가지는 트리  
  -> 전위순회, 중위순회, 후위순회
- 이진검색트리 : 왼쪽 서브트리에는 해당노드보다 작은 값 / 오른쪽 서브 트리에는 해당 노드보다 큰 값  
  -> 중위순회 방식을 쓴다.(정렬 순서대로 읽을 수 있음.)
- Trie(트라이) 트리 : 문자열을 저장하고 효율적으로 탐색하기 위한 트리 형태의 자료구조

# Heap

- 최대값이나 최소값을 빠르게 찾기위해 고안된 완전이진트리를 기반으로한 자료구조
- MinHeap : 가장 작은값이 root노드 / MaxHeap : 가장 큰 값이 root노드
- 노드 추가 시, 가장 마지막에 추가하고 위의 노드와 비교하는 방식으로 정렬
- 노드 삭제 시, root노드의 값을 빼고 정렬하는 방식

# Graph

## 분류

- 정점(vertex) / 간선(edge)
- 방향 유무에 따라 <b>Directed</b> / <b>Undirected</b> graph로 나뉜다.
- 써클 유무에 따라 <b>Cyclic</b> / <b>Acyclic</b> graph로 나뉜다.

## 표현방법

- 1차원 -> Adjacency List
- 2차원 -> Adjacency Matrix

## 검색방법

- Depth First Search(DFS) : 깊이우선검색 -> <b>Stack 이용</b>
- Breadth First Search(BFS) : 너비우선검색 -> <b>Queue 이용</b>

# 4. 정렬

## 1) 퀵정렬

## 2) 병합정렬

## 3) 버블정렬

## 4) 선택정렬

# 5. 완전탐색

- 완전 탐색은 모든 답을 하나씩 검사한다. 걸리는 시간은 가능한 답의 수가 정확히 비례

# 6. 탐욕법

- 상황마다 최적의 값 결정
  -> 빠름

# 7. 동적계획법

- 전체 문제를 여러 개의 하위 문제로 나누어 풀고, 하위 문제들의 해결방법들을 결합하여 최종 문제를 해결하는 방식
  -> 모든해 탐색

# 8. 깊이/너비 우선 탐색(DFS/BFS)

- DFS -> 스택 / BFS -> 큐

# 9. 이분탐색

# 10. 그래프

# Tip!!

# 재귀함수

- 재귀 함수는 재귀 깊이가 예측 가능한 경우 위주로 사용
- 순환 조건 / 종료조건 필요!

# 분할정복

- 작은 문제로 나누어 푸는 방법

# 동적 계획법

- 작은 문제가 반복되는 것 (작은 문제가 바뀌지 않음)

## 1. Top_down

- 큰 문제를 풀 때 작은 문제가 풀리지 않았으면 그 때 작은문제 해결
- 재귀함수로 구현하면 대부분 이 방법이다.

## 2. Bottom_up

- 작은 문제부터 차근차근 구해나감

# JAVA Tip!

- 문자열 추가 : String class사용 < <b>StringBuilder</b> class 사용

# JAVA 컬렉션 프레임워크

https://gangnam-americano.tistory.com/41
https://coding-factory.tistory.com/550
https://gbsb.tistory.com/247
