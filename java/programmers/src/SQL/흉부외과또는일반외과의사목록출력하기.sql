-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE DATE_OF_BIRTH like '%-03-%' and TLNO IS NOT NULL and gender = 'W'
order by MEMBER_ID ASC