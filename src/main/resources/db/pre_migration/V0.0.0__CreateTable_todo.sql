CREATE TABLE todo(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    title VARCHAR(255),
    category_id int,
    detail TEXT,
    status_id int,
    deadline DATE,
    remarks TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY(category_id) REFERENCES todo_category(category_id),
    FOREIGN KEY(status_id) REFERENCES todo_status(status_id)
);

CREATE TABLE todo_category(
    category_id int NOT NULL PRIMARY KEY,
    category VARCHAR(31) NOT NULL
);

CREATE TABLE todo_status(
    status_id int NOT NULL PRIMARY KEY,
    status VARCHAR(31) NOT NULL
);