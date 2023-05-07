-- Create a few movies
INSERT INTO movie (imdb_id, title, release_year, description) VALUES ('tt0120737', 'The Lord of the Rings: The Fellowship of the Ring', 2001, 'A meek hobbit of the Shire and eight companions set out on a journey to Mount Doom to destroy the One Ring and the dark lord Sauron.');

INSERT INTO movie (imdb_id, title, release_year, description) VALUES ('tt0068646', 'The Godfather', 1972, 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.');

INSERT INTO movie (imdb_id, title, release_year, description) VALUES ('tt0468569', 'The Dark Knight', 2008, 'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.');

-- Create a few actors
INSERT INTO actor (first_name, last_name, date_of_birth) VALUES ('Elijah', 'Wood', '1981-01-28');

INSERT INTO actor (first_name, last_name, date_of_birth) VALUES ('Ian', 'McKellen', '1939-05-25');

INSERT INTO actor (first_name, last_name, date_of_birth) VALUES ('Marlon', 'Brando', '1924-04-03');

INSERT INTO actor (first_name, last_name, date_of_birth) VALUES ('Al', 'Pacino', '1940-04-25');

INSERT INTO actor (first_name, last_name, date_of_birth) VALUES ('Christian', 'Bale', '1974-01-30');

-- Add actors to movies
INSERT INTO movie_actor (imdb_id, id) VALUES ('tt0120737', 1);

INSERT INTO movie_actor (imdb_id, id) VALUES ('tt0120737', 2);

INSERT INTO movie_actor (imdb_id, id) VALUES ('tt0068646', 3);

INSERT INTO movie_actor (imdb_id, id) VALUES ('tt0068646', 4);

INSERT INTO movie_actor (imdb_id, id) VALUES ('tt0468569', 5);