/* 상품 */
CREATE TABLE products (
	PRODUCT_CODE NUMBER NOT NULL, /* 상품코드 */
	NAME VARCHAR2(50), /* 상품이름 */
	PRICE NUMBER, /* 금액 */
	DESCRIPTION VARCHAR2(500), /* 설명 */
	REG_DATE DATE, /* 등록일 */
	DELFLAG CHAR, /* 상품삭제여부 */
	UPDATE_DATE DATE /* 업데이트일 */
);

ALTER TABLE products
	ADD
		CONSTRAINT PK_products
		PRIMARY KEY (
			PRODUCT_CODE
		);

/* 결제 */
CREATE TABLE payments (
	PAYCODE NUMBER NOT NULL, /* 결제코드 */
	IMP_UID VARCHAR2(50), /* 아임포트코드 */
	PG VARCHAR2(30), /* 결제사 */
	PAY_METHOD VARCHAR2(15), /* 결제방법 */
	CARD_NAME VARCHAR2(50),  /* 결제카드사 */
	PAY_STATE VARCHAR2(15), /* 결제상태 */
	PRICE NUMBER, /* 결제금액 */
	PAY_DATE DATE, /* 결제일 */
	CANCELYN CHAR, /* 취소가능여부 */
	CANCEL_DATE DATE, /* 취소일 */
	CANCEL_DESC VARCHAR2(500), /* 취소이유 */
	PRODUCT_CODE NUMBER, /* 상품코드 */
	USERID VARCHAR2(20), /* 회원ID */
	DELFLAG CHAR, /* 결제기록삭제여부 */
	UPDATE_DATE DATE /* 업데이트일 */
	
);

ALTER TABLE payments
	ADD
		CONSTRAINT PK_payments
		PRIMARY KEY (
			PAYCODE
		);
		
ALTER TABLE payments
	ADD
		CONSTRAINT FK_products_TO_payments
		FOREIGN KEY (
			PRODUCT_CODE
		)
		REFERENCES products (
			PRODUCT_CODE
		);

ALTER TABLE payments
	ADD
		CONSTRAINT FK_MEMBER_TO_payments
		FOREIGN KEY (
			USERID
		)
		REFERENCES MEMBER (
			ID
		);