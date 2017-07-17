UPDATE Player SET image = 'eric-clapton.png' WHERE name = 'Eric Clapton';
UPDATE Player SET image = 'slash.jpg' WHERE name = 'Slash';
UPDATE Player SET image = 'jimi-hendrix.jpg' WHERE name = 'Jimi Hendrix';
UPDATE Player SET image = 'jimmy-page.jpg' WHERE name = 'Jimmy Page';
UPDATE Player SET image = 'john-mayer.jpg' WHERE name = 'John Mayer';
UPDATE Player SET image = 'keith-richards.jpg' WHERE name = 'Keith Richards';

UPDATE Guitar SET image = 'les-paul-custom.jpg' WHERE model = 'Les Paul Custom';
UPDATE Guitar SET image = 'sg-standard.jpg' WHERE model = 'SG Standard';
UPDATE Guitar SET image = 'sg-custom.jpg' WHERE model = 'SG Custom';
UPDATE Guitar SET image = 'flying-v.jpg' WHERE model = 'Flying V';
UPDATE Guitar SET image = 'standard-strat.jpg' WHERE model = 'Standard Stratocaster';

UPDATE Guitar SET description=CONCAT(description,' One of the greatest players of all time');
