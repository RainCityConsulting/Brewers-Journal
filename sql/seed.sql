INSERT INTO grains (name, creation_user_id, last_updated_user_id)
VALUES
('Pale 2-Row', 1, 1),
('Crystal 20', 1, 1),
('Crystal 40', 1, 1),
('Crystal 60', 1, 1),
('Crystal 120', 1, 1),
('Biscuit', 1, 1),
('Aromatic', 1, 1),
('Roasted Barley', 1, 1),
('Black Patent', 1, 1),
('Chocolate', 1, 1);

INSERT INTO hops (name, creation_user_id, last_updated_user_id)
VALUES
('Crystal', 1, 1),
('Chinook', 1, 1),
('Northern Brewer', 1, 1),
('Fuggle', 1, 1),
('East Kent Goldings', 1, 1),
('Cluster', 1, 1),
('Willamette', 1, 1),
('Magnum', 1, 1),
('Green Bullet', 1, 1);

INSERT INTO manufacturers (name, creation_user_id, last_updated_user_id)
VALUES
('Wyeast', 1, 1), ('Safale', 1, 1), ('White Labs', 1, 1);

INSERT INTO yeast (name, manufacturer_id, creation_user_id, last_updated_user_id)
VALUES
('American Ale 1056', 1, 1, 1),
('British Ale 1098', 1, 1, 1),
('London Ale 1028', 1, 1, 1),
('Irish Ale 1084', 1, 1, 1),
('US-05', 2, 1, 1);
