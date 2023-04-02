# CASE WHEN {조건식} THEN {참일 경우} ELSE {거짓 일 경우} END

SELECT HISTORY_ID, CAR_ID,
       DATE_FORMAT(START_DATE, "%Y-%m-%d") as START_DATE,
       DATE_FORMAT(END_DATE, "%Y-%m-%d") as END_DATE,
       CASE WHEN DATEDIFF(END_DATE, START_DATE) < 29
            THEN
                "단기 대여"
            ELSE
                "장기 대여"
            END AS "RENT_TYPE"
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE >= "2022-09-01" AND START_DATE < "2022-10-01"
ORDER BY HISTORY_ID DESC;


