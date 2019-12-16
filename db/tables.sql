
-- Drop table

DROP TABLE IF EXISTS public.roles;

CREATE TABLE public.roles (
	id serial NOT NULL,
	"role" varchar(20) NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (id),
	CONSTRAINT roles_role_key UNIQUE (role)
);

-- Drop table

DROP TABLE IF EXISTS public.user_details;

CREATE TABLE public.user_details (
	id int4 NOT NULL,
	first_name varchar NULL,
	last_name varchar NULL,
	email varchar NULL,
	CONSTRAINT user_details_pkey PRIMARY KEY (id)
);

-- Drop table

DROP TABLE IF EXISTS public."user";

CREATE TABLE public."user" (
	id serial NOT NULL,
	role_id int4 NULL,
	login varchar NULL,
	details int4 NULL,
	active bool NULL,
	CONSTRAINT user_login_key UNIQUE (login),
	CONSTRAINT user_pkey PRIMARY KEY (id),
	CONSTRAINT user_details_fkey FOREIGN KEY (details) REFERENCES user_details(id),
	CONSTRAINT user_role_fkey FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Drop table

DROP TABLE IF EXISTS public.posts;

CREATE TABLE public.posts (
	id bigserial NOT NULL,
	title varchar NOT NULL,
	author int4 NOT NULL,
	active bool NULL,
	CONSTRAINT posts_pkey PRIMARY KEY (id),
	CONSTRAINT posts_author_fkey FOREIGN KEY (author) REFERENCES "user"(id)
);
