create or replace trigger t_rbu_r_user_1
  before insert on r_user
  for each row
begin
  :new.salt := dbms_random.string('A', 25);  
end;
/ 