-- @@@@@@@@@@
-- from 절 생략 여부
-- MySql  : from 절 생략 가능
-- MsSql  : from 절 생략 가능
-- Oracle : from 절 생략 불가. dual 테이블 사용.
--          dual 테이블은 oracle에만 있는 1행1열의 테이블이다.
--          dual 테이블은 단순 계산이나 연산을 위해서 사용된다.
-- @@@@@@@@@@

-- 24*35의 계산 결과를 출력하시오.
 select 24*35 from dual;

-- @@@@@@@@@@
-- 숫자 관련 함수
-- @@@@@@@@@@

-- floor : 2356.2578 의 정수값 구하시오.
select floor( 2356.2578) from dual;
-- round : 2356.2578 을 반올림하시오.
-- round를 이용하여 2356.2578 에서 정수만 출력하시오.
select round( 2356.2578, 0) from dual;
-- round를 이용하여 2356.2578의 정수 두번째 자리에서 반올림하여  출력하시오.2400
select round( 2356.2578, -2) from dual;
-- round를 이용하여 2356.2578의 소수 세번째 자리에서 반올림하여  출력하시오.
select round( 2356.2578, +2) from dual;
-- 버림: 
-- MySQL  : truncate 
-- Oracle : trunc

-- truncate(trunc)를 이용하여 2356.2578 에서 정수만 출력하시오. 2356
select trunc( 2356.2578, 0) from dual;
-- truncate(trunc)를 이용하여 2356.2578의 정수 두번째 자리에서 버리시오. 2300
select trunc( 2356.2578, -2) from dual;
-- truncate(trunc)를 이용하여 2356.2578의 소수 세번째 자리에서 버리시오. 2356.25
select trunc( 2356.2578, +2) from dual;
-- 나머지 구하기: mod
select mod( 2356,3) from dual;
-- mod를 이용하여 2356을 3으로 나눈 나머지를 구하시오. 1
select mod( 2356.2578,3) from dual;


-- @@@@@@@@@@
-- 문자 관련 함수 
-- @@@@@@@@@@

-- 문자 길이 구하기. length(). 'kfa 가나다' 의 길이로 처리하시오. 13
select lengthb('kfa 가나다') from dual;

-- MySQL  : 한글은 3byte, 영문자는 1byte
-- Oracle : 한글은 2byte, 영문자는 1byte

-- 바이트 길이 구하기. 한글은 2byte, 영문자는 1byte




-- 문자열 추출. 
-- MySQL  : substring
-- Oracle : substr

-- 'abcdefghij'에서 efghij를 추출하시오
select substr('abcdefghij', 4) from dual;
-- 'abcdefghij'에서 fghij를 추출하시오
select substr('abcdefghij', -5) from dual;

-- 'abcdefghij'에서 fgh를 추출하시오
select substr('abcdefghij', -5, +3) from dual;

-- 왼쪽에 기호 채우기. lpad
select LPAD('Page 1',15,'*.') from dual;
select lpad('abcd', 10, '0')from dual;
select lpad('abcd',10,0) from dual;


-- 오른쪽에 기호 채우기. rpad
select rpad('abcd',10,'0') from dual;
-- 문자열 바꾸기. replace.'abcdefghij'에서'de'를 스페이스에서 한칸으로 바꾸시오
select replace('abcdefghij','de',' ') from dual;
-- 대문자 변환 : upper(). "fa ofakfo 강" 을 대문자로 바꾸시오.
select upper('fa ofakfo 강') from dual;
-- 소문자 변환 : lower(). "FA OFAKFO 강" 을 소문자로 바꾸시오.
select lower('FA OFAKFO 강') from dual;

-- @@@@@@@@@@
-- 날짜 관련 함수 
-- MySQL  : now(), curdate(), curtime(), date_format(), date_add(), date_sub()
-- Oracle : systimestamp  , sysdate ,     to_date()
-- @@@@@@@@@@

-- 현재 날짜와 시간을 출력하시오
select systimestamp from dual;

-- 현재 날짜만 출력하시오
select sysdate from dual;
-- 현재 시간만 출력하시오
select to_char(systimestamp, 'hh24:mi:ss') from dual;
-- 날짜와 format






