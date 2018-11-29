CREATE DATABASE IF NOT EXISTS currency_db;
USE currency_db;

CREATE TABLE IF NOT EXISTS `currency` (
    abbreviation VARCHAR(3) PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS `rate` (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    from_abbreviation VARCHAR(3) NOT NULL,
    to_abbreviation VARCHAR(3) NOT NULL,
    `value` FLOAT,

    FOREIGN KEY (from_abbreviation) REFERENCES currency(abbreviation),
    FOREIGN KEY (to_abbreviation) REFERENCES currency(abbreviation)
    );
	 
CREATE TABLE IF NOT EXISTS `access` (
	id INTEGER AUTO_INCREMENT PRIMARY KEY,
	rate_id INTEGER NOT NULL,
	
	FOREIGN KEY (rate_id) REFERENCES rate(id)
);

INSERT INTO currency(abbreviation, name) VALUES 
('SEK', 'Svenska kronor'),
('USD', 'Amerikanska dollar'),
('EUR', 'Euro'),
('GBP', 'Brittiska pund')
;

INSERT INTO rate(`from_abbreviation`, `to_abbreviation`, `value`) VALUES
('SEK', 'USD', 0.11),
('SEK', 'EUR', 0.097),
('SEK', 'GBP', 0.086),
('USD', 'SEK', 9.076),
('USD', 'EUR', 0.879),
('USD', 'GBP', 0.783),
('EUR', 'SEK', 10.336),
('EUR', 'USD', 1.139),
('EUR', 'GBP', 0.891),
('GBP', 'SEK', 11.595),
('GBP', 'USD', 1.278),
('GBP', 'EUR', 1.123);
