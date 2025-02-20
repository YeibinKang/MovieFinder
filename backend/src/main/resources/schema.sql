-- app_user 테이블 생성
CREATE TABLE app_user (
   id SERIAL PRIMARY KEY,
   email VARCHAR(255) UNIQUE NOT NULL,
   password VARCHAR(255) NOT NULL,
   username VARCHAR(50) NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- movie 테이블 생성
CREATE TABLE movie (
   id BIGSERIAL PRIMARY KEY,
   tmdb_id BIGINT UNIQUE NOT NULL,
   title VARCHAR(255) NOT NULL,
   original_title VARCHAR(255),
   overview TEXT,
   poster_path VARCHAR(255),
   release_date DATE,
   vote_average DECIMAL(3,1),
   popularity DECIMAL(10,3),
   runtime INTEGER,
   status VARCHAR(50),
   cached_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- favorite_list 테이블 생성
CREATE TABLE watch_list (
   id SERIAL PRIMARY KEY,
   user_id INT NOT NULL,
   movie_id INT NOT NULL,
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   FOREIGN KEY (user_id) REFERENCES app_user(id) ON DELETE CASCADE,
   FOREIGN KEY (movie_id) REFERENCES movie(id) ON DELETE CASCADE,
   UNIQUE(user_id, movie_id)
);
