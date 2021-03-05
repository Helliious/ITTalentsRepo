#Task-1
SELECT * FROM DEPARTMENTS;

#Task-2
SELECT DEPARTMENT_NAME FROM DEPARTMENTS;

#Task-3
SELECT FIRST_NAME, 
		SALARY AS SALARY_BY_MONTH,
		SALARY / 20 AS SALARY_BY_DAY,
		SALARY / 20 / 8 AS SALARY_BY_HOUR
FROM EMPLOYEES;

#Task-4
SELECT first_name, last_name, CONCAT(LOWER(email), '@mail.somecompany.com') AS email_address
FROM employees;

#Task-5
SELECT DISTINCT SALARY FROM EMPLOYEES;

#Task-6
SELECT department_name FROM departments
UNION
SELECT region_name FROM regions
UNION
SELECT country_name FROM countries
UNION
SELECT city FROM locations;

#Task-7
SELECT * FROM EMPLOYEES
WHERE JOB_ID = "AC_MGR";

#Task-8
SELECT * FROM EMPLOYEES
WHERE FIRST_NAME LIKE 'Sa%';

#Task-9
SELECT * FROM EMPLOYEES
WHERE LAST_NAME LIKE '%ei%';

#Task-10
SELECT * FROM EMPLOYEES
WHERE SALARY BETWEEN 3000 AND 5000;

#Task-11
SELECT * FROM EMPLOYEES
WHERE SALARY BETWEEN 2000 AND 5000 OR SALARY BETWEEN 10000 AND 15000;

#Task-12
SELECT * FROM EMPLOYEES
WHERE SALARY IN (2500, 4000, 5000);

#Task-13
SELECT * FROM LOCATIONS
WHERE STATE_PROVINCE IS NULL OR POSTAL_CODE IS NULL;

#Task-14
SELECT * FROM EMPLOYEES
WHERE SALARY > 10000
ORDER BY SALARY DESC;

#Task-15
SELECT * FROM EMPLOYEES
ORDER BY HIRE_DATE ASC
LIMIT 10;

#Task-16
SELECT d.department_name, l.city FROM departments d JOIN locations l;

#Task-17
SELECT department_name, city FROM departments JOIN locations
USING (location_id);

#Task-18
SELECT d.department_name, l.city FROM departments d JOIN locations l
ON (d.location_id = l.location_id);

#Task-19
SELECT e.first_name, e.last_name, d.department_name, l.city FROM employees e
JOIN departments d ON (e.manager_id = d.manager_id)
JOIN locations l ON (d.location_id = l.location_id);

#Task-20
SELECT l.street_address, l.city, d.department_name FROM locations l
RIGHT OUTER JOIN departments d ON l.location_id = d.location_id;

#Task-21
SELECT l.street_address, l.city, d.department_name FROM departments d
LEFT OUTER JOIN locations l ON d.location_id = l.location_id;

#Task-22
SELECT l.street_address, l.city FROM locations l
WHERE l.location_id IN (SELECT location_id FROM departments) OR l.location_id IS NULL;

#Task-23
SELECT e.first_name, e.last_name, d.department_name FROM employees e
JOIN departments d ON e.manager_id = d.manager_id;

#Task-24
SELECT e.first_name, e.last_name, d.department_name, l.city FROM employees e
JOIN departments d ON e.manager_id = d.manager_id
JOIN locations l ON d.location_id = l.location_id;

#Task-25
SELECT first_name, last_name FROM employees
JOIN departments d ON d.department_name = "Sales" OR d.department_name = "Finance"
WHERE YEAR(hire_date) BETWEEN 1995 AND 2000;

#Task-26
SELECT * FROM employees e
JOIN job_history j ON e.employee_id = j.employee_id
JOIN departments d ON j.department_id = d.department_id AND d.department_name = "Sales";