-- 현재 날짜를 'YYYY/MM/DD' 포맷으로 출력하시오
select systimestamp, to_char(systimestamp,'yyyy/mm/dd')from dual;
-- 문제. emp 테이블에서 이름(ename)과 입사일(hiredate) 출력하되 입사일(hiredate)은 "연도2자리/월/일" 형태로 출력하시오.
select ename, hiredate, to_char(hiredate, 'yy/mm/dd') from emp;
-- emp 테이블에서 입사일(hiredate)을 '연도4자리-월-일' 포맷으로 출력하시오.
select hiredate, to_char(hiredate, 'yyyy/mm/dd') from emp;
-- 시간과 format
-- 현재 시간를 'hh:mm:ss' 포맷으로 출력하시오
select systimestamp, to_char(systimestamp,'hh24:mi:ss') from dual; 

-- 이번달의 첫째날 구하기.
select trunc(sysdate, 'mm') from dual; --이번달의 첫날
select to_char( trunc(sysdate, 'mm'), 'yyyymmdd') from daul;

-- 이번달의 첫째날 요일 구하기
select trunc(sysdate, 'mm') from dual; --이번달의 첫날
select to_char( trunc(sysdate, 'mm'), 'day') from daul;
-- 이번달의 첫째날 요일 구하기. 일반화
select sysdate, LAST_DAY(SYSDATE) from dual;     
-- 문제. emp 테이블에서 입사일(hiredate)과 입사일의 요일이 출력하되도록 하시오.
select hiredate, to_char( hiredate,'day') from emp;

-- 해당 월의 마지막 일을 출력하시오.

 
-- 문제. emp 테이블에서 입사일(hiredate)과 입사할 달의 마지말 일을 출력하되도록 하시오
select hiredate, last_day(hiredate) from emp;

-- 오늘은 이번달의 몇 주차인가? dayofweek
-- mysql ;dayofweek()
-- oracle :이번달의 주차 to_char(sysdate, 'w')
--         올해의 주차 to_char(sysdate, 'iw')
select sysdate, to_char(sysdate, 'w') from dual; --이번달의 주차
select sysdate, to_char(sysdate, 'iw') from dual; -- 올해의 주차

-- 지금부터 '2014-01-01'까지의 개월 수 차이를 계산하시오. 
select '2014_01_01', to_date('2014_01_01', 'yyyy_mm_dd') from dual; --문자를 날짜로 변환
select sysdate
         , to_date('2014-01-01', 'yyyy-mm-dd') 
         , floor(MONTHS_BETWEEN(sysdate, to_date('2014-01-01', 'yyyy-mm-dd')))
           from dual; 
