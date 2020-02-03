package dto;

/*
DROP TABLE MENU
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_MENU;

CREATE TABLE MENU(
	SEQ NUMBER(8) PRIMARY KEY,
	NAME VARCHAR2(30) NOT NULL,
	SIZES VARCHAR2(10) NOT NULL,
	SIZET VARCHAR2(10) NOT NULL,
	SIZEG VARCHAR2(10) NOT NULL
);

CREATE SEQUENCE SEQ_MENU
START WITH 1
INCREMENT BY 1;

ALTER TABLE MENU
ADD CONSTRAINT FK_BBS_ID FOREIGN KEY(ID)
REFERENCES MEMBER(ID);
*/
public class CoffeeDto {
	
	private int seq;
	private String name;
	private String sizeS;
	private String sizeT;
	private String sizeG;
	
	public CoffeeDto() {
	}


	


	public CoffeeDto(int seq, String name, String sizeS, String sizeT, String sizeG) {
		super();
		this.seq = seq;
		this.name = name;
		this.sizeS = sizeS;
		this.sizeT = sizeT;
		this.sizeG = sizeG;
	}





	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSizeS() {
		return sizeS;
	}


	public void setSizeS(String sizeS) {
		this.sizeS = sizeS;
	}


	public String getSizeT() {
		return sizeT;
	}


	public void setSizeT(String sizeT) {
		this.sizeT = sizeT;
	}


	public String getSizeG() {
		return sizeG;
	}


	public void setSizeG(String sizeG) {
		this.sizeG = sizeG;
	}

}
