
# SELECT

## TIME FORMAT

```sql
DATE_FORMAT(column_name, "%Y-%m-%d")
```
## TIME 비교

```sql
DATEDIFF(column1, column2)
```

## 조건식
```sql

CASE WHEN {조건식} THEN {참일 경우} ELSE {거짓 일 경우} END

```

## 집계 함수

|집계 함수 | 설명 |
|---|---|
|MAX	|가장 큰 값| 
|MIN	|가장 작은 값|
|COUNT	|갯수 (NULL값 제외)|
|SUM	|총합|
|AVG	|평균 값|

NULL 포함 x -> null포함 하고 싶으면 ISNULL로 치환

```sql
SELECT AVG(comm) AS avg1
    , AVG(ISNULL(comm, 0)) AS avg2 # NULL인 경우 0으로 치환
FROM empty
WHERE job IN ('MANAGER', 'SALEMAN')
```

### ROUND

```sql
# 1  2  3  .  4  5  5
# -2 -1 0     1  2  3
ROUND(column, 0) # 123
```

### TRUNC, TRUNCATE

`TRUNC(숫자)`

TRUNC를 숫자에 적용하는 경우 소수점을 모두 절사한다.

```sql
SELECT TRUNC(NUM, 1)	-- NUM = 1234.56
  FROM TEMP
```

`TRUNC(날짜)`

옵션이 없는 경우 기본적으로 시간을 절사하며, 옵션을 입력한 경우 입력한 부분까지 표출하고 그 나머지를 "00"으로 초기화

```sql
SELECT TRUNC(DT, 'DD')		-- 시간 절사
     , TRUNC(DT, 'HH24')	-- 분, 초 절사
     , TRUNC(DT, 'MI')		-- 초 절사
  FROM TEMP
```

## 문자열 자르기

# TODO: 
instr

# WHERE

## 특정 문자 포함 여부

```sql

column LIKE "%문자%?"
```

## 특정 문자열 찾기

```sql
SELECT empno
    , server_name
    , INSTR(ename, 'MI')
    , CASE WHEN INSTR(ename, 'MI') > 0 
        THEN 'Y'
        ELSE 'N'
    END AS "포함 여부"
FROM emp
WHERE JOB = 'CLERK'
```

## 문자열 자르기

```sql
# ename에서 M문자 시작위치 부터 2자리 제외
SUBSTR(ename, INSTR(ename, 'M'), 2) 
```

# GROUP BY

## HAVING
```sql
SELECT job
     , SUM(sal) AS sum_sal
  FROM emp
 WHERE deptno IN (20, 30)
 GROUP BY job HAVING SUM(sal) > 5000
```