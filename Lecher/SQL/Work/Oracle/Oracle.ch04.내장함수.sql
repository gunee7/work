-- @@@@@@@@@@
-- from �� ���� ����
-- MySql  : from �� ���� ����
-- MsSql  : from �� ���� ����
-- Oracle : from �� ���� �Ұ�. dual ���̺� ���.
--          dual ���̺��� oracle���� �ִ� 1��1���� ���̺��̴�.
--          dual ���̺��� �ܼ� ����̳� ������ ���ؼ� ���ȴ�.
-- @@@@@@@@@@

-- 24*35�� ��� ����� ����Ͻÿ�.
 select 24*35 from dual;

-- @@@@@@@@@@
-- ���� ���� �Լ�
-- @@@@@@@@@@

-- floor : 2356.2578 �� ������ ���Ͻÿ�.
select floor( 2356.2578) from dual;
-- round : 2356.2578 �� �ݿø��Ͻÿ�.
-- round�� �̿��Ͽ� 2356.2578 ���� ������ ����Ͻÿ�.
select round( 2356.2578, 0) from dual;
-- round�� �̿��Ͽ� 2356.2578�� ���� �ι�° �ڸ����� �ݿø��Ͽ�  ����Ͻÿ�.2400
select round( 2356.2578, -2) from dual;
-- round�� �̿��Ͽ� 2356.2578�� �Ҽ� ����° �ڸ����� �ݿø��Ͽ�  ����Ͻÿ�.
select round( 2356.2578, +2) from dual;
-- ����: 
-- MySQL  : truncate 
-- Oracle : trunc

-- truncate(trunc)�� �̿��Ͽ� 2356.2578 ���� ������ ����Ͻÿ�. 2356
select trunc( 2356.2578, 0) from dual;
-- truncate(trunc)�� �̿��Ͽ� 2356.2578�� ���� �ι�° �ڸ����� �����ÿ�. 2300
select trunc( 2356.2578, -2) from dual;
-- truncate(trunc)�� �̿��Ͽ� 2356.2578�� �Ҽ� ����° �ڸ����� �����ÿ�. 2356.25
select trunc( 2356.2578, +2) from dual;
-- ������ ���ϱ�: mod
select mod( 2356,3) from dual;
-- mod�� �̿��Ͽ� 2356�� 3���� ���� �������� ���Ͻÿ�. 1
select mod( 2356.2578,3) from dual;


-- @@@@@@@@@@
-- ���� ���� �Լ� 
-- @@@@@@@@@@

-- ���� ���� ���ϱ�. length(). 'kfa ������' �� ���̷� ó���Ͻÿ�. 13
select lengthb('kfa ������') from dual;

-- MySQL  : �ѱ��� 3byte, �����ڴ� 1byte
-- Oracle : �ѱ��� 2byte, �����ڴ� 1byte

-- ����Ʈ ���� ���ϱ�. �ѱ��� 2byte, �����ڴ� 1byte




-- ���ڿ� ����. 
-- MySQL  : substring
-- Oracle : substr

-- 'abcdefghij'���� efghij�� �����Ͻÿ�
select substr('abcdefghij', 4) from dual;
-- 'abcdefghij'���� fghij�� �����Ͻÿ�
select substr('abcdefghij', -5) from dual;

-- 'abcdefghij'���� fgh�� �����Ͻÿ�
select substr('abcdefghij', -5, +3) from dual;

-- ���ʿ� ��ȣ ä���. lpad
select LPAD('Page 1',15,'*.') from dual;
select lpad('abcd', 10, '0')from dual;
select lpad('abcd',10,0) from dual;


-- �����ʿ� ��ȣ ä���. rpad
select rpad('abcd',10,'0') from dual;
-- ���ڿ� �ٲٱ�. replace.'abcdefghij'����'de'�� �����̽����� ��ĭ���� �ٲٽÿ�
select replace('abcdefghij','de',' ') from dual;
-- �빮�� ��ȯ : upper(). "fa ofakfo ��" �� �빮�ڷ� �ٲٽÿ�.
select upper('fa ofakfo ��') from dual;
-- �ҹ��� ��ȯ : lower(). "FA OFAKFO ��" �� �ҹ��ڷ� �ٲٽÿ�.
select lower('FA OFAKFO ��') from dual;

