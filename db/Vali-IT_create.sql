-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-05-04 12:15:36.082

-- tables
-- Table: contact
CREATE TABLE contact (
    id serial  NOT NULL,
    first_name varchar(255)  NULL,
    last_name varchar(255)  NULL,
    company_name varchar(255)  NULL,
    address varchar(255)  NULL,
    user_id int  NOT NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: education_experience
CREATE TABLE education_experience (
    id serial  NOT NULL,
    student_id int  NOT NULL,
    start_date date  NOT NULL,
    end_date date  NULL,
    school varchar(255)  NOT NULL,
    degree varchar(255)  NULL,
    field varchar(255)  NOT NULL,
    CONSTRAINT education_experience_pk PRIMARY KEY (id)
);

-- Table: event
CREATE TABLE event (
    id serial  NOT NULL,
    date date  NOT NULL,
    time varchar(255)  NULL,
    event_name varchar(255)  NOT NULL,
    company varchar(255)  NOT NULL,
    zoom varchar(255)  NULL,
    presenter_name varchar(255)  NULL,
    CONSTRAINT event_pk PRIMARY KEY (id)
);

-- Table: internship_applicant
CREATE TABLE internship_applicant (
    id serial  NOT NULL,
    internship_opportunity_id int  NOT NULL,
    student_id int  NOT NULL,
    motivation_letter varchar(1000)  NOT NULL,
    CONSTRAINT internship_applicant_pk PRIMARY KEY (id)
);

-- Table: internship_opportunity
CREATE TABLE internship_opportunity (
    id serial  NOT NULL,
    location varchar(255)  NULL,
    start_time varchar(255)  NOT NULL,
    duration varchar(255)  NOT NULL,
    is_payable boolean  NOT NULL,
    number_of_positions varchar(255)  NULL,
    comment varchar(255)  NULL,
    user_id int  NOT NULL,
    technology varchar(500)  NOT NULL,
    work_type varchar(500)  NOT NULL,
    CONSTRAINT internship_oportunity_pk PRIMARY KEY (id)
);

-- Table: picture
CREATE TABLE picture (
    id serial  NOT NULL,
    base64 bytea  NOT NULL,
    CONSTRAINT picture_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: student
CREATE TABLE student (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    student_profile_id int  NOT NULL,
    is_available boolean  NOT NULL,
    picture_id int  NULL,
    CONSTRAINT student_pk PRIMARY KEY (id)
);

-- Table: student_profile
CREATE TABLE student_profile (
    id serial  NOT NULL,
    available_from varchar(255)  NULL,
    location varchar(50)  NULL,
    date_of_birth date  NULL,
    competence varchar(500)  NULL,
    strength varchar(500)  NULL,
    about_me varchar(255)  NULL,
    linkedIn varchar(50)  NULL,
    github_link varchar(50)  NULL,
    CONSTRAINT student_profile_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    user_name varchar(50)  NOT NULL,
    password varchar(50)  NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE user_role (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    role_id int  NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (id)
);

-- Table: work_experience
CREATE TABLE work_experience (
    id serial  NOT NULL,
    start_date date  NOT NULL,
    end_date date  NULL,
    company_name varchar(255)  NOT NULL,
    position varchar(255)  NOT NULL,
    job_description varchar(1000)  NOT NULL,
    student_id int  NOT NULL,
    CONSTRAINT work_experience_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: contact_user (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: education_experience_student (table: education_experience)
ALTER TABLE education_experience ADD CONSTRAINT education_experience_student
    FOREIGN KEY (student_id)
    REFERENCES student (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: internship_applicant_internship_oportunity (table: internship_applicant)
ALTER TABLE internship_applicant ADD CONSTRAINT internship_applicant_internship_oportunity
    FOREIGN KEY (internship_opportunity_id)
    REFERENCES internship_opportunity (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: internship_applicant_student (table: internship_applicant)
ALTER TABLE internship_applicant ADD CONSTRAINT internship_applicant_student
    FOREIGN KEY (student_id)
    REFERENCES student (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: internship_oportunity_user (table: internship_opportunity)
ALTER TABLE internship_opportunity ADD CONSTRAINT internship_oportunity_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: student_picture (table: student)
ALTER TABLE student ADD CONSTRAINT student_picture
    FOREIGN KEY (picture_id)
    REFERENCES picture (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: student_student_profile (table: student)
ALTER TABLE student ADD CONSTRAINT student_student_profile
    FOREIGN KEY (student_profile_id)
    REFERENCES student_profile (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: student_user (table: student)
ALTER TABLE student ADD CONSTRAINT student_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: work_experience_student (table: work_experience)
ALTER TABLE work_experience ADD CONSTRAINT work_experience_student
    FOREIGN KEY (student_id)
    REFERENCES student (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

