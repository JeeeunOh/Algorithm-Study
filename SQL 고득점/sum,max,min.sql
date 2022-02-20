-- MYSql / SUM, MAX, MIN

/* 기본 문법
SELECT MAX() : 최댓값
SELECT MIN() : 최솟값
SELECT COUNT * : ROW 개수 구하기
SELECT ( ) AS ( NEW TABLE NAME ) : TABLE 이름 NEW TABLE NAME으로 설정
DISTINCT : 중복 제거
IS NOT NULL : NULL인 경우 제외
*/


-- 가장 최근에 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.

-- 1. LIMIT 이용
SELECT DATETIME
FROM ANIMAL_INS
ORDER BY DATETIME DESC
LIMIT 1

-- 2. MAX 이용
SELECT MAX(DATETIME)
FROM ANIMAL_INS

-- 동물 보호소에 가장 먼저 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.

-- 1. LIMIT 이용
SELECT DATETIME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1

-- 2. MIN 이용
SELECT MIN(DATETIME)
FROM ANIMAL_INS

-- 동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL 문을 작성해주세요.

SELECT COUNT(*) AS COUNT
FROM ANIMAL_INS

-- 동물 보호소에 들어온 동물의 이름은 몇 개인지 조회하는 SQL 문을 작성해주세요. 이때 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나로 칩니다.

SELECT COUNT(DISTINCT NAME)
FROM ANIMAL_INS
WHERE NAME IS NOT NULL 