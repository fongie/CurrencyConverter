CREATE DATABASE IF NOT EXISTS currency_db;
USE currency_db;

DROP TABLE IF EXISTS `currency`;
CREATE TABLE IF NOT EXISTS `currency` (
    abbreviation VARCHAR(3) PRIMARY KEY,
    name VARCHAR(30)
);

DROP TABLE IF EXISTS `rate`;
CREATE TABLE IF NOT EXISTS `rate` (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    `from` VARCHAR(3) NOT NULL,
    `to` VARCHAR(3) NOT NULL,
    value FLOAT,

    FOREIGN KEY (`from`) REFERENCES currency(abbreviation),
    FOREIGN KEY (`to`) REFERENCES currency(abbreviation)
    );

INSERT INTO currency(abbreviation, name) VALUES 
('SEK', 'Svenska kronor'),
('USD', 'Amerikanska dollar'),
('EUR', 'Euro'),
('GBP', 'Brittiska pund')
;

INSERT INTO rate(`from`, `to`, value) VALUES
('SEK', 'USD', 0.11),
('SEK', 'EUR', 0.097),
('SEK', 'GBP', 0.086),
('USD', 'SEK', 9.076),
('USD', 'EUR', 0.879),
('USD', 'GBP', 0.783),
('GBP', 'SEK', 11.595),
('GBP', 'USD', 1.278),
('GBP', 'EUR', 1.123);
