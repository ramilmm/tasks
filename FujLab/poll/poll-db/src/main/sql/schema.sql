CREATE TABLE POLL(
ID BIGINT CONSTRAINT  PK_POLL PRIMARY KEY,
TITLE VARCHAR(512) NOT NULL,
DESCRIPTION VARCHAR (1024),
)
CREATE TABLE POLL_CHOICE(
ID BIGINT CONSTRAINT PK_POLL_CHOICE PRIMARY KEY,
CHOICE_TEXT VARCHAR(512) NOT NULL,
VOTES INTEGER  NOT NULL,
POLL_ID BIGINT NOT NULL ,

CONSTRAINT  FK_POLL FOREIGN  KEY (POLL_ID) REFERENCES POLL(ID)
 UNIQUE (POLL_ID,CHOICE_TEXT)
)