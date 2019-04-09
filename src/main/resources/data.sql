-- Default User / admin
INSERT INTO public.users(id, username, enabled, name, email, mobile, password) VALUES (1, 'admin', true, 'Admin', 'admin@etech-systems.com', '', '$2a$10$k5z8Kuxm6AJiJbsLnlGLXuHrjV7mNxRe.z62eFHrOb/8FlGQ63k/G');

-- Role Admin
INSERT INTO public.roles(id, code, enabled, name, description) VALUES (1, 'R0000', true, 'ADMIN', '');

-- Privileges
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (1,'M00',TRUE,'Admin Module','Show Admin Module System');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (2,'M00S010000',TRUE,'User Management','Show User Management Page');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (3,'M00S010001',TRUE,'Add User','Add User to System');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (4,'M00S010010',TRUE,'Edit User','Edit User Information');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (5,'M00S010100',TRUE,'View User','View User Information');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (6,'M00S011000',TRUE,'Delete User','Delete User');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (7,'M00S020000',TRUE,'Group Management','Show Group Management Page');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (8,'M00S020001',TRUE,'Add Group','Add Group to System');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (9,'M00S020010',TRUE,'Edit Group','Edit Group Information');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (10,'M00S020100',TRUE,'View Group','View Group Information');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (11,'M00S021000',TRUE,'Delete Group','Delete Group');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (12,'M00S030000',TRUE,'Role Management','Show Role Management Page');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (13,'M00S030001',TRUE,'Add Role','Add Role to System');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (14,'M00S030010',TRUE,'Edit Role','Edit Role Information');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (15,'M00S030100',TRUE,'View Role','View Role Information');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (16,'M00S031000',TRUE,'Delete Role','Delete Role');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (17,'M00S040000',TRUE,'Password Management','Show Password Management Page');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (18,'M00S040001',FALSE,'Add Password','Add Password Policy to System');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (19,'M00S040010',TRUE,'Edit Password','Edit Password Policy');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (20,'M00S040100',TRUE,'View Password','View Password Policy');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (21,'M00S041000',FALSE,'Delete Password','Delete Password');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (22,'M00S050000',TRUE,'Lookup Category Management','Lookup Category Management');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (23,'M00S050001',TRUE,'Add Lookup Category','Add Lookup Category to System');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (24,'M00S050010',TRUE,'Edit Lookup Category','Edit Lookup Category');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (25,'M00S050100',TRUE,'View Lookup Category','View Lookup Category');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (26,'M00S051000',TRUE,'Delete Lookup Category','Delete Lookup Category');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (27,'M00S060000',TRUE,'Lookup Symbol Management','Lookup Symbol Management');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (28,'M00S060001',TRUE,'Add Lookup Symbol','Add Lookup Symbol to System');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (29,'M00S060010',TRUE,'Edit Lookup Symbol','Edit Lookup Symbol');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (30,'M00S060100',TRUE,'View Lookup Symbol','View Lookup Symbol');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (31,'M00S061000',TRUE,'Delete Lookup Symbol','Delete Lookup Symbol');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (32,'M00R000001',TRUE,'Report 1','View Report 1');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (33,'M00R000002',TRUE,'Report 2','View Report 2');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (34,'M00R000003',TRUE,'Report 3','View Report 3');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (35,'M00R000004',TRUE,'Report 4','View Report 4');
INSERT INTO public.privileges(id, code, enabled, name, description) VALUES (36,'M00R000005',TRUE,'Report 5','View Report 5');


-- Relation Role / Privileges
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (1, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (2, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (3, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (4, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (5, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (6, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (7, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (8, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (9, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (10, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (11, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (12, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (13, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (14, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (15, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (16, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (17, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (18, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (19, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (20, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (21, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (22, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (23, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (24, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (25, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (26, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (27, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (28, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (29, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (30, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (31, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (32, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (33, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (34, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (35, 1, 1554806423578);
INSERT INTO public.roleprivilege(privilege_id, role_id, last_modified) VALUES (36, 1, 1554806423578);

-- Relation User / Role
INSERT INTO public.userroles(role_id, user_id, last_modified) VALUES (1,1,1554803365114);

