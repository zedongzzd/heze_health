drop table if exists t_dept;

drop table if exists t_doctor;

drop table if exists t_hospital;

drop table if exists t_patient;

drop table if exists t_regist;

drop table if exists t_schedual;

/*==============================================================*/
/* Table: t_dept                                                */
/*==============================================================*/
create table t_dept
(
   deptId               varchar(10) not null,
   name                 varchar(50),
   address              varchar(100),
   hospitalId           varchar(32),
   primary key (deptId)
);

/*==============================================================*/
/* Table: t_doctor                                              */
/*==============================================================*/
create table t_doctor
(
   doctorId             varchar(10) not null,
   name                 varchar(20),
   title                varchar(20),
   deptId               varchar(10),
   dept                 varchar(50),
   address              varchar(100),
   primary key (doctorId)
);

/*==============================================================*/
/* Table: t_hospital                                            */
/*==============================================================*/
create table t_hospital
(
   hospitalId           varchar(32) not null,
   name                 varchar(30),
   primary key (hospitalId)
);

/*==============================================================*/
/* Table: t_patient                                             */
/*==============================================================*/
create table t_patient
(
   patientId            varchar(20) not null,
   cardNo               varchar(32),
   name                 varchar(20),
   idCard               varchar(32),
   type                 int,
   uid                  varchar(20),
   primary key (patientId)
);

drop table if exists t_regist;

/*==============================================================*/
/* Table: t_regist                                              */
/*==============================================================*/
create table t_regist
(
   id                   int not null auto_increment,
   apptId               varchar(20),
   seqCode              varchar(20),
   regFee               varchar(5),
   serviceFee           varchar(5),
   hDate                varchar(10),
   admitRange           varchar(40),
   patientId            varchar(20),
   uid                  varchar(20),
   createDate           varchar(10),
   userID               varchar(20),
   hospitalId           varchar(32),
   deptId               varchar(10),
   docId                varchar(10),
   state                int,
   primary key (id)
);


/*==============================================================*/
/* Table: t_schedual                                            */
/*==============================================================*/
create table t_schedual
(
   id                   varchar(20) not null,
   date                 varchar(10),
   hospitalId           varchar(32),
   deptId               varchar(10),
   deptName             varchar(50),
   subjectId            varchar(10),
   subject              varchar(100),
   doctorIntro          varchar(200),
   price                varchar(5),
   typeId               varchar(10),
   type                 varchar(20),
   groupCode            varchar(20),
   groupName            varchar(30),
   address              varchar(100),
   resNo                int,
   primary key (id)
);
