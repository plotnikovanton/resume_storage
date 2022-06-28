CREATE TABLE resume
(
    uuid        TEXT NOT NULL
                CONSTRAINT resume_pk
                PRIMARY KEY,
    full_name   TEXT NOT NULL
);

CREATE TABLE contact
(
    id          SERIAL   NOT NULL
                CONSTRAINT contact_pk
                PRIMARY KEY,
    resume_uuid CHAR(36) NOT NULL REFERENCES resume (uuid) ON DELETE CASCADE,
    type        TEXT     NOT NULL,
    value       TEXT     NOT NULL
);

CREATE UNIQUE INDEX contact_uuid_type_index ON contact (resume_uuid, type);

CREATE TABLE section
(
    id          SERIAL   NOT NULL
                PRIMARY KEY,
    resume_uuid CHAR(36) NOT NULL REFERENCES resume (uuid) ON DELETE CASCADE,
    type        TEXT     NOT NULL,
    content     TEXT     NOT NULL
);

CREATE UNIQUE INDEX section_index ON contact (resume_uuid, type);