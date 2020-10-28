DROP TABLE IF EXISTS billionaires;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);

INSERT INTO users (name, password) VALUES
  ('Tryggvi', 'pass1'),
  ('Johannes', 'pass2'),
  ('Valur', 'pass3');