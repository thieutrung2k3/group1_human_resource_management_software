CREATE DATABASE db_hr_management_fptshop;

USE db_hr_management_fptshop;

CREATE TABLE BRANCH (
    branch_id VARCHAR(10) PRIMARY KEY NOT NULL,
    branch_name VARCHAR(100) NOT NULL UNIQUE,
    branch_address VARCHAR(255) NOT NULL UNIQUE,
    hotline VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE A_CCOUNT (
    account_id VARCHAR(10) PRIMARY KEY NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    pass_word VARCHAR(255) NOT NULL,
    access_right ENUM('Admin', 'User') NOT NULL
);

CREATE TABLE EMPLOYEE (
    employee_id VARCHAR(10) PRIMARY KEY NOT NULL,
    branch_id VARCHAR(10) NOT NULL,
    account_id VARCHAR(10) NOT NULL UNIQUE,
    full_name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    emp_address VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL UNIQUE,
    employee_position VARCHAR(50) NOT NULL,
    gender ENUM('Nam', 'Nữ') NOT NULL,
    FOREIGN KEY (branch_id) REFERENCES BRANCH(branch_id),
    FOREIGN KEY (account_id) REFERENCES A_CCOUNT(account_id)
);

CREATE TABLE SALE (
    sale_id VARCHAR(10) PRIMARY KEY NOT NULL,
    branch_id VARCHAR(10) NOT NULL,
    target_value DECIMAL(15, 2) NOT NULL,
    start_time DATE NOT NULL,
    deadline DATE NOT NULL,
    sta_tus ENUM('Đạt', 'Không đạt') NOT NULL,
    FOREIGN KEY (branch_id) REFERENCES BRANCH(branch_id)
);

CREATE TABLE SALARY (
    salary_id VARCHAR(10) PRIMARY KEY NOT NULL,
    employee_id VARCHAR(10) NOT NULL,
    base_salary DECIMAL(15, 2) NOT NULL,
    additional_salary DECIMAL(15, 2) NOT NULL DEFAULT 0,
    deduction DECIMAL(15, 2) NOT NULL DEFAULT 0,
    payment_date DATE NOT NULL,
    total_salary DECIMAL(15, 2) NOT NULL DEFAULT 0,
    FOREIGN KEY (employee_id) REFERENCES EMPLOYEE(employee_id)
);

CREATE TABLE ATTENDANCE (
    attendance_id VARCHAR(10) PRIMARY KEY NOT NULL,
    employee_id VARCHAR(10) NOT NULL,
    created_date DATE NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES EMPLOYEE(employee_id)
);

CREATE TABLE ATTENDANCE_DETAIL (
    attendance_detail_id VARCHAR(10) PRIMARY KEY NOT NULL,
    attendance_id VARCHAR(10) NOT NULL,
    check_in_time TIME,
    check_out_time TIME,
    attendance_date DATE NOT NULL,
    sta_tus ENUM('Muộn', 'Đúng giờ', 'Nghỉ làm') NOT NULL,
    FOREIGN KEY (attendance_id) REFERENCES ATTENDANCE(attendance_id) ON 
);