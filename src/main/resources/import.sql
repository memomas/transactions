INSERT INTO users (name, last_name) VALUES ('Guillermo', 'Mascote');
INSERT INTO users (name, last_name) VALUES ('Adrian', 'Moreno');
INSERT INTO users (name, last_name) VALUES ('Roman', 'Soto');
INSERT INTO users (name, last_name) VALUES ('Andres', 'Rodriguez');
INSERT INTO users (name, last_name) VALUES ('Ricardo', 'Calderon');

INSERT INTO transactions (transaction_id, amount, description, create_at, user_id) VALUES ('aac22bb21bb962f5c3fc71ef28ad95e0', 60.50, 'test transaction', '2021-01-07', 1);
INSERT INTO transactions (transaction_id, amount, description, create_at, user_id) VALUES ('dfgg55yykshgdn31sd4nhgsj2340ikla', 80.00, 'test transaction2', '2021-01-08', 1);
INSERT INTO transactions (transaction_id, amount, description, create_at, user_id) VALUES ('a704812cc1df5826d714e77edd241212', 3.14, 'tacos el marrano', '2021-02-10', 1);

INSERT INTO transactions (transaction_id, amount, description, create_at, user_id) VALUES ('bee5a0dacd0c1fe6c46f99b8346de12a', 160.50, 'tacos infierno', '2021-02-11', 2);
INSERT INTO transactions (transaction_id, amount, description, create_at, user_id) VALUES ('8729a05c96b8a091b3e2c690a36842aa', 70.00, 'hamburguesas puerkas', '2021-03-09', 2);

INSERT INTO transactions (transaction_id, amount, description, create_at, user_id) VALUES ('b272afeb763ee69dacf12f7de9701d6d', 50.50, 'tacos bastardos', '2021-03-10', 3);
