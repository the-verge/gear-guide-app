CREATE TABLE IF NOT EXISTS EffectType (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  type VARCHAR(256) NOT NULL,
  description TEXT DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Effect (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  manufacturer_id BIGINT(20) NOT NULL,
  model VARCHAR(256) NOT NULL,
  effect_type_id BIGINT(20) NOT NULL,
  description TEXT DEFAULT NULL,
  image VARCHAR(256) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_EFFECT_MANUFACTURER (manufacturer_id),
  CONSTRAINT FK_EFFECT_MANUFACTURER FOREIGN KEY (manufacturer_id) REFERENCES Manufacturer (id),
  KEY FK_EFFECT_EFFECT_TYPE (effect_type_id),
  CONSTRAINT FK_EFFECT_EFFECT_TYPE FOREIGN KEY (effect_type_id) REFERENCES EffectType (id)
);

ALTER TABLE Guitar ADD manufacturer_id BIGINT(20) NOT NULL;
UPDATE Guitar g INNER JOIN Manufacturer m on g.manufacturer = m.name SET g.manufacturer_id = m.id;
ALTER TABLE Guitar DROP COLUMN manufacturer;

ALTER TABLE Amplifier ADD manufacturer_id BIGINT(20) NOT NULL;
UPDATE Amplifier a INNER JOIN Manufacturer m on a.manufacturer = m.name SET a.manufacturer_id = m.id;
ALTER TABLE Amplifier DROP COLUMN manufacturer;
