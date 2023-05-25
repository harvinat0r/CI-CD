DROP DATABASE IF EXISTS SSAFIT;


CREATE DATABASE SSAFIT;
USE SSAFIT;

CREATE TABLE VIDEO(
	videoid int AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    fitPartName VARCHAR(40) NOT NULL,
    youtubeId VARCHAR(500) NOT NULL,
    channelName VARCHAR(50) NOT NULL,
    USERID VARCHAR(40) NOT NULL,
    viewCnt int NOT NULL DEFAULT 0,
    PRIMARY KEY(videoId)
);

CREATE TABLE REVIEW(
	reviewId int AUTO_INCREMENT,
    videoId int NOT NULL,
    USERID VARCHAR(40) NOT NULL,
    content VARCHAR(500) NOT NULL,
    PRIMARY KEY(reviewId)
);

CREATE TABLE USERS(
	USERID VARCHAR(40) PRIMARY KEY,
    PASSWORD VARCHAR(40) NOT NULL,
    NAME VARCHAR(40) NOT NULL
);

INSERT INTO USERS VALUES("ssafy", "1234", "김싸피");

INSERT INTO VIDEO(TITLE, FITPARTNAME, YOUTUBEID, CHANNELNAME, USERID)
VALUES("전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "전신", "https://www.youtube.com/embed/gMaB-fG4u4g", "ThankyouBUBU", "ssafy"),
("하루 15분! 전신 칼로리 불태우는 다이어트 운동", "전신", "https://www.youtube.com/embed/swRNeYw1JkY", "ThankyouBUBU", "ssafy"),
("상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]","상체","https://www.youtube.com/embed/54tTYO-vU2E","ThankyouBUBU", "ssafy"),
("상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "상체", "https://www.youtube.com/embed/QqqZH3j_vH0", "ThankyouBUBU", "ssafy"),
("하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "하체", "https://www.youtube.com/embed/tzN6ypk6Sps", "김강민", "ssafy"),
("11자복근 복부 최고의 운동 [복근 핵매운맛]", "복부", "https://www.youtube.com/embed/PjGcOP-TQPE", "ThankyouBUBU", "ssafy"),
("(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "복부", "https://www.youtube.com/embed/7TLk7pscICk", "SomiFit", "ssafy");

INSERT INTO REVIEW(videoId, USERID, content)
VALUES("1","ssafy", "살살해주세요"),
("2","SADF", "오운완"),
("3","WERQASFD", "오늘 운동 맛있네요"),
("4","QWER1234", "그만..."),
("5","ASDF1234", "운동 레고"),
("6","ZEOM", "살살해주세요"),
("7","ZZZZ", "만족합니당"),
("5","HAAN", "아아아아아아아"),
("3","RRSRSR", "재밌어요");


SELECT * FROM VIDEO;
SELECT * FROM VIDEO ORDER BY VIEWCNT DESC;
SELECT * FROM USERS;
SELECT * FROM REVIEW;
