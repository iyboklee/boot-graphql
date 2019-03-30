DROP TABLE IF EXISTS parts CASCADE;
DROP TABLE IF EXISTS members CASCADE;

CREATE TABLE parts (
  seq BIGINT NOT NULL,
  name VARCHAR(50) NOT NULL,
  headquarters VARCHAR(50) NOT NULL,
  PRIMARY KEY (seq)
);

INSERT INTO parts VALUES (1, 'Big data', 'CTO');
INSERT INTO parts VALUES (2, 'Channel', 'CRM');

CREATE TABLE members (
  seq BIGINT NOT NULL,
  name varchar(50) NOT NULL,
  work_group varchar(50) NOT NULL,
  part_seq BIGINT NOT NULL,
  PRIMARY KEY (seq)
);

INSERT INTO members VALUES (1, 'bk.lee', 'SW', 1);
INSERT INTO members VALUES (2, 'jay.ko', 'SW', 1);
INSERT INTO members VALUES (3, 'leo.han', 'SW', 1);
INSERT INTO members VALUES (4, 'murry.jeong', 'SW', 1);