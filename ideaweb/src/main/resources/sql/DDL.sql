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

 CREATE TABLE user_table (
   userid int(11) NOT NULL AUTO_INCREMENT,
   name varchar(8) NOT NULL,
   password varchar(12) NOT NULL DEFAULT '123456',
   account varchar(12) NOT NULL DEFAULT 'admin',
   sex int(11) NOT NULL DEFAULT '1',
   age int(11) NOT NULL,
   tel varchar(30) NOT NULL DEFAULT '',
   addr varchar(30) NOT NULL DEFAULT '',
   create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   money int(11) NOT NULL DEFAULT '0',
   cost int(11) NOT NULL DEFAULT '0',
   update_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (id),
   UNIQUE KEY account (account),
   KEY name (name)
 ) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4


 CREATE TABLE user_pwd_change_log (
  logid INT NOT NULL AUTO_INCREMENT,
  userid INT(11) NOT NULL,
  pwdold VARCHAR(45) NOT NULL,
  pwdnew VARCHAR(45) NOT NULL,
  addtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  addwho VARCHAR(45) NULL DEFAULT '',
  PRIMARY KEY (logid)
  )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
