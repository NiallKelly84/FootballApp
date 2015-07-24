CREATE TABLE IF NOT EXISTS results
( id BIGINT(10) NOT NULL AUTO_INCREMENT,
  match_date VARCHAR(25) NOT NULL,
  teamA VARCHAR(25) NOT NULL,
  teamB VARCHAR(25) NOT NULL,
  half_time VARCHAR(25) NOT NULL,
  full_time VARCHAR(25) NOT NULL,
  match_winner VARCHAR(25) NOT NULL,
  PRIMARY KEY (id)
);