-- 지금부터 '2014-01-01'까지의 년수 차이를 계산하시오.
select months_between(sysdate, to_date('2014_01_01', 'yyyy-mm-dd')) from dual;
select months_between(sysdate, to_date('2014_01_01', 'yyyy-mm-dd')) /12 from dual;
select floor(months_between(sysdate, to_date('2014_01_01', 'yyyy-mm-dd')) /12 from dual;

-- 문제. 지금부터 '2014-01-01'까지의 일수를 계산하시오.
select to_date('2014-01-01', 'yyyy-mm-dd') from dual;
select sysdate -to_date('2014-01-01', 'yyyy-mm-dd') from dual;
select floor( sysdate -to_date('2014-01-01', 'yyyy-mm-dd')) from dual;

-- 오늘 날짜에 6개월 후를 계산하시오.
select sysdate, add_months(sysdate, +6)from dual;
-- 오늘 날짜에 -6개월 전을 계산하시오.
select sysdate, add_months(sysdate, -6)from dual;
-- 문제. 오늘 날짜에 17년후를 계산하시오.
select sysdate, add_months(sysdate, 17*12)from dual;


-- @@@@@@@@@@
-- 형변환 함수 
-- SQL 데이터 타입 : 날짜(date) <--> 문자(character) <--> 숫자(number)
-- MySQL  : convert() : 
-- Oracle : to_char, to_date, to_number
-- @@@@@@@@@@


-- 현재일자를 문자열로 변환. 날짜 --> 문자로 : YYYY, MM, DD

-- 현재시간을 문자열로 변환. 날짜 --> 문자로 : hh:mm, hh:mm:ss

-- 문자를 날짜로 변환. 문자 --> 날짜. 변환 후에는 DATE 포맷이 된다.

-- 문자를 숫자로 변환

-- 문제. 문자 20,000,000.73797874857848 을 실수로 바꾸시오.
select '20,000,000.73797874857848'
      , replace('20,000,000.73797874857848', ',' ,'')
      , to_number( replace(''20,000,000.73797874857848',',','') )
      from dual;

-- @@@@@@@@@@
-- 통화 기호 붙이기.
-- MySql  : 안됨.
-- Oracle : 가능.
-- @@@@@@@@@@

select sal
      , to_char(sal, '$999,999.99')
      , to_char(sal, 'L999,999.99')
      , to_char(sal, 'U999,999.99')
      from emp;
      
      
      
-- @@@@@@@@@@
-- 윤달 테이블 만들기
-- @@@@@@@@@@


-- @@@@@@@@@@
-- NULL을 처리하는 함수 
-- MySQL  : ifnull(), if()
-- Oracle : nvl()
-- @@@@@@@@@@
select nvl(null, 1) from dual; -- 1
select nvl(null, 0) from dual; -- 0
select nvl('0', 1) from dual; -- 0




-- @@@@@@@@@@
-- 선택 함수 : CASE 문. 자바의 연속if 와 유사
-- CASE WHEN THEN ELSE 
-- @@@@@@@@@@ 


-- CASE WHEN THEN ELSE 를 사용하여 부서명을 출력하시오.
-- deptno = 10  이면 경리부
-- deptno = 20  이면 인사과
-- deptno = 30  이면 영업부
-- deptno = 40  이면 전산부
-- 아니면 나머지부
select ename, deptno
      , case when deptno=10 then '경리부'
             when deptno=20 then '인사과'
             when deptno=30 then '영업부'
             when deptno=40 then '전산부'
             else ;나머지부'
end
from emp;
        

-- CASE WHEN THEN ELSE 를 사용하여 지금부터 가장 가까운 수요일은 몇 일후 인가? 
-- case when then else 을 이용하시오.
-- if( dayofweek( now() ) <= 4)  {
-- 		4 -  dayofweek( now()     )
-- }
-- else {
--		4 + (7-dayofweek( now() ) )
-- }

select sysdate
    , to_char(sysdate, 'd')
    , to_number(to_char(sysdate, 'd'))
    , CASE WHEN to_number(to_char(sysdate, 'd')) <=4 THEN 4- to_number(to_char(sysdate, 'd'))
    ELSE 4+ (7-to_number(to_char(sysdate, 'd')))
    END as "일후"
    from dual;

-- @@@@@@@@@@@@@@
-- 미션
-- @@@@@@@@@@@@@@
-- 미션 1. 문자열 추출(substring, substr) 함수를 사용하여 9월에 입사한 사원을 출력하기. 1개
-- 오늘 날짜에서 월을 추출하려면

-- 입사일(hiredate)에서 월을 추출하려면

-- 9월에 입사한 직원을 찾아서 출력하시오.

-- 미션 2. SUBSTR 함수를 이용하여 2003년도에 입사한 사원을 검색하기. 2개

-- 미션 3. 이름(ename)이 '기'로 끝나는 사원을 검색하시오. 2개

-- 미션 4. 이름의 두 번째 글자에 '동'이 있는 사원을 검색하기. 2개

-- 미션 5. 직급(job)에 따라 직급에 따라 급여를 인상하시오.
-- '부장'인 사원은 5% 인상 
-- '과장'인 사원은 10% 인상
-- '대리'인 사원은 15% 인상 
-- '사원'인 사원은 20% 인상

-- 미션 6. 입사일을 연도는 2자리(YY), 
--         월은 숫자로 표시하고 
--         요일은 약어(DY)로 출력하시오.
-- 구글 검색을 이용 
-- 구글 검색을 이용 : http://aesya.tistory.com/15


