DROP SCHEMA IF EXISTS dictionary;
CREATE SCHEMA IF NOT EXISTS dictionary DEFAULT CHARACTER SET utf8mb4 collate utf8mb4_unicode_ci;

DROP user IF EXISTS together ;
CREATE USER together IDENTIFIED BY 'together123456';

grant  SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, LOCK TABLES, EXECUTE on dictionary.* to together@"%" Identified by "together123456";

flush privileges;