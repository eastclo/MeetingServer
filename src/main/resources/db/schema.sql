CREATE TABLE USERS (
       ID INT NOT NULL AUTO_INCREMENT
     , USER_ID VARCHAR(18) NOT NULL
     , USER_PWD VARCHAR(18) NOT NULL
     , UNIQUE (USER_ID)
     , PRIMARY KEY (ID)
);