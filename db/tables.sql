-- Drop tables

DROP TABLE IF EXISTS public.posts;
DROP TABLE IF EXISTS public."user";
DROP TABLE IF EXISTS public.users;
DROP TABLE IF EXISTS public.user_details;
DROP TABLE IF EXISTS public.roles;

-- Create tables

CREATE TABLE public.roles
(
    id     serial      NOT NULL,
    "role" varchar(20) NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (id),
    CONSTRAINT roles_role_key UNIQUE (role)
);

CREATE TABLE public.user_details
(
    id         bigserial NOT NULL,
    first_name varchar   NULL,
    last_name  varchar   NULL,
    email      varchar   NULL,
    CONSTRAINT user_details_pkey PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id         bigserial NOT NULL,
    role_id    int4      NOT NULL,
    login      varchar   NOT NULL,
    details_id int4      NULL,
    active     bool      NOT NULL DEFAULT TRUE,
    CONSTRAINT user_login_key UNIQUE (login),
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT user_details_fkey FOREIGN KEY (details_id) REFERENCES user_details (id),
    CONSTRAINT user_role_fkey FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE public.posts
(
    id     bigserial NOT NULL,
    title  varchar   NOT NULL,
    author int4      NOT NULL,
    active bool      NOT NULL DEFAULT TRUE,
    CONSTRAINT posts_pkey PRIMARY KEY (id),
    CONSTRAINT posts_author_fkey FOREIGN KEY (author) REFERENCES users (id)
);
