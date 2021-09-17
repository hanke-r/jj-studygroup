-- Table: public.Member

-- DROP TABLE public."Member";

CREATE TABLE public."Member"
(
    mno bigint NOT NULL,
    id character(50) COLLATE pg_catalog."default" NOT NULL,
    pw character(200) COLLATE pg_catalog."default" NOT NULL,
    email character(150) COLLATE pg_catalog."default" NOT NULL,
    authority character(50) COLLATE pg_catalog."default",
    sex "char",
    regdate date,
    name character(20) COLLATE pg_catalog."default",
    CONSTRAINT "Member_pkey" PRIMARY KEY (mno)
)

    TABLESPACE pg_default;
-- OWNER 는 각자 계정으로 변경
ALTER TABLE public."Member"
    OWNER to hanker;

COMMENT ON TABLE public."Member"
    IS '회원 테이블';