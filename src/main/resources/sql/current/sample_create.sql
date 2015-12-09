create sequence CHILD_ID_SEQ start with 1 increment by 1;
create sequence PARENT_ID_SEQ start with 1 increment by 1;
create table CHILD (
	ID number(19,0) not null,
	NAME varchar2(255 char),
	primary key (ID)
);
create table PARENT (
	ID number(19,0) not null,
	NAME varchar2(255 char),
	primary key (ID)
);
create table PARENT_CHILD (
	PARENT_ID number(19,0) not null,
	CHILD_ID number(19,0) not null
);
create index IDX_NAME
	on CHILD (NAME);
alter table CHILD
	add constraint UK_NAME unique (NAME);
create index IDX_NAME
	on PARENT (NAME);
alter table PARENT
	add constraint UK_NAME unique (NAME);
alter table PARENT_CHILD
	add constraint UK_CHILD_ID unique (CHILD_ID);
alter table PARENT_CHILD
	add constraint FK69bmpu1nwc7cw8q7k6cdtkfwl foreign key (CHILD_ID)references CHILD;
alter table PARENT_CHILD
	add constraint FK9mylv8mi284owpvvf8pckq105 foreign key (PARENT_ID)references PARENT;
