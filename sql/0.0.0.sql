/*
 * All times are in milliseconds
 * All temperatures are in celcius
 * All weights are in grams
 */

CREATE TABLE users (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(24) NOT NULL,
  mail VARCHAR(255) NOT NULL,
  enc_password CHAR(40) NOT NULL,
  salt CHAR(40) NOT NULL,
  auth_token VARCHAR(16) NULL,
  is_authenticated TINYINT(1) NOT NULL,
  creation_date DATETIME NOT NULL DEFAULT 0,
  creation_user_id INTEGER UNSIGNED NOT NULL,
  last_updated_date DATETIME NOT NULL DEFAULT 0,
  last_updated_user_id INTEGER UNSIGNED NOT NULL,
  UNIQUE KEY (mail),
  UNIQUE KEY (name)
) ENGINE = InnoDB;

DELIMITER ;;
CREATE TRIGGER users_bi_trig BEFORE INSERT ON users FOR EACH ROW BEGIN
SET NEW.creation_date = NOW();
SET NEW.last_updated_date = NOW();
END ;;

CREATE TRIGGER users_bu_trig BEFORE UPDATE ON users FOR EACH ROW BEGIN
SET NEW.last_updated_date = NOW();
END ;;
DELIMITER ;

INSERT INTO users
(name, mail, enc_password, salt, is_authenticated, creation_user_id, last_updated_user_id)
VALUES ('root', 'ian@raincityconsulting.com', SHA1(CONCAT('abc123--', SHA1('test'))), 'abc123', 1, 1, 1);

ALTER TABLE users
ADD FOREIGN KEY (creation_user_id) REFERENCES users (id),
ADD FOREIGN KEY (last_updated_user_id) REFERENCES users (id);

CREATE TABLE user_roles (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(24) NOT NULL,
  creation_date DATETIME NOT NULL DEFAULT 0,
  creation_user_id INTEGER UNSIGNED NOT NULL,
  last_updated_date DATETIME NOT NULL DEFAULT 0,
  last_updated_user_id INTEGER UNSIGNED NOT NULL,
  FOREIGN KEY (creation_user_id) REFERENCES users (id),
  FOREIGN KEY (last_updated_user_id) REFERENCES users (id),
  UNIQUE KEY (name)
) ENGINE = InnoDB;

DELIMITER ;;
CREATE TRIGGER user_roles_bi_trig BEFORE INSERT ON user_roles FOR EACH ROW BEGIN
SET NEW.creation_date = NOW();
SET NEW.last_updated_date = NOW();
END ;;

CREATE TRIGGER user_roles_bu_trig BEFORE UPDATE ON user_roles FOR EACH ROW BEGIN
SET NEW.last_updated_date = NOW();
END ;;
DELIMITER ;

INSERT INTO user_roles (name, creation_user_id, last_updated_user_id) VALUES ('Admin', 1, 1);
SET @admin_user_role_id = LAST_INSERT_ID();

