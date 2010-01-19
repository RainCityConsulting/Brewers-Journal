UPDATE gravity_reading_types
SET name = 'Sparge BK',
description = 'Sparge - taken from the boil kettle'
WHERE name = 'Sparge';

INSERT INTO gravity_reading_types
(name, description, creation_user_id, last_updated_user_id)
VALUES ('Sparge Hose', 'Sparge - taken from the hose connected to the mash tun', 1, 1);
