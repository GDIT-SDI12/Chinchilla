-- Drop tables

DROP TABLE IF EXISTS public.posts;
DROP TABLE IF EXISTS public.authorities;
DROP TABLE IF EXISTS public.user;
DROP TABLE IF EXISTS public.users;
DROP TABLE IF EXISTS public.user_details;
DROP TABLE IF EXISTS public.roles;

-- Create tables
-- Create default Spring Security tables schema

CREATE TABLE public.users
(
    id       serial      PRIMARY KEY,
    username varchar(50) UNIQUE NOT NULL,
    password varchar(50) NOT NULL,
    enabled  BOOLEAN     NOT NULL
);

INSERT INTO public.users(username, password, enabled)
VALUES ('john', '{noop}123', true);
INSERT INTO public.users(username, password, enabled)
VALUES ('nina', '{noop}333', true);
INSERT INTO public.users(username, password, enabled)
VALUES ('susan', '{noop}1qaz', true);

CREATE TABLE public.authorities
(
    username  varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,
    PRIMARY KEY (username, authority),
    FOREIGN KEY (username) REFERENCES public.users (username)
);

INSERT INTO public.authorities (username, authority)
VALUES ('john', 'ROLE_MANAGER');
INSERT INTO public.authorities (username, authority)
VALUES ('nina', 'ROLE_USER');
INSERT INTO public.authorities (username, authority)
VALUES ('susan', 'ROLE_ADMIN');
