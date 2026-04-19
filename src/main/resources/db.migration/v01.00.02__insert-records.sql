INSERT INTO "ecos"."products" (product_id, product_code, product_name, product_desc, is_active, price, currency) VALUES
('P001', 'PCODE001', 'Product 1', 'Product 1 Description', 1, 10.00, 'PHP'),
('P002', 'PCODE002', 'Product 2', 'Product 2 Description', 1, 20.00, 'PHP'),
('P003', 'PCODE003', 'Product 3', 'Product 3 Description', 1, 30.00, 'PHP');

INSERT INTO "ecos"."products" (product_id, product_code, product_name, price) VALUES
('P004', 'PCODE004', 'Product 4', 'Product 4 Description', 1, 40.00, 'PHP'),
('P005', 'PCODE005', 'Product 5', 'Product 5 Description', 1, 50.00, 'PHP'),
('P006', 'PCODE006', 'Product 6', 'Product 6 Description', 1, 60.00, 'PHP');

INSERT INTO "ecos"."users" (user_id, user_name, nick_name, password, role) VALUES
(1001, 'user1', 'User One', '$2a$10$7QJ9X3m5d9k2fZ8G1LqR5eYzW1sR9v8KcM2Xb4JtN6uP0rHqL3a7G', 'USER'),
(1002, 'user2', 'User Two', '$2a$10$9Lm4KpQ2xT7vHc8Jf3R5uOeY1nZs6Wb0DkF4gHj8L2pQ9xT3vC7eS', 'USER'),
(1003, 'user3', 'User Three', '$2a$10$3Zx9WqT6LpK2vH8JcF5R7mN1sYb4Dg0EoPj6Uq2Xr8tV9aC3kH1wL', 'USER');

INSERT INTO "ecos"."users" (user_id, user_name, nick_name, password, role) VALUES
(0000, 'admin1', 'Admin One', '$2a$10$H8kP2mQ9xT4vC7sD1F6gJ3LwR5Zb0N8YpEo2UqVtXr9aKcH3M7nB', 'ADMIN');