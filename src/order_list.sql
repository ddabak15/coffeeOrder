CREATE TABLE ORDER_LIST (
	SEQ NUMBER(8) PRIMARY KEY,
	ID VARCHAR2(30) NOT NULL,
	COF_NAME VARCHAR2(30) NOT NULL,
	COF_SYSDATE DATE NOT NULL,
	COF_SIZE VARCHAR2(10) NOT NULL,
	COF_COUNT NUMBER(10) NOT NULL,
	COF_PRICE NUMBER(10) NOT NULL
);

CREATE SEQUENCE SEQ_ORDER_LIST
START WITH 1
INCREMENT BY 1;

SELECT * FROM ORDER_LIST

DROP TABLE ORDER_LIST
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_ORDER_LIST;