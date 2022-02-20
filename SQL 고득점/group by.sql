-- MYSql / GROUP BY

-- 동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성해주세요. 이때 고양이를 개보다 먼저 조회해주세요.
-- ORDER BY는 항상 GROUP BY 뒤에! 

SELECT ANIMAL_TYPE, COUNT (*)
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE 
ORDER BY ANIMAL_TYPE

-- 동물 보호소에 들어온 동물 이름 중 두 번 이상 쓰인 이름과 해당 이름이 쓰인 횟수를 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 이름이 없는 동물은 집계에서 제외하며, 결과는 이름 순으로 조회해주세요.
-- HAVING 은 GROUP BY의 조건 (WHERE의 느낌) 

SELECT NAME, COUNT (*)
FROM ANIMAL_INS
-- WHERE NAME IS NOT NULL 
GROUP BY NAME 
HAVING COUNT(NAME) >= 2
ORDER BY NAME

-- 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 09:00부터 19:59까지, 
-- 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요. 이때 결과는 시간대 순으로 정렬해야 합니다.
-- HOUR : 시간대에서 시간을 추출
-- 조건문은 AND 또는 OR로 묶음

SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
FROM ANIMAL_OUTS
GROUP BY HOUR(DATETIME)
HAVING HOUR>=9 and HOUR<=19
ORDER BY HOUR(DATETIME)

-- 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다. 
-- 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회하는 SQL문을 작성해주세요.
-- 이때 결과는 시간대 순으로 정렬해야 합니다.
-- @변수 선언 SET, := 는 = 와 같은 역할

SET @HOUR = -1;
SELECT (@HOUR := @HOUR +1) AS HOUR,
    (SELECT COUNT(HOUR(DATETIME)) 
    FROM ANIMAL_OUTS 
    WHERE HOUR(DATETIME)=@HOUR) AS COUNT 
    FROM ANIMAL_OUTS
WHERE @HOUR < 23;