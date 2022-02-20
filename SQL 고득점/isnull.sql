-- MY SQL / IS NULL 

-- 이름이 없는 채로 들어온 동물의 ID는 A368930입니다. 따라서 SQL을 실행하면 다음과 같이 출력되어야 합니다.

SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NULL

-- 동물 보호소에 들어온 동물 중, 이름이 있는 동물의 ID를 조회하는 SQL 문을 작성해주세요. 
-- 단, ID는 오름차순 정렬되어야 합니다.

SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL 

-- 입양 게시판에 동물 정보를 게시하려 합니다. 
-- 동물의 생물 종, 이름, 성별 및 중성화 여부를 아이디 순으로 조회하는 SQL문을 작성해주세요. 
-- 이때 프로그래밍을 모르는 사람들은 NULL이라는 기호를 모르기 때문에, 
-- 이름이 없는 동물의 이름은 No name으로 표시해 주세요.
-- IFNULL(컬럼명, "내용") AS 컬럼명

SELECT ANIMAL_TYPE, IFNULL(NAME, "No name") AS NAME, SEX_UPON_INTAKE -- IF NULL을 이용해 NULL 값 처리
FROM ANIMAL_INS
ORDER BY ANIMAL_ID