UPDATE Guitar SET pickups = 'Originally released with P-90s but the definitive configuration came into being in 1958 with the first double humbucker model.' WHERE id IN (1, 2);
UPDATE Guitar SET pickups = 'Usually 2 humbuckers but sometimes 3. Some models in the past have used P-90s or mini humbuckers' WHERE id IN (3, 4);
UPDATE Guitar SET pickups = 'Usually 2 humbuckers' WHERE id = 5;
UPDATE Guitar SET pickups = 'Usually 2 single coils but sometimes 3. Certain models will include a humbucker in the bridge position.' WHERE id = 6;
UPDATE Guitar SET pickups = 'Usually 3 single coils. Certain models will include a humbucker in the bridge position, or more rarely in the neck position' WHERE id = 7;

UPDATE Guitar SET scale = 24.75 WHERE id IN (1, 2, 3, 4, 5);
UPDATE Guitar SET scale = 25.00 WHERE id IN (6, 7);

UPDATE Amplifier SET valves = '12AX7s in the preamp section KT66s in the power section' WHERE id IN (1, 2, 3, 7);
UPDATE Amplifier SET valves = '12AX7s in the preamp section 6L6s in the power section' WHERE id IN (4, 5);
UPDATE Amplifier SET valves = '12AX7s in the preamp section EL84s in the power section' WHERE id = 6;