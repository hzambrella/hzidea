CREATE TABLE student (
   id int(11) NOT NULL DEFAULT '0',
   name varchar(5) NOT NULL,
   class_id int(11) NOT NULL,
   PRIMARY KEY (id),
   KEY idx_class (class_id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


 CREATE TABLE actor (
   actor_id smallint(5) NOT NULL,
   first_name_v varchar(45) DEFAULT NULL,
   last_name_v varchar(45) DEFAULT NULL,
   last_update timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   descrip varchar(45) DEFAULT NULL,
   PRIMARY KEY (actor_id),
   KEY idx_lastname (last_name_v)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;