SELECT * FROM client;
SELECT * FROM tariff;
SELECT * FROM add_service;
SELECT * FROM client_add_service;
SELECT * FROM personal_info;
SELECT * FROM employee;
SELECT * FROM report;
SELECT * FROM category;
SELECT * FROM file_storage;

SELECT client_id, phone_number FROM client 
WHERE tariff_id IN (
	SELECT tariff_id FROM tariff WHERE internet_size > 10
);

SELECT client_id, full_name FROM personal_info
WHERE client_id IN (
	SELECT client_id FROM client WHERE balance > 500
);

(SELECT client_id, phone_number FROM client
WHERE balance > 500)
UNION
(SELECT client_id, phone_number FROM client
WHERE balance < 200);

(SELECT name, cost FROM tariff
WHERE minutes_size > 700)
UNION
(SELECT name, cost FROM tariff
WHERE sms_size > 1000);

