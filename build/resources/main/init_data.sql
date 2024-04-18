DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
CREATE TABLE sqlcommands (id SERIAL PRIMARY KEY, command TEXT);
INSERT INTO sqlcommands (command) VALUES ('INSERT INTO thirdpartypayment (');
INSERT INTO sqlcommands (command) VALUES ('    thirdpartypaymentid, thirdpartypaymentcode, thirdpartypaymentdisplayname,');
INSERT INTO sqlcommands (command) VALUES ('    platform, merchantinfo) VALUES');
INSERT INTO sqlcommands (command) VALUES ('    (''');
INSERT INTO sqlcommands (command) VALUES (''', ''');
INSERT INTO sqlcommands (command) VALUES ('{"en-US": "');
INSERT INTO sqlcommands (command) VALUES ('", "zh-CN": "');
INSERT INTO sqlcommands (command) VALUES ('", "zh-TW": "');
INSERT INTO sqlcommands (command) VALUES ('"}'',');
INSERT INTO sqlcommands (command) VALUES ('     3, ''');
INSERT INTO sqlcommands (command) VALUES (''');');

