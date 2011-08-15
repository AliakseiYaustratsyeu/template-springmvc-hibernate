purge recyclebin;
drop table persistent_logins purge;
drop table l_user_role purge;
drop table c_role purge;
drop table r_user purge;

create table r_user (
	user_id      number(19)   not null,
	username     varchar2(50) not null,
	password     varchar2(50) not null,		
	first_name   varchar2(50) not null,
	last_name    varchar2(50) not null,
	email        varchar2(50),
	phone_number varchar2(50),	
	country      varchar2(100),
	city         varchar2(50),	
	address      varchar2(150),
    salt         varchar2(25) not null,
    account_enabled  number(1)    not null,	  
    account_expired  number(1)    not null,	 
    account_locked   number(1)    not null,	 
    credentials_expired  number(1)    not null,
	password_encrypted number(1)    not null,
	version number(19)   not null
)
/

alter table r_user add (constraint pk_r_user primary key (user_id));
alter table r_user add (constraint uk1_r_user unique (user_id, username));
alter table r_user add (constraint ck1_r_user check (account_enabled in (0, 1)));
alter table r_user add (constraint ck2_r_user check (account_expired in (0, 1)));
alter table r_user add (constraint ck3_r_user check (account_locked in (0, 1)));
alter table r_user add (constraint ck4_r_user check (credentials_expired in (0, 1)));

create table c_role (
    role_id number(19),	
	name    varchar(20),
    description varchar(64)	
)
/

alter table c_role add (constraint pk_c_role primary key (role_id));
alter table c_role add (constraint uk1_c_role unique (role_id, name));

create table l_user_role (
	user_role_id number(19),
	user_id number(19),
    role_id number(19)		
)
/

alter table l_user_role add (constraint pk_l_user_role primary key (user_role_id));
alter table l_user_role add (constraint fk_rrole_user_id_lur foreign key (user_id) references r_user (user_id));
alter table l_user_role add (constraint fk_rrole_role_id_lur foreign key (role_id) references c_role (role_id));

create table persistent_logins (
    username varchar(50) not null,
    series varchar(64) primary key,
    token varchar(64) not null,
    last_used timestamp not null
)
/

alter table persistent_logins add (constraint uk1_persistent_logins unique (username));
