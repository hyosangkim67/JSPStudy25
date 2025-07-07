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

INSERT INTO member (mno, bwriter, id, pw) VALUES (board_seq.NEXTVAL, '���', 'applin', '1234');
INSERT INTO member (mno, bwriter, id, pw) VALUES (board_seq.NEXTVAL, '����', 'berry', '1234');
INSERT INTO member (mno, bwriter, id, pw) VALUES (board_seq.NEXTVAL, '����', 'grapy', '1234');
INSERT INTO member (mno, bwriter, id, pw) VALUES (board_seq.NEXTVAL, '������', 'orang', '1234');
INSERT INTO member (mno, bwriter, id, pw) VALUES (board_seq.NEXTVAL, '�丶��', 'toto', '1234');