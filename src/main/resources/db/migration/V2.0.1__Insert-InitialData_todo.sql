INSERT
    INTO todo(
        id,
        title,
        category_id,
        detail,
        status_id,
        deadline,
        remarks
    )
    VALUES(
        'dummy',
        'dummy',
        0,
        'dummy',
        0,
        CURRENT_DATE,
        'dummy'
    )
;

INSERT
    INTO
        todo_category
    VALUES
        (1,"habit"),
        (2,"emergency"),
        (3,"normal")
;

INSERT
    INTO
        todo_status
    VALUES
        (1,"new"),
        (2,"in_progress"),
        (3,"completed"),
        (4,"cancelled")
;