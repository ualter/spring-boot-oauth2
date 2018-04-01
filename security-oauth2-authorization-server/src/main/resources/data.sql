-- INSERT INTO oauth_client_details
-- 	(client_id, client_secret, scope, authorized_grant_types,
-- 	web_server_redirect_uri, authorities, access_token_validity,
-- 	refresh_token_validity, additional_information, autoapprove)
-- VALUES
-- 	('fooClientIdPassword', 'secret', 'foo,read,write',
-- 	'password,authorization_code,refresh_token', null, null, 36000, 36000, null, true);
-- 	
-- INSERT INTO oauth_client_details
-- 	(client_id, client_secret, scope, authorized_grant_types,
-- 	web_server_redirect_uri, authorities, access_token_validity,
-- 	refresh_token_validity, additional_information, autoapprove)
-- VALUES
-- 	('sampleClientId', 'secret', 'read,write,foo,bar',
-- 	'implicit', null, null, 36000, 36000, null, false);
	
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('yostark', 'jep817', 'bar,read,write','password,authorization_code,refresh_token',
	'http://localhost:9091/yostark/welcome', null, 3600,
	3600, null, true);
	
INSERT INTO oauth_client_details
	(client_id, client_secret, scope, authorized_grant_types,
	web_server_redirect_uri, authorities, access_token_validity,
	refresh_token_validity, additional_information, autoapprove)
VALUES
	('microshark', '3opm8b', 'read','password,authorization_code,refresh_token',
	  'http://localhost:9090/microshark/welcome', null, 3600,
	  3600, null, false);	