CREATE TABLE IF NOT EXISTS Player (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  name VARCHAR(256) NOT NULL,
  description TEXT DEFAULT NULL,
  image VARCHAR(256) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Guitar (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  manufacturer VARCHAR(256) NOT NULL,
  model VARCHAR(256) NOT NULL,
  year INTEGER DEFAULT NULL,
  description TEXT DEFAULT NULL,
  image VARCHAR(256) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Amplifier (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  manufacturer VARCHAR(256) NOT NULL,
  model VARCHAR(256) NOT NULL,
  year INTEGER DEFAULT NULL,
  description TEXT DEFAULT NULL,
  image VARCHAR(256) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Player_Guitars (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  player_id BIGINT(20) NOT NULL,
  guitar_id BIGINT(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_PLAYERGUITARS_PLAYER (player_id),
  CONSTRAINT FK_PLAYERGUITARS_PLAYER FOREIGN KEY (player_id) REFERENCES Player (id),
  KEY FK_PLAYERGUITARS_GUITAR (guitar_id),
  CONSTRAINT FK_PLAYERGUITARS_GUITAR FOREIGN KEY (guitar_id) REFERENCES Guitar (id),
  UNIQUE KEY UK_PLAYERGUITARS (player_id, guitar_id)
);

CREATE TABLE IF NOT EXISTS Player_Amplifiers (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  player_id BIGINT(20) NOT NULL,
  amplifier_id BIGINT(20) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_PLAYER_AMPLIFIERS_PLAYER (player_id),
  CONSTRAINT FK_PLAYER_AMPLIFIERS_PLAYER FOREIGN KEY (player_id) REFERENCES Player (id),
  KEY FK_PLAYER_AMPLIFIERS_GUITAR (amplifier_id),
  CONSTRAINT FK_PLAYER_AMPLIFIERS_AMPLIFIER FOREIGN KEY (amplifier_id) REFERENCES Amplifier (id),
  UNIQUE KEY UK_PLAYER_AMPLIFIER (player_id, amplifier_id)
);