INSERT INTO public.department (name) VALUES ('Technology');
INSERT INTO public.department (name) VALUES ('Marketing');
INSERT INTO public.department (name) VALUES ('Sales');

INSERT INTO public.timesheet (name, start_date, end_date) VALUES ('January 2020', '2020-01-06', '2020-01-11' );
INSERT INTO public.timesheet (name, start_date, end_date) VALUES ('February 2020', '2020-02-03', '2020-02-08' );
INSERT INTO public.timesheet (name, start_date, end_date) VALUES ('March 2020', '2020-03-02', '2020-03-07' );

INSERT INTO public.users (createdate, email, enabled, firstname, lastname, password, tokenexpired, username, id_department)
VALUES ('2020-01-01', 'a@gmail.com', true, 'juan', 'cv', '$2a$10$nQLncZ5XKsCD5R6c16me1O8CtfzL0Y4qljE0KMPQkRd2.grz41fsS', false, 'us1',1);
INSERT INTO public.users (createdate, email, enabled, firstname, lastname, password, tokenexpired,username,id_department)
VALUES ('2020-02-01', 'b@gmail.com', true, 'paco', 'cv', '$2a$10$nQLncZ5XKsCD5R6c16me1O8CtfzL0Y4qljE0KMPQkRd2.grz41fsS', false,'us2',1);
INSERT INTO public.users (createdate, email, enabled, firstname, lastname, password, tokenexpired,username,id_department)
VALUES ('2020-03-01', 'c@gmail.com', true, 'pedro', 'cv', '$2a$10$nQLncZ5XKsCD5R6c16me1O8CtfzL0Y4qljE0KMPQkRd2.grz41fsS', false, 'us3',2);

INSERT INTO public.timesheetdetails (approved, paid, id_timesheet, id_user) VALUES (false, false, 1, 1);
INSERT INTO public.timesheetdetails (approved, paid, id_timesheet, id_user) VALUES (true, true, 1, 2);
INSERT INTO public.timesheetdetails (approved, paid, id_timesheet, id_user) VALUES (true, false, 2, 3);

INSERT INTO public.hours (hours, date, id_timesheetdetails) VALUES (1, '2020-01-06',1);
INSERT INTO public.hours (hours, date, id_timesheetdetails) VALUES (2, '2021-01-02',2);
INSERT INTO public.hours (hours, date, id_timesheetdetails) VALUES (3, '2021-01-03',2);

INSERT INTO public.role (name) VALUES ('admin');
INSERT INTO public.role (name) VALUES ('user');
INSERT INTO public.role (name) VALUES ('manager');
