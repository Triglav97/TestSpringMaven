DROP TABLE IF EXISTS phones;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS phonesBook;
DROP SEQUENCE IF EXISTS phones_id_seq;
DROP SEQUENCE IF EXISTS clients_id_seq;
DROP SEQUENCE IF EXISTS phonesBook_id_seq;

CREATE TABLE IF NOT EXISTS clients
(
    id          BIGINT NOT NULL,
    client      VARCHAR(255) NOT NULL,
    CONSTRAINT pk_clients PRIMARY KEY (id)
);
CREATE SEQUENCE clients_id_seq START WITH 5 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS phones
(
    id          BIGINT NOT NULL,
    client_id   BIGINT NOT NULL,
    phone       BIGINT NOT NULL,
    CONSTRAINT pk_phones PRIMARY KEY (id),
    CONSTRAINT fk_clients FOREIGN KEY (client_id) REFERENCES clients (id)
);
CREATE SEQUENCE phones_id_seq START WITH 5 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS phonesBook
(
    id          BIGINT NOT NULL,
    client_id   BIGINT NOT NULL,
    phone_id    BIGINT NOT NULL,
    CONSTRAINT pk_phonesBook PRIMARY KEY (id),
    CONSTRAINT fk_clients FOREIGN KEY (client_id) REFERENCES clients (id),
    CONSTRAINT fk_phones FOREIGN KEY (phone_id) REFERENCES phones (id)
);
CREATE SEQUENCE phonesBook_id_seq START WITH 10 INCREMENT BY 1;