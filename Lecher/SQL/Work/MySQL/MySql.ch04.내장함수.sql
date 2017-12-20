-- @@@@@@@@@@
-- from 절 생략 여부
-- MySql  : 테이블 생략 가능
-- Oracle : 테이블 생략 불가. dual 테이블 사용.
--          dual 테이블은 oracle에만 있는 1행1열의 테이블이다.
--          dual 테이블은 단순 계산이나 연산을 위해서 사용된다.
-- MsSql  : 테이블 생략 가능
-- @@@@@@@@@@

-- 24*35의 계산 결과를 출력하시오.
select 24*35;

-- 현재 날짜와 시간을 출력하시오
select now(); 

-- 현재 날짜를 출력하시오
select curdate(); 
-- 현재  시간을 출력하시오
select curtime(); 

-- @@@@@@@@@@
-- 숫자 관련 함수
-- @@@@@@@@@@

-- 정수값 구하기: floor
select floor(2356.2578);

-- 2356.2578을 반올림: round
-- round를 이용하여 356.2578에서 정수만 출력하시오.
select round(2356.2578,0);

-- round를 이용하여 356.2578에서 정수 두번째 자리에서 반올림하여 출력하시오.
select round(2356.2578,-2);

-- round를 이용하여 356.2578에서 소수 세번째 자리에서 반올림하여 출력하시오.
select round(2356.2578,+2);


-- 버림: truncate / trunc
-- mysql : truncate
-- oracle : trunc
-- truncate(trun)를 이용하여 2356.2578에서 정수만 출력하시오. - 2356
select truncate(2356.2578,0);

-- truncate(trun)를 이용하여 2356.2578에서 정수 두번째 자리에서 버리시오. - 2300
select truncate(2356.2578,-2);

-- truncate(trun)를 이용하여 2356.2578에서 정수만 출력하시오. - 2356.25
select truncate(2356.2578,+2);


-- 나머지 구하기: mod
-- mod를 이용하여 2356을 3으로 나눈 나머지를 구하시오. 2356
select mod(2356, 3);

select mod(2356.2578, 3);

-- @@@@@@@@@@
-- 문자 관련 함수 
-- @@@@@@@@@@

-- 대문자 변환 : upper()
select upper ('laf dfdfjidjkmjldjfjojlk강강차');

-- 소문자 변환 : lower()
select lower ('DLFKJ DKFJKLL;KJLK DKFJKJL 강하기');

-- 문자 길이 구하기. length(). 한글은 2byte, 영문자는 1byte
select length ( 'kfa 가나다');

-- 바이트 길이 구하기. 한글은 2byte, 영문자는 1byte


-- 문자열 추출. 
-- MySQL  : substring
-- Oracle : substr
select substring('abcdefghij' , 4,4);
select substring('abcdefghij' , 4);
select substring('abcdefghij' , -5);
select substring('abcdefghij' , -5,3);

-- 왼쪽에 기호 채우기. lpad
select lpad( 'abcd', 10, '*');
select lpad( 'abcd', 10, 0);
select lpad( 'abcd', 10, '0');

-- 오른쪽에 기호 채우기. rpad
select rpad( 'abcd', 10, '*');
select rpad( 'abcd', 10, 0);
select rpad( 'abcd', 10, '0');

-- 문자열 바꾸기. replace
select 'abcdefghij', replace( 'abcdefghij', 'de', '  ');


-- @@@@@@@@@@
-- 날짜 관련 함수 
-- MySQL  : now()   , curdate(,) curtime(), date_format(), date add, date sub()
-- Oracle : sysdate, systimestamp, to date()
-- @@@@@@@@@@

-- 현재 날짜와 시간을 출력하시오
select now();
select now()from emp;empno from emp;



-- 현재 날짜를 출력하시오
select curdate();

-- 현재  시간을 출력하시오
select curtime();

-- 현재 날짜를 'YYYY/MM/DD' 포맷으로 출력하시오
select now(), date_format( now(),'%Y');
select now(), date_format( now(),'%y');
select now(), date_format( now(),'%M');
select now(), date_format( now(),'%m');
select now(), date_format( now(),'%D');
select now(), date_format( now(),'%d');




-- 현재 날짜를 'YYYY-MM-DD' 포맷으로 출력하시오
select now(), date_format( now(), '%Y/%m/%d');

-- 현재 emp테이블에서 이름(ename)과 입사일(hiredate)를 출력하시오
-- 입사일(hiredate)은 '17/10/16' '연도2자리/월/일'"형태로 출력하시오
select dname, date_format(hiredate,'%y/%m/%d') from emp;

-- 현재 emp테이블에서 입사일(hiredate)를 date_format을 사용하여 연도4자리_월_일 포맷으로 출력하시오
select hiredate date_format(hirdate, '%Y_%m_%d') from emp;

-- 입사일(hiredate)은 'hh:mm:ss' 포맷으로 출력하시오
select now(), date_format(now(), '%H');
select now(), date_format(now(), '%h');
select now(), date_format(now(), '%i');
select now(), date_format(now(), '%s');
select now(), date_format(now(), '%T');

select now(), curtime(), date_format( now(), '%H:%i:%s'), date_format(curtime(), '%H:%i:%s') ;
select now(), date_format( now(), '$T');

-- 이번달의 첫째날 요일 구하기
select '2017-10-01', date_format('2017_1-_01', '%a');

