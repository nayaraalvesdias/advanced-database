CREATE TABLE IF NOT EXISTS stores
(
    id         uuid PRIMARY KEY,
    name       varchar(255),
    is_active  boolean   not null,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now()
);

CREATE TABLE IF NOT EXISTS products
(
    id          uuid PRIMARY KEY,
    store_id    uuid REFERENCES stores (id),
    name        varchar(255)   not null,
    price       decimal(10, 2) not null,
    quantity    integer        not null,
    category    varchar(255)   not null,
    brand       varchar(255)   not null,
    description varchar(255)   not null,
    rating      decimal(10, 2),
    volume      integer,
    size        varchar(255),
    created_at  timestamp      not null default now(),
    updated_at  timestamp      not null default now()
);