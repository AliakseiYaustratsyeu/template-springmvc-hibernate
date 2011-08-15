
insert into r_user values(seq_r_user_id.nextval, 'admin', 'admin', 'First_Name_admin', 'Last_Name_admin' 
                          , 'admin@stepbysteptopro.com', '+375293335533', 'Belarus', 'Gomel', 'Zarechnay Str.',
						  ' ', 1, 0, 0, 0, 0, 1); 
insert into r_user values(seq_r_user_id.nextval, 'user', 'user', 'First_Name_user', 'Last_Name_user' , 
                          'user@stepbysteptopro.com', '+375293335538', 'Belarus', 'Gomel', 'Ilicha Str.', 
						  ' ', 1, 0, 0, 0, 0, 1);
insert into r_user values(seq_r_user_id.nextval, 'FirstName1', 'FirstName1', 'First_Name1', 'Last_Name1' , 
                          'FirstName1@stepbysteptopro.com', '+375293337865', 'Belarus', 'Gomel', 'Sovetskay Str.', 
						  ' ', 1, 0, 0, 0, 0, 1); 
insert into r_user values(seq_r_user_id.nextval, 'FirstName2', 'FirstName2', 'First_Name2', 'Last_Name2' , 
                          'FirstName2@stepbysteptopro.com', '+375299935533', 'Belarus', 'Vitebsk', 'Lenina Str.', 
						  ' ', 1, 0, 0, 0, 0, 1); 
insert into r_user values(seq_r_user_id.nextval, 'FirstName3', 'FirstName3', 'First_Name3', 'Last_Name3' , 
                          'FirstName3@stepbysteptopro.com', '+375293332133', 'Belarus', 'Minsk', 'Zheleznay Str.', 
						  ' ', 1, 0, 0, 0, 0, 1); 
commit;

insert into c_role values(seq_r_role_id.nextval, 'ROLE_ADMIN', 'role_admin description'); 
insert into c_role values(seq_r_role_id.nextval, 'ROLE_USER', 'role_user description'); 
commit;

insert into l_user_role values(seq_l_user_role_id.nextval, 1, 1); 
insert into l_user_role values(seq_l_user_role_id.nextval, 2, 2);
insert into l_user_role values(seq_l_user_role_id.nextval, 3, 2);
insert into l_user_role values(seq_l_user_role_id.nextval, 4, 2);
insert into l_user_role values(seq_l_user_role_id.nextval, 5, 2);
commit;