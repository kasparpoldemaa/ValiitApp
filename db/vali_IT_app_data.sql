INSERT INTO public."user" (id, user_name, password) VALUES (DEFAULT, 'annvool@gmail.com', 'ann123');
INSERT INTO public."user" (id, user_name, password) VALUES (DEFAULT, 'maria@bcs.ee', 'maria123');
INSERT INTO public."user" (id, user_name, password) VALUES (DEFAULT, 'energia@energia.ee', 'eesti');
INSERT INTO public."user" (id, user_name, password) VALUES (DEFAULT, 'j00nas@gmail.com', 'Joonas456');

INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'student');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'company');

INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 1, 2);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 2, 1);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 3, 3);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 4, 2);

INSERT INTO public.student_profile (id, available_from, location, date_of_birth, competence, strength, about_me, linkedin, github_link) VALUES (DEFAULT, '30.05.2022', 'Tallinn', '1995-03-03', 'good at Java', 'communication', 'I love hiking', null, null);
INSERT INTO public.student_profile (id, available_from, location, date_of_birth, competence, strength, about_me, linkedin, github_link) VALUES (DEFAULT, 'I am available from June', 'Tapa', '1994-04-08', 'Java, Spring, Vue', 'problem-solver', 'I like sports and meeting new people', 'linkedin.com/j00nas', 'github.com/demo');

INSERT INTO public.student (id, user_id, student_profile_id, is_available) VALUES (DEFAULT, 1, 1, true);
INSERT INTO public.student (id, user_id, student_profile_id, is_available) VALUES (DEFAULT, 4, 2, true);

INSERT INTO public.education_experience (id, student_id, start_date, end_date, school, degree, field) VALUES (DEFAULT, 1, '2007-09-01', '2010-06-01', 'Tallinn University', 'Bachelors', 'Psychology');
INSERT INTO public.education_experience (id, student_id, start_date, end_date, school, degree, field) VALUES (DEFAULT, 2, '2013-08-31', '2017-06-06', 'Taltech', 'Masters', 'Construction');

INSERT INTO public.work_experience (id, start_date, end_date, company_name, position, job_description, student_id) VALUES (DEFAULT, '2019-10-17', '2022-03-31', 'Firma OÜ', 'Project leader', 'Managing people', 1);
INSERT INTO public.work_experience (id, start_date, end_date, company_name, position, job_description, student_id) VALUES (DEFAULT, '2016-04-03', '2022-02-28', 'Merko', 'Constructor', 'Building homes', 2);

