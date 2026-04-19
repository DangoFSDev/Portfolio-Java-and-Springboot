CREATE SEQUENCE IF NOT EXISTS "ecos"."products_id_seq" START 1;
CREATE SEQUENCE IF NOT EXISTS "ecos"."users_id_seq" START 1;
CREATE SEQUENCE IF NOT EXISTS "ecos"."orders_id_seq" START 1;

CREATE TABLE IF NOT EXISTS "ecos"."products" (
    id SERIAL PRIMARY KEY,
    product_id VARCHAR(255) NOT NULL UNIQUE,
    product_code VARCHAR(255) NOT NULL UNIQUE,
    product_name VARCHAR(255) NOT NULL,
    product_desc VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    price NUMERIC(10, 2) NOT NULL,
    currency VARCHAR(3) NOT NULL DEFAULT 'PHP',
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modify_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "ecos"."users" (
    id SERIAL PRIMARY KEY,
    user_id NUMERIC NOT NULL UNIQUE,
    user_name VARCHAR(255) NOT NULL UNIQUE,
    nick_name VARCHAR(255) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL DEFAULT 'USER',
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modify_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "ecos"."orders" (
    id SERIAL PRIMARY KEY,
    order_id VARCHAR(255) NOT NULL UNIQUE,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modify_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    product_code VARCHAR(255) NOT NULL REFERENCES "ecos"."products"(product_code),
    quantity NUMERIC NOT NULL,
    user_id NUMERIC NOT NULL REFERENCES "ecos"."users"(user_id)
);

ALTER SEQUENCE "ecos"."products_id_seq" OWNED BY "ecos"."products".id;
ALTER SEQUENCE "ecos"."users_id_seq" OWNED BY "ecos"."users".id;
ALTER SEQUENCE "ecos"."orders_id_seq" OWNED BY "ecos"."orders".id;

CREATE UNIQUE INDEX IF NOT EXISTS idx_products_product_id ON "ecos"."products"(product_id);
CREATE UNIQUE INDEX IF NOT EXISTS idx_products_product_code ON "ecos"."products"(product_code);
CREATE UNIQUE INDEX IF NOT EXISTS idx_users_user_id ON "ecos"."users"(user_id);
CREATE UNIQUE INDEX IF NOT EXISTS idx_users_user_name ON "ecos"."users"(user_name);
CREATE UNIQUE INDEX IF NOT EXISTS idx_orders_order_id ON "ecos"."orders"(order_id);