-- 오늘은 이번달의 몇 주차인가?
select now(), dayofweek( now() );
-- 지금부터 '2014-01-01'까지의 개월 수 구하기 timestampdiff()
select now(), '2014_01_01', timestampdiff( MONTH, now(), '2014_01_01');
-- 지금부터 '2014-01-01'까지의 년수수 구하기 timestampdiff()
select now(), '2014_01_01', timestampdiff( YEAR, now(), '2014_01_01');


-- 오늘 날짜에 6개월 추가하기
select now(), date_add( now(), INTERVAL 6 MONTH );


-- 오늘 날짜에 -6개월 계산하시오
select now(), date_add( now(), INTERVAL -6 MONTH );

-- 오늘날짜에 17년 후를 계산하시오.
select now(), date_add( now(), INTERVAL 17 MONTH );

-- 지금부터 가장 가까운 수요일은 몇일후 인가?

-- 지금부터 가장 가까운 수요일은 몇일인가?

-- 해당 월의 마지막 일을 구하기








-- @@@@@@@@@@
-- 형변환 함수 
-- MySQL : convert() : date <--> character <--> number
-- Oracle : to_char, to_date, to_number
-- @@@@@@@@@@

-- 현재일자를 문자열로 변환 : YYYY, MM, DD

-- 현재시간을 문자열로 변환

-- 통화 기호 붙이기.
-- MySql  : 안됨.
-- Oracle : 가능


-- 문자를 날짜로 변환. 변환 후 DATE 포맷이 된다.


-- 문자를 숫자로 변환
select '120'     , convert( '_120' ,SIGNED );
select '120'     , convert( '_120' ,UNSIGNED);
select '120.124' , convert( '_120.124',DECIMAL( 10,0));



-- 문자를 숫자로 변환시 숫자의 포맷 지정하기
select '20,000,000.73797874857848'
       , replace( '20,000,000.73797874857848',',','');
       , convert(replace ( '20,000,000.73797874857848',',',''), DECIMAL(22,14));

set @aaa ;= '20,000,000.7379787857848';
set @bbb ;=replace( '20,000,000.7379787857848',',','');
select @ccc ;= length(@bbb)-1;
select @aaa,@bbb,@ccc,convert (@bbb,DECIMAL(22,14);


-- 문자를 숫자로 변환: 20,000,000.73797874857848 을 숫자로 바꾸시오.



-- @@@@@@@@@@
-- 윤달 테이블 만들기
-- @@@@@@@@@@


-- @@@@@@@@@@
-- NULL을 처리하는 함수 : ifnull()
-- @@@@@@@@@@

-- ifnull 사용법
select ifnull (null,1);
select ifnull ( 0  ,1);
select ifnull ('0', 1);

-- @@@@@@@@@@
-- 선택 함수 : CASE 문. 자바의 연속if 와 유사
-- CASE WHEN ELSE 
-- @@@@@@@@@@ 


-- CASE WHEN THEN ELSE를 사용하여 부서명을 출력하시오.
--deptno = 10 이면 경리부
--deptno = 20 이면 인사과
--deptno = 30 이면 영업부
--deptno = 40 이면 전산부
--아니면 나머지부
select ename, deptno,CASE WHEN deptno=10 THEN '경리부'
                          WHEN deptno=20 THEN '인사과'
                          WHEN deptno=30 THEN '영업부'
                          WHEN deptno=40 THEN '전산부'
                          ELSE '나머지부'
                     END
from emp;

-- 지금부터 가장 가까운 수요일은 몇 일후 인가? case when then else
-- if(dayofweek( now() ) .=4) {
-- e - dayofweek( now() )
-- }
-- else {
--  4 + (7-dayofweek( now() ) )
-- }


--수요일 이전인 경우
select now()
     , dayofweek( now() )
	  , CASE WHEN dayofweek( now() ) <= 4 THEN 4 - dayofweek( now() )
	        ELSE 4 + (7-dayofweek( now() ) ) 
	END as '일수';
 
 
--수요일 초과인 경우 
select now(), dayofweek( now() ), 4 + (7-dayofweek( now()));  



-- @@@@@@@@@@@@@@
-- 미션
-- @@@@@@@@@@@@@@


-- 오늘 날짜에서 월을 추출하려면
-- 입사일에서 월을 추출하려면
-- 미션 1. substring 함수를 사용하여 9월에 입사한 사원을 출력하기. 1개
select * from emp where substring (hiredate, 6, 2) = '09';

-- 미션 2. SUBSTR 함수를 이용하여 2003년도에 입사한 사원을 검색하기. 2개

-- 미션 3. 이름(ename)이 '기'로 끝나는 사원을 검색하시오. 2개


-- 미션 4. 이름의 두 번째 글자에 '동'이 있는 사원을 검색하기. 2개


-- 미션 5. 직급(job)에 따라 직급에 따라 급여를 인상하시오.
-- '부장'인 사원은 5% 인상 
-- '과장'인 사원은 10% 인상
-- '대리'인 사원은 15% 인상 
-- '사원'인 사원은 20% 인상

select   deptno, job, sum(sal)
from emp
where
group by job('부장');
having
order by


-- 미션 6. 입사일을 연도는 2자리(YY), 
--         월은 숫자로 표시하고 
--         요일은 약어(DY)로 출력하시오.
-- 구글 검색을 이용 


