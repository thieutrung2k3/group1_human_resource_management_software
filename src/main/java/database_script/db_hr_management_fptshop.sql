/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  PC
 * Created: Aug 15, 2024
 */

CREATE DATABASE db_hr_management_fptshop;

USE db_hr_management_fptshop;

CREATE TABLE BRANCH (
    branch_id VARCHAR(10) PRIMARY KEY NOT NULL,
    branch_name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    hotline VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE A_CCOUNT (
    account_id VARCHAR(10) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    pass_word VARCHAR(255) NOT NULL,
    access_right ENUM('Admin', 'User') NOT NULL
);

CREATE TABLE EMPLOYEE (
    employee_id VARCHAR(10) PRIMARY KEY,
    branch_id VARCHAR(10) NOT NULL,
    account_id VARCHAR(10) UNIQUE,
    full_name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(5) NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone_number VARCHAR(20) NOT NULL,
    employee_position VARCHAR(50) NOT NULL,
    FOREIGN KEY (branch_id) REFERENCES BRANCH(branch_id),
    FOREIGN KEY (account_id) REFERENCES A_CCOUNT(account_id)
);

CREATE TABLE SALE (
    sales_id VARCHAR(10) PRIMARY KEY,
    branch_id VARCHAR(10) NOT NULL,
    target DECIMAL(15, 2) NOT NULL,
    start_time DATE NOT NULL,
    deadline DATE NOT NULL,
    sta_tus ENUM('Đạt', 'Không đạt') NOT NULL,
    FOREIGN KEY (branch_id) REFERENCES BRANCH(branch_id)
);

CREATE TABLE SALARY (
    salary_id VARCHAR(10) PRIMARY KEY,
    employee_id VARCHAR(10) NOT NULL,
    base_salary DECIMAL(15, 2) NOT NULL,
    additional_salary DECIMAL(15, 2) NOT NULL DEFAULT 0,
    deduction DECIMAL(15, 2) NOT NULL DEFAULT 0,
    total_salary DECIMAL(15, 2) NOT NULL DEFAULT 0,
    payment_date DATE NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES EMPLOYEE(employee_id)
);

CREATE TABLE ATTENDANCE (
    attendance_id VARCHAR(10) PRIMARY KEY,
    employee_id VARCHAR(10) NOT NULL,
    created_date DATE NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES EMPLOYEE(employee_id)
);

CREATE TABLE ATTENDANCE_DETAIL (
    attendance_detail_id VARCHAR(10) PRIMARY KEY,
    attendance_id VARCHAR(10) NOT NULL,
    check_in_time TIME,
    check_out_time TIME,
    attendance_date DATE NOT NULL,
    sta_tus ENUM('Muộn', 'Đúng giờ') NOT NULL,
    FOREIGN KEY (attendance_id) REFERENCES ATTENDANCE(attendance_id)
);

