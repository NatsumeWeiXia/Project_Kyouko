
DROP TABLE IF EXISTS "public"."t_wx_kyouko_chat_data";

CREATE sequence seq_kyouko_chat_data increment by 1 minvalue 1 no maxvalue start with 1;

CREATE TABLE "public"."t_wx_kyouko_chat_data" (
    "id" int8 NOT NULL DEFAULT nextval('seq_kyouko_chat_data'::regclass),
    "cd_user_id" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
    "cd_user_name" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
    "cd_content" text COLLATE "pg_catalog"."default",
    "cd_group_id" varchar(16) COLLATE "pg_catalog"."default",
    "cd_group_name" varchar(60) COLLATE "pg_catalog"."default",
    "cd_file_type" int4,
    "cd_file_id" varchar(36) COLLATE "pg_catalog"."default",
    "cd_insert_time" TIMESTAMP NOT NULL DEFAULT TIMEZONE('UTC-8'::TEXT, NOW()::TIMESTAMP(0) WITHOUT TIME ZONE),
    "cd_chat_time" TIMESTAMP NOT NULL,
    CONSTRAINT t_wx_kyouko_chat_data_pkey PRIMARY KEY (id)
);