-- @@@@@@@@@@
-- ��¥ ���� �Լ� 
-- MySQL  : now(), curdate(), curtime(), date_format(), date_add(), date_sub()
-- Oracle : systimestamp  , sysdate ,     to_date()
-- @@@@@@@@@@

-- ���� ��¥�� �ð��� ����Ͻÿ�
select systimestamp from dual;

-- ���� ��¥�� ����Ͻÿ�
select sysdate from dual;
-- ���� �ð��� ����Ͻÿ�
select to_char(systimestamp, 'hh24:mi:ss') from dual;
-- ��¥�� format






-- ���� ��¥�� 'YYYY/MM/DD' �������� ����Ͻÿ�
select systimestamp, to_char(systimestamp,'yyyy/mm/dd')from dual;
-- ����. emp ���̺��� �̸�(ename)�� �Ի���(hiredate) ����ϵ� �Ի���(hiredate)�� "����2�ڸ�/��/��" ���·� ����Ͻÿ�.
select ename, hiredate, to_char(hiredate, 'yy/mm/dd') from emp;
-- emp ���̺��� �Ի���(hiredate)�� '����4�ڸ�-��-��' �������� ����Ͻÿ�.
select hiredate, to_char(hiredate, 'yyyy/mm/dd') from emp;
-- �ð��� format
-- ���� �ð��� 'hh:mm:ss' �������� ����Ͻÿ�
select systimestamp, to_char(systimestamp,'hh24:mi:ss') from dual; 

-- �̹����� ù°�� ���ϱ�.
select trunc(sysdate, 'mm') from dual; --�̹����� ù��
select to_char( trunc(sysdate, 'mm'), 'yyyymmdd') from daul;

-- �̹����� ù°�� ���� ���ϱ�
select trunc(sysdate, 'mm') from dual; --�̹����� ù��
select to_char( trunc(sysdate, 'mm'), 'day') from daul;
-- �̹����� ù°�� ���� ���ϱ�. �Ϲ�ȭ
select sysdate, LAST_DAY(SYSDATE) from dual;     
-- ����. emp ���̺��� �Ի���(hiredate)�� �Ի����� ������ ����ϵǵ��� �Ͻÿ�.
select hiredate, to_char( hiredate,'day') from emp;

-- �ش� ���� ������ ���� ����Ͻÿ�.

 
-- ����. emp ���̺��� �Ի���(hiredate)�� �Ի��� ���� ������ ���� ����ϵǵ��� �Ͻÿ�
select hiredate, last_day(hiredate) from emp;

-- ������ �̹����� �� �����ΰ�? dayofweek
-- mysql ;dayofweek()
-- oracle :�̹����� ���� to_char(sysdate, 'w')
--         ������ ���� to_char(sysdate, 'iw')
select sysdate, to_char(sysdate, 'w') from dual; --�̹����� ����
select sysdate, to_char(sysdate, 'iw') from dual; -- ������ ����

-- ���ݺ��� '2014-01-01'������ ���� �� ���̸� ����Ͻÿ�. 
select '2014_01_01', to_date('2014_01_01', 'yyyy_mm_dd') from dual; --���ڸ� ��¥�� ��ȯ
select sysdate
         , to_date('2014-01-01', 'yyyy-mm-dd') 
         , floor(MONTHS_BETWEEN(sysdate, to_date('2014-01-01', 'yyyy-mm-dd')))
           from dual; 
