UPDATE Player SET description = CONCAT(description,' One of the greatest players of all time') WHERE name = 'Eric Clapton';

UPDATE Guitar SET description = SUBSTRING(description, 1, LENGTH(description)-40);

UPDATE Amplifier SET image = 'fender-bassman.jpg' WHERE image = 'fender-bassman.png';