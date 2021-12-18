--제약조건같은것 하나도 안넣은 임시테이블이므로 나중에 제약조건 다 추가할거에요!
CREATE TABLE MEMBER (
	ID VARCHAR2(50),
	PASSWORD VARCHAR2(20),
	NAME VARCHAR2(30),
	NICKNAME VARCHAR2(30),
	PHONE VARCHAR2(20),
	EMAIL VARCHAR2(40),
	JOINDATE DATE,
	PROFILE_IMG_PATH VARCHAR2(500),
	DELFLAG CHAR,
	MANAGER CHAR, 
	FINAL_LOGIN DATE,
	PANALTY CHAR,
	PANALTY_END_DATE DATE,
	DORMANCYFLAG CHAR,
	SNSJOIN CHAR
);

--회원가입
INSERT INTO MEMBER VALUES(
	'MEM1', 'MEM1', 'MEM1', '멤버', '010-2123-1231', 'afd@gmail.com', sysdate,
	0, 'N','N', NULL, 'N', NULL,'N', 'N'
);

--로그인
SELECT * FROM MEMBER
	WHERE ID='MEM1' AND PASSWORD='MEM1';

--로그인 했을 때 최종 로그인 날짜 업데이트
UPDATE MEMBER SET FINAL_LOGIN=SYSDATE WHERE ID='MEM1';

--정보 수정
UPDATE MEMBER SET NAME='NAME', NICKNAME='NICKNAME', PHONE='PHONE', EMAIL='EMAIL' WHERE ID='MEM1';

--회원탈퇴
UPDATE MEMBER SET DELFLAG='Y' WHERE ID=?

--패널티 부여, 패널티 해제
UPDATE MEMBER SET PANALTY='Y', PANALTY_END_DATE = '2021-12-17' WHERE ID='MEM1';

UPDATE MEMBER SET PANALTY='N', PANALTY_END_DATE='' WHERE ID='MEM1';

SELECT COUNT(*) FROM MEMBER	WHERE ID='MEM1';

--=====================게시판=============================
CREATE TABLE NOTICE (
	NOTICE_NUM NUMBER,
	TITLE VARCHAR2(100),
	CONTENT VARCHAR2(2000),
	DELFLAG CHAR,
	REGDATE DATE,
	USERID VARCHAR2(50)
);

CREATE TABLE REPORT (
	REPORT_NUM NUMBER,
	TITLE VARCHAR2(100),
	CONTENT VARCHAR2(2000),
	REFER NUMBER,
	STEP NUMBER,
	"DEPTH" NUMBER,
	DELFLAG CHAR,
	REGDATE DATE,
	SECRETFLAG CHAR,
	USERID VARCHAR2(50)
);

CREATE TABLE INQUIRY(
	INQIURY_NUM NUMBER,
	TITLE VARCHAR2(100),
	CONTENT VARCHAR2(2000),
	REFER NUMBER,
	STEP NUMBER,
	"DEPTH" NUMBER,
	DELFLAG CHAR,
	REGDATE DATE,
	SECRETFLAG CHAR,
	USERID VARCHAR2(50)
);













