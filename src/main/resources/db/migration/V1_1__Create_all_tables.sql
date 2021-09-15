CREATE SEQUENCE IF NOT EXISTS id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE category
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE category_group
(
    id          BIGINT NOT NULL,
    parent_id   BIGINT,
    category_id BIGINT NOT NULL,
    CONSTRAINT pk_category_group PRIMARY KEY (id)
);

CREATE TABLE constructor_materials
(
    id           BIGINT NOT NULL,
    author       BIGINT,
    updated_by   BIGINT,
    title        VARCHAR(100),
    created_date TIMESTAMP WITHOUT TIME ZONE,
    description  VARCHAR(500),
    address      VARCHAR(100),
    price        DOUBLE PRECISION,
    city_id      BIGINT NOT NULL,
    category_id  BIGINT NOT NULL,
    CONSTRAINT pk_constructor_materials PRIMARY KEY (id)
);

ALTER TABLE category
    ADD CONSTRAINT uc_category_name UNIQUE (name);

ALTER TABLE category_group
    ADD CONSTRAINT FK_CATEGORY_GROUP_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_group
    ADD CONSTRAINT FK_CATEGORY_GROUP_ON_PARENT FOREIGN KEY (parent_id) REFERENCES category (id);

ALTER TABLE constructor_materials
    ADD CONSTRAINT FK_CONSTRUCTOR_MATERIALS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);