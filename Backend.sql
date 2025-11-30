DROP DATABASE IF EXISTS projectdb;
CREATE DATABASE projectdb CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE projectdb;

CREATE TABLE users (
id int primary key auto_increment,
username VARCHAR(40) UNIQUE NOT NULL,
email VARCHAR(120) UNIQUE NOT NULL,
password_hash VARCHAR(255) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
INDEX (username)
) ENGINE=InnoDB;

CREATE TABLE profiles (
user_id int primary key,
first_name VARCHAR(60),
last_name VARCHAR(60),
about_me TEXT,
website VARCHAR(255),
linkedin VARCHAR(255),
github  VARCHAR(255),
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
CONSTRAINT fk_profiles_user foreign key (user_id) references users(id) on delete cascade
) ENGINE=InnoDB;

CREATE TABLE notes (
user_id int primary key,
content text,
updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
foreign key (user_id) references users(id) ON DELETE CASCADE
) ENGINE=InnoDB;

INSERT INTO users(username,email,password_hash) VALUES
('sbunning','sbunning@gmail.com','Password123!'),
('agarcia', 'agarcia@gmail.com', 'Password1234!');

INSERT INTO profiles(user_id,first_name,last_name,about_me,website,linkedin,github) VALUES
(1, 'Scott', 'Bunning', 'IT student at NMT. My interests consist of SQL and databases.', 'https://scott.dev',
 'https://linkedin.com/in/scott', 'https://github.com/scott');
 
 INSERT INTO notes(user_id,content) VALUES
 (1, 'This course is CSE3021');