-- MY SQL / JOIN

-- INNER JOIN : 내부조인 -> 교집합
-- LEFT/ RIGHT JOIN -> 부분집합

-- 천재지변으로 인해 일부 데이터가 유실되었습니다. 입양을 간 기록은 있는데, 
-- 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.
-- LEFT OUTER JOIN : 입양을 간 기록이 있으므로 JOIN의 왼쪽에 ANIMAL_OUTS 테이블이 필요
-- ANIMAL ID 가 같은 것을 기준으로 LEFT OUTER JOIN
-- OUTS에는 ANIMAL_ID가 있으나 INS에 ANIMAL_ID가 없다면 NULL값으로 존재
-- -> WHERE INS.ANIMAL_ID IS NULL

SELECT OUTS.ANIMAL_ID, OUTS.NAME
FROM ANIMAL_OUTS OUTS 
LEFT OUTER JOIN ANIMAL_INS INS ON OUTS.ANIMAL_ID = INS.ANIMAL_ID -- LEFT OUTER JOIN ( ) ON ( )
WHERE INS.ANIMAL_ID IS NULL
ORDER BY ANIMAL_ID

-- 관리자의 실수로 일부 동물의 입양일이 잘못 입력되었습니다. 
-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.

SELECT INS.ANIMAL_ID, INS.NAME
FROM ANIMAL_INS INS RIGHT OUTER JOIN ANIMAL_OUTS OUTS ON INS.ANIMAL_ID = OUTS.ANIMAL_ID -- RIGHT OUTER JOIN ( ) ON ( )
WHERE INS.DATETIME > OUTS.DATETIME -- 보호시작일이 입양일보다 빠른 경우
ORDER BY INS.DATETIME

-- 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 
-- 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일 순으로 조회해야 합니다.

SELECT INS.NAME, INS.DATETIME 
FROM ANIMAL_INS INS -- 기준이 INS여야 OUTS엔 NULL, INS엔 있는 값을 가져올 수 있음
LEFT OUTER JOIN ANIMAL_OUTS OUTS ON INS.ANIMAL_ID = OUTS.ANIMAL_ID 
WHERE OUTS.DATETIME IS NULL
ORDER BY INS.DATETIME
LIMIT 3



-- 보호소에 들어올 당시에는 중성화1되지 않았지만, 
-- 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.

-- % 는 모든 문자, _ 는 한 글자

SELECT INS.ANIMAL_ID, INS.ANIMAL_TYPE, INS.NAME
FROM ANIMAL_INS INS LEFT OUTER JOIN ANIMAL_OUTS OUTS ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE INS.SEX_UPON_INTAKE LIKE "%Intact%" AND ( OUTS.SEX_UPON_OUTCOME LIKE "%Spayed%" OR OUTS.SEX_UPON_OUTCOME LIKE "%Neutered%")