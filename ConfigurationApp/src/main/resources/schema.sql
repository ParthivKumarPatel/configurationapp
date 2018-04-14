create table if not exists configurableitem(
   name varchar(255) not null,
   appcode varchar(255) not null,
   version varchar(255) not null,
   lastmodified  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY(appcode, version)
 );
