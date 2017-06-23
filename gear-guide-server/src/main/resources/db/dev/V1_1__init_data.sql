INSERT INTO Player (id, name, image, description) VALUES
  (1, 'Jimmy Page', 'john-frusciante.jpg', 'Jimmy Page is the mastermind and sonic architect behind Led Zeppelin. After making his name as a session guitarist for some of the ’60s biggest bands, Page took over, took apart and completely rebuilt the tattered remains of the Yardbirds in order to create one of the greatest hard rock bands of all time.'),
  (2, 'Jimi Hendrix', 'john-frusciante.jpg', 'Consistently named the greatest guitar player of all time by the rock ''n'' roll bible Rolling Stone magazine and pretty much every other publication that has ever compiled such a list, Jimi Hendrix combined untouchable virtuosity, an improvisational spirit and poignant soul every time he picked up the instrument.'),
  (3, 'John Mayer', 'john-frusciante.jpg', 'Mayer started his career mainly performing acoustic rock, he began moving towards the blues genre that had originally influenced him as a musician. By 2005, he was collaborating with blues artists such as B. B. King, Buddy Guy, and Eric Clapton. Forming the John Mayer Trio, he released a live album in 2005 called Try!, and his third studio album Continuum in 2006.'),
  (4, 'Eric Clapton', 'john-frusciante.jpg', 'Eric Clapton may have the most impressive résumé in rock ‘n’ roll history, having played in the Yardbirds, John Mayall’s Bluebreakers, Cream, Blind Faith and Derek and the Dominos. He’s also racked up a solo career that spans more than 40 years and includes a pair of No. 1 albums, a No. 1 single and guest spots on records by his famous friends.'),
  (5, 'Slash', 'john-frusciante.jpg', 'Slash (who was born Saul Hudson) made his name as the guitarist in Guns N’ Roses, the band that saved rock ‘n’ roll in the late ’80s. The original group made only a handful of records together, and Slash, along with other members, left by the mid-’90s for a solo career.'),
  (6, 'Keith Richards', 'john-frusciante.jpg', 'As one half of the fabled Glimmer Twins, Keith Richards doesn’t make many solo albums. Still, it could be argued that one of them helped save the Rolling Stones. His gold-selling ‘Talk is Cheap’ LP arrived in 1988 as the Stones were at a low ebb, and sparked Richards’ first-ever solo tour.');

INSERT INTO Guitar (id, manufacturer, model, year, image, description) VALUES
  (1, 'Gibson', 'Les Paul Standard', 1958, 'les-paul-standard.png', 'The Gibson Les Paul is simply one of the most iconic guitars in rock history. Seemingly every guitarist from Jimmy Page and Slash to Neil Young and Bob Marley has made use of the Les Paul.'),
  (2, 'Gibson', 'Les Paul Custom', 1962, 'les-paul-custom.png', 'The Gibson Les Paul Custom is a higher end variation of the Gibson Les Paul guitar. It was developed in 1953 after Gibson had introduced the Les Paul model in 1952.'),
  (3, 'Gibson', 'SG Standard', 1961, 'sg-standard.png', 'The Gibson SG is a solid-body electric guitar model that was introduced in 1961 (as the Gibson Les Paul) by Gibson, and remains in production today with many variations on the initial design available. The SG Standard is Gibson''s best-selling model of all time.'),
  (4, 'Gibson', 'SG Custom', 1964, 'sg-custom.png', 'The Gibson SG Custom is a higher end variation of the Gibson SG guitar.'),
  (5, 'Gibson', 'Flying V', 1965, 'flying-v.png', 'The Gibson Flying V is an electric guitar model first released by Gibson in 1958. The Flying V offered a radical, "futuristic" body design for the time.'),
  (6, 'Fender', 'Standard Telecaster', 1955, 'standard-tele.png', 'The Fender Telecaster is one of the most iconic guitars ever produced. Designed in 1950, the telecaster was the very first commercial solid-body electric guitar made by Fender.'),
  (7, 'Fender', 'Standard Stratocaster', 1967, 'standard-strat.png', 'The Fender Stratocaster is one of the most popular models of electric guitar, used in nearly every genre of music including rock, blues, country, jazz and more. Designed in 1954, the stratocaster was the first guitar to feature three pickups, opening up a new world of pickup combinations for guitarists.');

INSERT INTO Player_Guitars (player_id, guitar_id) VALUES
  (1, 1),
  (1, 6),
  (1, 2),
  (2, 7),
  (2, 6),
  (2, 1),
  (2, 4);

INSERT INTO Amplifier (id, manufacturer, model, year, image, description) VALUES
  (1, 'Marshall', 'JTM45', 1964, 'marshall-jtm45.png', 'The JTM series was a relatively short-lived reissue of the original Marshall amps and featured some non-traditional combination of features.'),
  (2, 'Marshall', '1959', 1965, 'marshall-1959.png', 'The Marshall Super Lead Model 1959 is a guitar amplifier head made by Marshall. One of the famous Marshall Plexis, it was introduced in 1965 and with its associated 4×12" cabinets gave rise to the "Marshall stack".'),
  (3, 'Marshall', '1962', 1965, 'marshall-1962.png', 'The 1962, 2 x 12″ combo was called the ‘Bluesbreaker’ because it was famously used by Eric Clapton with the influential British blues rockers, John Mayall’s Bluesbreakers, in 1966. It was this heady, ‘high in the mix’ sound that made the legend of the 1962.'),
  (4, 'Fender', 'Bassman', 1952, 'fender-bassman.png', 'The Fender Bassman is a bass amplifier introduced by Fender during 1952.[citation needed] Initially intended to amplify bass guitars, the 5B6 Bassman was used by musicians for other instrument amplification, including the electric guitar, harmonica, and pedal steel guitars.'),
  (5, 'Fender', 'Deluxe Reverb', 1972, 'fender-deluxe-reverb.png', 'The Fender 65 DELUXE REVERB Valve Electric Guitar Amplifier Combo,22 Watts, 1X12" Jensen Speaker, Black. Classic looks and sounds from this legendary Vintage Reissue combo, loved by guitarists for its snappy guitar tones.'),
  (6, 'Vox', 'AC30', 1955, 'vox-ac30.png', 'The Vox AC30 is a guitar amplifier manufactured by Vox. It was introduced in 1958 to meet the growing demand for louder amplifiers. Characterised by its "jangly" high-end sound it has become widely recognized by British musicians and others.'),
  (7, 'Marshall', 'JCM800', 1981, 'marshall-jcm800.png', 'The JCM800 series (Model 2210 and others) is a line of guitar amplifiers made by Marshall Amplification. The JCM800 amplifiers became a staple of 1980s hard rock and heavy metal bands.');

INSERT INTO Player_Amplifiers (player_id, amplifier_id) VALUES
  (1, 1),
  (1, 2),
  (1, 6),
  (2, 4),
  (2, 2),
  (4, 3),
  (4, 1),
  (6, 6),
  (6, 4);