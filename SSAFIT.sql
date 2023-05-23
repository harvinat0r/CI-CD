-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`exercise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`exercise` (
  `exercise_name` VARCHAR(30) NOT NULL,
  `exercise_part` VARCHAR(10) NOT NULL DEFAULT '등',
  `exercise_search_cnt` INT NOT NULL DEFAULT 0,
  `exercise_like_cnt` INT NOT NULL DEFAULT 0,
  `exercise_desc` VARCHAR(500) NOT NULL,
  `video_id` VARCHAR(45) NULL DEFAULT 'null',
  PRIMARY KEY (`exercise_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`search`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`search` (
  `search_id` INT NOT NULL AUTO_INCREMENT,
  `exercise_name` VARCHAR(30) NOT NULL,
  `search_reg_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`search_id`),
  INDEX `fk_search_exercise1_idx` (`exercise_name` ASC) VISIBLE,
  CONSTRAINT `fk_search_exercise1`
    FOREIGN KEY (`exercise_name`)
    REFERENCES `mydb`.`exercise` (`exercise_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`routine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`routine` (
  `routine_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `exercise_name` VARCHAR(30) NOT NULL,
  `repetition` INT NOT NULL DEFAULT 1,
  `set` INT NOT NULL DEFAULT 1,
  `routine_reg_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`routine_id`),
  INDEX `fk_routine_exercise1_idx` (`exercise_name` ASC) VISIBLE,
  INDEX `fk_routine_user2_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_routine_exercise1`
    FOREIGN KEY (`exercise_name`)
    REFERENCES `mydb`.`exercise` (`exercise_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_routine_user2`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`program`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`program` (
  `program_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `program_difficulty` VARCHAR(5) NOT NULL DEFAULT '초급자',
  `program_title` VARCHAR(45) NOT NULL,
  `program_content` VARCHAR(2000) NOT NULL DEFAULT 'ㅈㄱㄴ',
  `program_view_cnt` INT NOT NULL DEFAULT 0,
  `program_review_cnt` INT NOT NULL DEFAULT 0,
  `program_like_cnt` INT NOT NULL DEFAULT 0,
  `program_unlike_cnt` INT NOT NULL DEFAULT 0,
  `program_reg_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `program_goal` TINYINT NULL,
  `program_video_id` VARCHAR(45) NULL DEFAULT 'null',
  PRIMARY KEY (`program_id`),
  INDEX `fk_program_user2_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_program_user2`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`article` (
  `article_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `article_title` VARCHAR(45) NOT NULL,
  `article_content` VARCHAR(2000) NOT NULL DEFAULT 'ㅈㄱㄴ',
  `article_view_cnt` INT NOT NULL DEFAULT 0,
  `article_review_cnt` INT NOT NULL DEFAULT 0,
  `article_like_cnt` INT NOT NULL DEFAULT 0,
  `article_unlike_cnt` INT NOT NULL DEFAULT 0,
  `article_reg_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `article_property` INT NULL,
  `article_video_id` VARCHAR(45) NULL,
  PRIMARY KEY (`article_id`),
  INDEX `fk_article_user2_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_article_user2`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`save`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`save` (
  `video_id` VARCHAR(45) NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`video_id`, `user_id`),
  INDEX `fk_save_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_save_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `user_id` VARCHAR(20) NOT NULL,
  `user_passward` VARCHAR(20) NOT NULL,
  `user_name` VARCHAR(20) NOT NULL,
  `user_nickname` VARCHAR(20) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `birth` DATE NOT NULL,
  `phone_no` INT NOT NULL,
  `gender` TINYINT NOT NULL DEFAULT 1,
  `squat` INT NOT NULL DEFAULT 0,
  `bench_press` INT NOT NULL DEFAULT 0,
  `dead_lift` INT NOT NULL DEFAULT 0,
  `sbd` INT NOT NULL DEFAULT 0,
  `question_1` VARCHAR(45) NULL,
  `question_2` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`review` (
  `review_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `program_id` INT NULL,
  `parent_id` INT NULL,
  `article_id` INT NULL,
  `review_content` VARCHAR(200) NOT NULL DEFAULT 'ㅈㄱㄴ',
  `review_like_cnt` INT NOT NULL DEFAULT 0,
  `depth` TINYINT NOT NULL DEFAULT 0,
  `review_reg_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`review_id`),
  INDEX `fk_review_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_review_program1_idx` (`program_id` ASC) VISIBLE,
  INDEX `fk_review_review1_idx` (`review_id` ASC) VISIBLE,
  INDEX `fk_review_article1_idx` (`article_id` ASC) VISIBLE,
  CONSTRAINT `fk_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_program1`
    FOREIGN KEY (`program_id`)
    REFERENCES `mydb`.`program` (`program_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_review1`
    FOREIGN KEY (`parent_id`)
    REFERENCES `mydb`.`review` (`review_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_article1`
    FOREIGN KEY (`article_id`)
    REFERENCES `mydb`.`article` (`article_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`like`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`like` (
  `like_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(20) NOT NULL,
  `exercise_name` VARCHAR(30) NULL,
  `program_id` INT NULL,
  `review_id` INT NULL,
  `article_id` INT NULL,
  `like_property` TINYINT NULL,
  PRIMARY KEY (`like_id`),
  INDEX `fk_like_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_like_exercise1_idx` (`exercise_name` ASC) VISIBLE,
  INDEX `fk_like_program1_idx` (`program_id` ASC) VISIBLE,
  INDEX `fk_like_review1_idx` (`review_id` ASC) VISIBLE,
  INDEX `fk_like_article1_idx` (`article_id` ASC) VISIBLE,
  CONSTRAINT `fk_like_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_exercise1`
    FOREIGN KEY (`exercise_name`)
    REFERENCES `mydb`.`exercise` (`exercise_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_program1`
    FOREIGN KEY (`program_id`)
    REFERENCES `mydb`.`program` (`program_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_review1`
    FOREIGN KEY (`review_id`)
    REFERENCES `mydb`.`review` (`review_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_article1`
    FOREIGN KEY (`article_id`)
    REFERENCES `mydb`.`article` (`article_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

desc `article`;
desc `exercise`;
desc `like`;
desc `program`;
desc `review`;
desc `routine`;
desc `save`;
desc `search`;
desc `user`;
show full columns from `user`;
select * from `article`;
select * from `exercise`;
select * from `like`;
select * from `program`;
select * from `review`;
select * from `routine`;
select * from `save`;
select * from `search`;
select * from `user`;

INSERT INTO user
VALUES ("beom", "1234", "김인범", "세상이 밉다", "ssafy@ssafy.com", "1997-02-10", 01093799366, 1, 100, 70, 50, 220, "몰루", "test");

INSERT INTO article (user_id, article_title, article_content, article_property)
VALUES ("beom", "자유게시판", "테스트중", 0);

INSERT INTO `exercise` (`exercise_name`, `exercise_part`, `exercise_desc`, `video_id`)
VALUES("데드리프트", "하체", "데드리프트(deadlift)는 가장 대표적인 웨이트 트레이닝 운동 중 하나로, 바닥에 놓인 바벨을 잡고 팔을 구부리지 않은 자세로 엉덩이 높이까지 들어올리는 식으로 행한다. 복부 근육, 등 근육, 둔부 근육, 다리 근육 등 연관되는 근육이 광범위하여 널리 행해지며, 덤벨을 사용한다거나 한쪽 다리만을 사용하는 등 다른 운동효과를 위한 여러 가지 변형이 있다. 스쿼트, 벤치프레스와 함께, 높은 무게를 들어올리는 것으로 겨루는 스포츠 경기인 파워리프팅(Powerlifting)의 세 종목 중 하나이기도 하다. 벤치프레스와 합친 운동인 데드프레스도 있다.", "EBjYQeeBI-0&t=42s"),
	("랫풀다운", "등", "랫풀다운(pull-down exercise)은 광배근(latissimus dorsi muscle)을 발달시키는 근력운동(strength training exercise)이다. 어깨관절(shoulder joint) 내전(adduction)과 신전(extension)이 결합된 하방회전(downward rotation) 기능과 견갑골(scapula)의 하강(depression)을 수행한다. 케이블 랫풀다운(cable lat pull-down)은 케이블 풀리(cable pulley)를 통하여 핸들을 움직이는 방식으로 수행하는 운동이며, 레버리지 머신(leverage machine)에서 풀다운을 하는 것과는 반대된다.", "2K2WCGstHOY"),
	("벤치 프레스", "가슴", "벤치 프레스(bench press, chest press)는 스쿼트, 데드리프트와 함께 웨이트 트레이닝의 'Big 3'로 불리는 대표적인 근력 운동 중 하나이다. 벤치에 등을 대고 누워서 역기를 가슴 높이까지 내렸다가 굽힌 팔꿈치를 쭉 펴면서 들어 올리는 방식으로 실시한다.", "A2kHURY746E"),
	("스쿼트", "하체", "스쿼트(영어: squat)는 웨이트 트레이닝의 가장 대표적인 운동 중 하나이다. 데드리프트, 벤치 프레스와 함께 웨이트 트레이닝의 'Big 3'로도 불리며, 중량을 겨루는 스포츠인 파워리프팅 중 하나이다. 바벨 또는 덤벨을 들고 무릎 관절을 굽혔다 펴는 행동을 반복함으로써, 하반신의 대퇴사두근과 하퇴삼두근, 대둔근, 중전근 등의 근육을 성장시키는 운동으로, 하체의 근육량 증가에 커다란 효과가 있다. 잘못된 자세 또는 무리한 중량으로 행할 경우 무릎 부상의 위험이 큰 운동이기도 하다. 무릎을 구부릴 때는 무릎이 앞으로 돌출되어 무게중심이 앞으로 쏠리지 않도록 주의해야 하며, 허리를 구부리지 말고 엉덩이를 뒤로 뺀 자세로 시행해야 한다.", "MWjKQGoNW0U"),
	("풀업", "등", "철봉을 손으로 잡고 당겨 턱을 철봉 위까지 끌어 올리는 운동. 맨손 운동의 알파이자 오메가. 도구를 사용하지 않는 칼리스데닉스 운동법에서도 철봉이나 풀업바를 이용한 턱걸이는 반드시 들어갈 정도이며 웨이트나 어떤 운동을 하든 등근육을 발달시키기 위해서는 반드시 들어가는 필수 동작으로 그 중요성과 효율성은 두말할 필요가 없는 그야말로 최고의 맨몸 운동. 후술하겠지만 상완이두근과 등근육 뿐만 아니라 상체근육 전체를 골고루 단련시키는 운동. 요즈음 여러 맨몸운동 사이트에서 괜히 턱걸이를 강조하는 게 아니다. 광배근이 워낙 다른 운동에도 영향력이 상당하다 보니 보디빌딩. 크로스핏 등의 운동 뿐만 아니라 투기 종목 등에서도 정말 일상적으로 실시하는 운동이 바로 턱걸이다.", "9lsqux_WcBo"),
	("티바로우", "등", "티바로우는 등근육의 중간부와 외측근을 발달시키는 운동으로써 거북이 등껍질과 같은 두툼한 등근육을 키울수 있는 운동이고, 잡는 그립에 따라서 자극부위 또한 달라지기 때문에 티바로우 하나만으로 상당수 부위를 자극시킬수 있는 운동이라 할수있다. 비교적 무거운 중량을 컨트롤 할수있는 조건이 뒷받침 되서 등 전체에 강도 높은 자극을 줄 수 있기 때문에 보디빌더들 사이에서도 빠지지 않는 루틴에 속하고, 특히 등 전체적인 근육을 넓혀주는 광배근과 능형근을 자극할수 있고, 승모근 중-상부를 공략하기에 탁월한 운동이라 할수있다.", "DERwMwO1fLE"),
	("펙덱플라이", "가슴", "펙덱플라이는 중간부 가슴의 크기를 키우고 흉근의 데피니션과 스트리에이션을 키우기 위한 운동입니다. 펙덱플라이 머신은 매스를 키우는데 최선의 선택은 아니지만 데피니션을 만들어내는데는 아주 유용한 운동입니다.", "Og9pgOtL-04"),
    ("사이드 레터럴 레이즈", "어깨", "사이드 레터럴 레이즈는 어깨 측면의 디테일을 살려주고 볼륨감을 넣어주는 운동입니다.", "iNgwwI3WBTo"),
    ("오버헤드 프레스", "어깨", "오버헤드 프레스는 역기 운동처럼 바벨을 번쩍 드는 운동입니다. 이 자세를 통해서 어깨를 자극하고 삼두근까지 근육을 키워줄 수 있습니다.", "7q4CKXhkIGE"),
    ("암풀다운", "등", "암(Arm) + 풀다운(Pull down)이라는 용어로 우리의 팔을 끌어 내리는 행위입니다.", "QoAYCFh57_o"),
    ("페이스 풀", "어깨", "케이블을 활용한 후면 어깨를 타겟한 운동으로 얼굴 쪽으로 당기는 운동입니다. 어깨후면 삼각근과 등 상부를 발달시키며, 특히 회전근개 강화에 효과적인 동작입니다.", "v=2ZGmW0k-eUk"),
    ("업라이트 로우", "어깨", "업라이트 로우는 승모근과 삼각근을 주로 사용하는 운동이다. 덤벨, 케이블, 스미스 머신을 사용할 수 있으며 동작에 변형을 줘서 주로 자극되는 근육 부위를 다르게 할 수 있다.", "sRWFEY1M_Jo"),
    ("벤트 오버 레터럴 레이즈", "어깨", "벤트 오버 레터럴 레이즈는 어깨 후면을 발달시킬 수 있는 운동이다.", "n3aX0oJyvWA"),
    ("레그프레스", "하체", "다리를 사용하여 체중이나 저항을 밀어내는 복합 웨이트 트레이닝인데요. 대퇴사두근, 즉 허벅지 앞쪽 근육을 효과적으로 발달시킬 수 있는 운동입니다.", "EV0F_3S7Sks"),
    ("런지", "하체", "런지는 다리를 번갈아 가며 앞으로 나아가는 동작을 수행하여 대퇴사두근, 대둔근, 대퇴이두근을 강화시키는데 효과적입니다.", "9w8d_EL-7e4"),
    ("카프 레이즈", "하체", "카프 레이즈는 종아리 근육을 강화시키는데 사용되는 운동으로, 발뒤꿈치를 들어올리는 운동이다", "QdAtQJMKi0U"),
    ("바벨 컬", "팔", "이두 근육을 주로 타겟으로 하는 기본적인 운동 중 하나입니다. 이 운동은 바벨과 양손 그립을 사용하여 이두를 강화하고 발달시키는 데 효과적입니다.", "Dlg0W_5mq98"),
    ("덤벨 컬", "팔", "이두 근육을 강화하는 데 효과적인 운동입니다. 이 운동은 덤벨을 사용하여 각 손을 독립적으로 움직여 이두를 타겟으로 합니다.", "y3aMzyKqvNM"),
    ("해머 컬", "팔", "이두 근육과 전완 근육을 동시에 강화하는 운동입니다. 이두 근육의 두께와 팔의 강력한 힘을 개발하는 데 효과적입니다.", "n4L2Kvdtg-8"),
    ("덤벨 프레스", "가슴", "가슴과 어깨 근육을 강화하는 운동입니다. 이 운동은 양손에 덤벨을 들고 가슴 근처에서 팔을 펼치는 동작으로 이루어집니다.", "DNNcr4_IskA"),
    ("바벨 로우", "등", "허리를 곧게 펴고 손바닥을 내려다보게 하여 바벨을 잡습니다. 상체를 앞으로 기울이면서 바벨을 허리 쪽으로 당기고 내리면서 등을 수축시킵니다.", "j7Xtlx2S2g"),
    ("덤벨 로우", "등", "좌우 손에 각각 덤벨을 들고 허리를 곧게 펴고 앞으로 기울입니다. 한 손씩 번갈아가며 덤벨을 허리 쪽으로 당기고 등을 수축시킵니다.", "VzpvMaGEiAA"),
    ("시티드 케이블 로우", "등", "시티드 케이블 로우 기계에 앉아 양 손으로 그립을 잡고 등을 수축시키며 손을 가슴 쪽으로 당깁니다.", "ZArSjRpaTV4"),
    ("원암 덤벨 로우", "등", "한 손에 덤벨을 들고 반대쪽 발을 앞으로 내딛고 허리를 곧게 펴고 앞으로 기울입니다. 한 손씩 번갈아가며 덤벨을 허리 쪽으로 당기고 등을 수축시킵니다.", "2i1v1UvsP_w"),
    ("덤벨 플라이", "가슴", "등받이가 있는 벤치에 누워 양 손에 덤벨을 들고 팔을 측면으로 벌리면서 가슴 근육을 수축시키는 운동입니다.", "gmVan01OP9E"),
    ("케이블 크로스오버", "가슴", "케이블 크로스오버 기계를 사용하여 가슴 근육을 타겟으로 하는 운동입니다. 팔을 측면으로 벌리면서 가슴을 가로지르는 동작을 수행합니다.", "zU7KivWmxII"),
    ("푸시업", "가슴", "팔을 어깨 너비로 벌리고 손바닥을 바닥에 대고 상체를 올리고 내리는 운동입니다. 가슴 근육을 타겟으로 합니다.", "8txh_smTqPA"),
    ("크런치", "복근", "등을 바닥에 대고 무릎을 구부리며 상체를 들어올리는 운동입니다. 복근을 수축시키는 중심적인 운동입니다.", "KqnFav4Edvw"),
    ("플랭크", "복근", "팔꿈치와 발끝을 바닥에 대고 몸을 곧게 펴고 유지하는 운동입니다. 복부 근육을 강화하고 전신 균형을 향상시킵니다.", "v54Jtmi2BwU"),
    ("러시안 트위스트", "복근", "등을 바닥에 대고 상체를 약간 뒤로 기울인 상태에서 양 손에 덤벨이나 메디슨볼을 들고 좌우로 허리를 돌리는 운동입니다. 측면 복근을 강화시키고 허리 유연성을 향상시킵니다.", "DMxf2aHLNHA"),
    ("덤벨 숄더 프레스", "어깨", "등받이가 있는 의자에 앉아 양 손에 덤벨을 들어올려 어깨 높이에서 시작하여 팔을 펴서 덤벨을 위로 밀어 올리는 운동입니다. 각 손을 독립적으로 움직여 어깨 근육을 균등하게 발달시킵니다.", "fx8mgLt7FR4"),
    ("프론트 레이즈", "어깨", "서서 양 손에 덤벨을 들고 팔을 펴서 앞으로 들어올리는 운동입니다. 전면 어깨 근육을 타겟으로 합니다.", "u3zQI-PWaOw");