CREATE TABLE users_roles (
  user_id INTEGER UNSIGNED NOT NULL,
  user_role_id INTEGER UNSIGNED NOT NULL,
  creation_date DATETIME NOT NULL DEFAULT 0,
  creation_user_id INTEGER UNSIGNED NOT NULL,
  last_updated_date DATETIME NOT NULL DEFAULT 0,
  last_updated_user_id INTEGER UNSIGNED NOT NULL,
  FOREIGN KEY (creation_user_id) REFERENCES users (id),
  FOREIGN KEY (last_updated_user_id) REFERENCES users (id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (user_role_id) REFERENCES user_roles (id),
  UNIQUE KEY (user_id, user_role_id)
) ENGINE = InnoDB;

DELIMITER ;;
CREATE TRIGGER users_roles_bi_trig BEFORE INSERT ON users_roles FOR EACH ROW BEGIN
SET NEW.creation_date = NOW();
SET NEW.last_updated_date = NOW();
END ;;

CREATE TRIGGER users_roles_bu_trig BEFORE UPDATE ON users_roles FOR EACH ROW BEGIN
SET NEW.last_updated_date = NOW();
END ;;
DELIMITER ;

INSERT INTO users_roles (user_id, user_role_id, creation_user_id, last_updated_user_id)
VALUES (1, @admin_user_role_id, 1, 1);

CREATE TABLE recipes (
  id INTEGER UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  creation_date DATETIME NOT NULL DEFAULT 0,
  creation_user_id INTEGER UNSIGNED NOT NULL,
  last_updated_date DATETIME NOT NULL DEFAULT 0,
  last_updated_user_id INTEGER UNSIGNED NOT NULL,
  FOREIGN KEY (creation_user_id) REFERENCES users (id),
  FOREIGN KEY (last_updated_user_id) REFERENCES users (id),
  UNIQUE KEY (name)
) ENGINE = InnoDB;

DELIMITER ;;
CREATE TRIGGER recipes_bi_trig BEFORE INSERT ON recipes FOR EACH ROW BEGIN
SET NEW.creation_date = NOW();
SET NEW.last_updated_date = NOW();
END ;;

CREATE TRIGGER recipes_bu_trig BEFORE UPDATE ON recipes FOR EACH ROW BEGIN
SET NEW.last_updated_date = NOW();
END ;;
DELIMITER ;

CREATE TABLE mash_step_types (
  id INTEGER UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(16) NOT NULL,
  description VARCHAR(64) NOT NULL,
  creation_date DATETIME NOT NULL DEFAULT 0,
  creation_user_id INTEGER UNSIGNED NOT NULL,
  last_updated_date DATETIME NOT NULL DEFAULT 0,
  last_updated_user_id INTEGER UNSIGNED NOT NULL,
  FOREIGN KEY (creation_user_id) REFERENCES users (id),
  FOREIGN KEY (last_updated_user_id) REFERENCES users (id),
  UNIQUE KEY (name)
) ENGINE = InnoDB;

DELIMITER ;;
CREATE TRIGGER mash_step_types_bi_trig BEFORE INSERT ON mash_step_types FOR EACH ROW BEGIN
SET NEW.creation_date = NOW();
SET NEW.last_updated_date = NOW();
END ;;

CREATE TRIGGER mash_step_types_bu_trig BEFORE UPDATE ON mash_step_types FOR EACH ROW BEGIN
SET NEW.last_updated_date = NOW();
END ;;
DELIMITER ;

INSERT INTO mash_step_types
(name, description, creation_user_id, last_updated_user_id)
VALUES ('strike', 'Strike', 1, 1), ('rest', 'Rest', 1, 1), ('step', 'Step Up/Down', 1, 1), ('mash_out', 'Mash Out', 1, 1);

/*
CREATE TABLE recipe_mash_steps (
  id INTEGER UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  recipe_id INTEGER UNSIGNED NOT NULL,
  ordinal INTEGER UNSIGNED NOT NULL,
  mash_step_type_id INTEGER UNSIGNED NOT NULL,
  length_of_time INTEGER UNSIGNED NULL,
  start_temp FLOAT(5, 2) UNSIGNED NULL,
  end_temp FLOAT(5, 2) UNSIGNED NULL,
  FOREIGN KEY (recipe_id) REFERENCES recipies (id)
  UNIQUE KEY (recipe_id, ordinal)
) ENGINE = InnoDB;
*/

CREATE TABLE manufacturers (
  id INTEGER UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  creation_date DATETIME NOT NULL DEFAULT 0,
  creation_user_id INTEGER UNSIGNED NOT NULL,
  last_updated_date DATETIME NOT NULL DEFAULT 0,
  last_updated_user_id INTEGER UNSIGNED NOT NULL,
  FOREIGN KEY (creation_user_id) REFERENCES users (id),
  FOREIGN KEY (last_updated_user_id) REFERENCES users (id),
  UNIQUE KEY (name)
) ENGINE = InnoDB;

CREATE TABLE grains (
  id INTEGER UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  manufacturer_id INTEGER UNSIGNED NULL,
  user_id INTEGER UNSIGNED NULL,
  creation_date DATETIME NOT NULL DEFAULT 0,
  creation_user_id INTEGER UNSIGNED NOT NULL,
  last_updated_date DATETIME NOT NULL DEFAULT 0,
  last_updated_user_id INTEGER UNSIGNED NOT NULL,
  FOREIGN KEY (creation_user_id) REFERENCES users (id),
  FOREIGN KEY (last_updated_user_id) REFERENCES users (id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id),
  UNIQUE KEY (name)
) ENGINE = InnoDB;

CREATE TABLE hops (
  id INTEGER UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  manufacturer_id INTEGER UNSIGNED NULL,
  user_id INTEGER UNSIGNED NULL,
  creation_date DATETIME NOT NULL DEFAULT 0,
  creation_user_id INTEGER UNSIGNED NOT NULL,
  last_updated_date DATETIME NOT NULL DEFAULT 0,
  last_updated_user_id INTEGER UNSIGNED NOT NULL,
  FOREIGN KEY (creation_user_id) REFERENCES users (id),
  FOREIGN KEY (last_updated_user_id) REFERENCES users (id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id),
  UNIQUE KEY (name)
) ENGINE = InnoDB;

CREATE TABLE adjuncts (
  id INTEGER UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  manufacturer_id INTEGER UNSIGNED NULL,
  user_id INTEGER UNSIGNED NULL,
  creation_date DATETIME NOT NULL DEFAULT 0,
  creation_user_id INTEGER UNSIGNED NOT NULL,
  last_updated_date DATETIME NOT NULL DEFAULT 0,
  last_updated_user_id INTEGER UNSIGNED NOT NULL,
  FOREIGN KEY (creation_user_id) REFERENCES users (id),
  FOREIGN KEY (last_updated_user_id) REFERENCES users (id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id),
  UNIQUE KEY (name)
) ENGINE = InnoDB;

CREATE TABLE yeast (
  id INTEGER UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  manufacturer_id INTEGER UNSIGNED NULL,
  user_id INTEGER UNSIGNED NULL,
  creation_date DATETIME NOT NULL DEFAULT 0,
  creation_user_id INTEGER UNSIGNED NOT NULL,
  last_updated_date DATETIME NOT NULL DEFAULT 0,
  last_updated_user_id INTEGER UNSIGNED NOT NULL,
  FOREIGN KEY (creation_user_id) REFERENCES users (id),
  FOREIGN KEY (last_updated_user_id) REFERENCES users (id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id),
  UNIQUE KEY (name)
) ENGINE = InnoDB;

DELIMITER ;;
CREATE TRIGGER manufacturers_bi_trig BEFORE INSERT ON manufacturers FOR EACH ROW BEGIN
SET NEW.creation_date = NOW();
SET NEW.last_updated_date = NOW();
END ;;

CREATE TRIGGER manufacturers_bu_trig BEFORE UPDATE ON manufacturers FOR EACH ROW BEGIN
SET NEW.last_updated_date = NOW();
END ;;


CREATE TRIGGER grains_bi_trig BEFORE INSERT ON grains FOR EACH ROW BEGIN
SET NEW.creation_date = NOW();
SET NEW.last_updated_date = NOW();
END ;;

CREATE TRIGGER grains_bu_trig BEFORE UPDATE ON grains FOR EACH ROW BEGIN
SET NEW.last_updated_date = NOW();
END ;;


CREATE TRIGGER hops_bi_trig BEFORE INSERT ON hops FOR EACH ROW BEGIN
SET NEW.creation_date = NOW();
SET NEW.last_updated_date = NOW();
END ;;

CREATE TRIGGER hops_bu_trig BEFORE UPDATE ON hops FOR EACH ROW BEGIN
SET NEW.last_updated_date = NOW();
END ;;


CREATE TRIGGER adjuncts_bi_trig BEFORE INSERT ON adjuncts FOR EACH ROW BEGIN
SET NEW.creation_date = NOW();
SET NEW.last_updated_date = NOW();
END ;;

CREATE TRIGGER adjuncts_bu_trig BEFORE UPDATE ON adjuncts FOR EACH ROW BEGIN
SET NEW.last_updated_date = NOW();
END ;;


CREATE TRIGGER yeast_bi_trig BEFORE INSERT ON yeast FOR EACH ROW BEGIN
SET NEW.creation_date = NOW();
SET NEW.last_updated_date = NOW();
END ;;

CREATE TRIGGER yeast_bu_trig BEFORE UPDATE ON yeast FOR EACH ROW BEGIN
SET NEW.last_updated_date = NOW();
END ;;
DELIMITER ;