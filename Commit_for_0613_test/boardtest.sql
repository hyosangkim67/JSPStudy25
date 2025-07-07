DROP TABLE member CASCADE CONSTRAINTS;
DROP SEQUENCE board_seq;

CREATE SEQUENCE board_seq
INCREMENT BY 1
START WITH 1
NOCACHE
NOCYCLE;

CREATE TABLE member (
    mno      NUMBER(5) NOT NULL,
    bwriter  NVARCHAR2(10) NOT NULL,
    id       NVARCHAR2(10) PRIMARY KEY,
    pw       NVARCHAR2(10) NOT NULL,
    regidate DATE DEFAULT SYSDATE NOT NULL
);

INSERT INTO member (mno, bwriter, id, pw) VALUES (board_seq.NEXTVAL, '사과', 'applin', '1234');
INSERT INTO member (mno, bwriter, id, pw) VALUES (board_seq.NEXTVAL, '딸기', 'berry', '1234');
INSERT INTO member (mno, bwriter, id, pw) VALUES (board_seq.NEXTVAL, '포도', 'grapy', '1234');
INSERT INTO member (mno, bwriter, id, pw) VALUES (board_seq.NEXTVAL, '오렌지', 'orang', '1234');
INSERT INTO member (mno, bwriter, id, pw) VALUES (board_seq.NEXTVAL, '토마토', 'toto', '1234');