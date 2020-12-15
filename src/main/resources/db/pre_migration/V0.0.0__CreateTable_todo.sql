CREATE TABLE todo(
    id VARCHAR(36) NOT NULL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category_id int NOT NULL,
    detail TEXT NOT NULL,
    status_id int NOT NULL,
    deadline DATE NOT NULL,
    remarks TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE todo_category(
    category_id int NOT NULL AUTO INCREMENT PRIMARY KEY,
    category VARCHAR(20) NOT NULL
);

CREATE TABLE todo_status(
    status_id int NOT AUTO INCREMENT NULL PRIMARY KEY,
    status VARCHAR(20) NOT NULL
);