-- ���ݺ��� '2014-01-01'������ ��� ���̸� ����Ͻÿ�.
select months_between(sysdate, to_date('2014_01_01', 'yyyy-mm-dd')) from dual;
select months_between(sysdate, to_date('2014_01_01', 'yyyy-mm-dd')) /12 from dual;
select floor(months_between(sysdate, to_date('2014_01_01', 'yyyy-mm-dd')) /12 from dual;

-- ����. ���ݺ��� '2014-01-01'������ �ϼ��� ����Ͻÿ�.
select to_date('2014-01-01', 'yyyy-mm-dd') from dual;
select sysdate -to_date('2014-01-01', 'yyyy-mm-dd') from dual;
select floor( sysdate -to_date('2014-01-01', 'yyyy-mm-dd')) from dual;

-- ���� ��¥�� 6���� �ĸ� ����Ͻÿ�.
select sysdate, add_months(sysdate, +6)from dual;
-- ���� ��¥�� -6���� ���� ����Ͻÿ�.
select sysdate, add_months(sysdate, -6)from dual;
-- ����. ���� ��¥�� 17���ĸ� ����Ͻÿ�.
select sysdate, add_months(sysdate, 17*12)from dual;


-- @@@@@@@@@@
-- ����ȯ �Լ� 
-- SQL ������ Ÿ�� : ��¥(date) <--> ����(character) <--> ����(number)
-- MySQL  : convert() : 
-- Oracle : to_char, to_date, to_number
-- @@@@@@@@@@


-- �������ڸ� ���ڿ��� ��ȯ. ��¥ --> ���ڷ� : YYYY, MM, DD

-- ����ð��� ���ڿ��� ��ȯ. ��¥ --> ���ڷ� : hh:mm, hh:mm:ss

-- ���ڸ� ��¥�� ��ȯ. ���� --> ��¥. ��ȯ �Ŀ��� DATE ������ �ȴ�.

-- ���ڸ� ���ڷ� ��ȯ

-- ����. ���� 20,000,000.73797874857848 �� �Ǽ��� �ٲٽÿ�.
select '20,000,000.73797874857848'
      , replace('20,000,000.73797874857848', ',' ,'')
      , to_number( replace(''20,000,000.73797874857848',',','') )
      from dual;

-- @@@@@@@@@@
-- ��ȭ ��ȣ ���̱�.
-- MySql  : �ȵ�.
-- Oracle : ����.
-- @@@@@@@@@@

select sal
      , to_char(sal, '$999,999.99')
      , to_char(sal, 'L999,999.99')
      , to_char(sal, 'U999,999.99')
      from emp;
      
      
      
-- @@@@@@@@@@
-- ���� ���̺� �����
-- @@@@@@@@@@


-- @@@@@@@@@@
-- NULL�� ó���ϴ� �Լ� 
-- MySQL  : ifnull(), if()
-- Oracle : nvl()
-- @@@@@@@@@@
select nvl(null, 1) from dual; -- 1
select nvl(null, 0) from dual; -- 0
select nvl('0', 1) from dual; -- 0




-- @@@@@@@@@@
-- ���� �Լ� : CASE ��. �ڹ��� ����if �� ����
-- CASE WHEN THEN ELSE 
-- @@@@@@@@@@ 


-- CASE WHEN THEN ELSE �� ����Ͽ� �μ����� ����Ͻÿ�.
-- deptno = 10  �̸� �渮��
-- deptno = 20  �̸� �λ��
-- deptno = 30  �̸� ������
-- deptno = 40  �̸� �����
-- �ƴϸ� ��������
select ename, deptno
      , case when deptno=10 then '�渮��'
             when deptno=20 then '�λ��'
             when deptno=30 then '������'
             when deptno=40 then '�����'
             else ;��������'
end
from emp;
        

-- CASE WHEN THEN ELSE �� ����Ͽ� ���ݺ��� ���� ����� �������� �� ���� �ΰ�? 
-- case when then else �� �̿��Ͻÿ�.
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
    END as "����"
    from dual;

-- @@@@@@@@@@@@@@
-- �̼�
-- @@@@@@@@@@@@@@
-- �̼� 1. ���ڿ� ����(substring, substr) �Լ��� ����Ͽ� 9���� �Ի��� ����� ����ϱ�. 1��
-- ���� ��¥���� ���� �����Ϸ���

-- �Ի���(hiredate)���� ���� �����Ϸ���

-- 9���� �Ի��� ������ ã�Ƽ� ����Ͻÿ�.

-- �̼� 2. SUBSTR �Լ��� �̿��Ͽ� 2003�⵵�� �Ի��� ����� �˻��ϱ�. 2��

-- �̼� 3. �̸�(ename)�� '��'�� ������ ����� �˻��Ͻÿ�. 2��

-- �̼� 4. �̸��� �� ��° ���ڿ� '��'�� �ִ� ����� �˻��ϱ�. 2��

-- �̼� 5. ����(job)�� ���� ���޿� ���� �޿��� �λ��Ͻÿ�.
-- '����'�� ����� 5% �λ� 
-- '����'�� ����� 10% �λ�
-- '�븮'�� ����� 15% �λ� 
-- '���'�� ����� 20% �λ�

-- �̼� 6. �Ի����� ������ 2�ڸ�(YY), 
--         ���� ���ڷ� ǥ���ϰ� 
--         ������ ���(DY)�� ����Ͻÿ�.
-- ���� �˻��� �̿� 
-- ���� �˻��� �̿� : http://aesya.tistory.com/15


