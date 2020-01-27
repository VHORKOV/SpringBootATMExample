DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Clients;

CREATE TABLE Clients (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  pin INT NOT NULL
);

CREATE TABLE Accounts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  balance int DEFAULT 0,
  client_id  INT NOT NULL,
    foreign key (client_id) references Clients(id)
);

INSERT INTO Clients (pin) VALUES
  (30),
  (35),
  (40);

INSERT INTO Accounts (balance,client_id) VALUES
  (123,1),
  (654,2),
  (967,3);
