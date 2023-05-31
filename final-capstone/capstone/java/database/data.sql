DROP TABLE IF EXISTS portfolio, user_game, game, users CASCADE;

CREATE TABLE users (
    user_id serial PRIMARY KEY,
    username varchar(50) UNIQUE NOT NULL,
    password_hash varchar(200) NOT NULL,
    role varchar(50) NOT NULL
);

CREATE TABLE game (
    game_id serial PRIMARY KEY,
    game_name varchar(50) NOT NULL,
    organizer_id int NOT NULL,
    end_date date NOT NULL,
    CONSTRAINT FK_game_organizer FOREIGN KEY (organizer_id) REFERENCES users (user_id)
);

CREATE TABLE user_game (
    game_id int NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT PK_user_game PRIMARY KEY (game_id, user_id),
    CONSTRAINT FK_user_game_game FOREIGN KEY (game_id) REFERENCES game (game_id),
    CONSTRAINT FK_user_game_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

-- portfolio table is like an account table per game, per user
CREATE TABLE portfolio (
    portfolio_id serial PRIMARY KEY,
    game_id int NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT FK_portfolio_game FOREIGN KEY (game_id) REFERENCES game (game_id),
    CONSTRAINT FK_portfolio_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);

BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO game (game_name, organizer_id, end_date) VALUES ('test game', 1, '2023-12-01');

INSERT INTO user_game (game_id, user_id) VALUES (1, 1);

INSERT INTO portfolio (game_id, user_id) VALUES (1, 1);

COMMIT TRANSACTION;