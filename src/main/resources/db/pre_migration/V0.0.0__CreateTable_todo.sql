CREATE TABLE todo(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    title VARCHAR(255),
    categoryId int,
    detail VARCHAR(255),
    statusId int,
    deadline DATE
    remarks VARCHAR(255),
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY(categoryId) REFERENCES todoCategory(categoryId),
    FOREIGN KEY(statusId) REFERENCES todoStatus(statusId),
);

CREATE TABLE todoCategory(
    categoryId int NOT NULL PRIMARY KEY,
    category VARCHAR(255) NOT NULL
);

CREATE TABLE todoStatus(
    statusId int NOT NULL PRIMARY KEY,
    status VARCHAR(255) NOT NULL
);