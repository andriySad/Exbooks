CREATE TABLE "user"
(
"id" SERIAL NOT NULL,
"email" VARCHAR(512) NOT NULL,
"phone" VARCHAR(14) NOT NULL,
"password" VARCHAR(50) NOT NULL,
"first_name" VARCHAR(255) NOT NULL,
"sur_name" VARCHAR(255) NOT NULL,
"is_active" BOOLEAN NOT NULL,
CONSTRAINT pk_user_id PRIMARY KEY("id"),
CONSTRAINT uk_email UNIQUE ("email")
)