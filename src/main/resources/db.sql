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





-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('', '外科换药', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0006', '消化王福贤', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0008', '消化刘庆民', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0016', '消化吴卫东', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0018', '血液桑玉旗', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0019', '消化郭东梅', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0023', '血液刘南', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0024', '消化李庆芝', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0033', '呼吸胡青', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0034', '泌尿内徐令华', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0039', '呼吸董卫平', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0041', '泌尿内田秋菊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0047', '呼吸李秀宪', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0054', '心内李桂香', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0057', '心内徐秋霞', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0058', '心内晁银霞', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0060', '心内王勇', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0063', '心内张道华', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0064', '心内赵永志', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0081', '神经内朱社华', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0088', '神经内宗碧云', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0090', '神经内孙卫亚', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0096', '神经内王松', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0097', '神经内吴晓燕', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('01', '消化内科', '门诊二楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('0102', '神经内李支援', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0105', '神经内李丽', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0106', '神经内吕凤亚', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0108', '神经内苏成林', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0109', '神经内王灵芝', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0117', '神经外王琪', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0119', '神经外张宏图', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0127', '神经外张信芳', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0129', '神经外张全忠', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0139', '内分泌许冰', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0147', '内三李启云', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0155', '风湿李洪毓', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0157', '内三李元华', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0159', '心内杨光全', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0161', '风湿陈宜恒', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0166', '内三张兆丽', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0170', '胸外崔广德', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0171', '胸外李振龙', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0176', '胸外马震', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0196', '骨外梁云扬', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('02', '血液内科', '门诊二楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('0208', '骨外陈永志', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0213', '骨外张善地', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0218', '骨外董斌', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0221', '泌尿外薛广兴', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0223', '泌尿外苑登强', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0224', '泌尿外李洪洲', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0229', '骨外冯勋强', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0230', '泌尿外郭永', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0233', '烧伤任长印', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0244', '美容刘明生', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0252', '骨外郝鹏', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0257', '两腺刘洪建', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0258', '胃肠韩要法', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0263', '胃肠邹兴存', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0275', '胃肠祝青', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0277', '肝胆孙智勇', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0287', '妇产唐桂荣', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0297', '妇产李英', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('03', '呼吸内科', '门诊二楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('0305', '妇产李瑞环', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0306', '妇产霍娟', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0310', '妇产潘雷', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0322', '妇产闫印春', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0334', '内分泌解合兰', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0369', '眼科王艾寅', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0374', '眼科李俊英', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0379', '眼科胡翠月', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0384', '耳鼻喉岳葆婷', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0389', '耳鼻喉刘荷珍', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0392', '耳鼻喉陈立勇', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('04', '泌尿内科', '门诊二楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('0401', '耳鼻喉陈广杰', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0405', '口腔曾爱荣', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0407', '口腔李莉', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0413', '口腔王益华', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0429', '儿科戚巧云', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0430', '儿科焦福利', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0438', '儿科张兰珍', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0443', '儿科周志远', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0445', '儿科刘金凤', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0447', '儿科于文立', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0450', '儿科王秀琴', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0456', '妇产姜文', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0459', '儿科常久利', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0460', '儿科王翠华', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0464', '儿科张培娥', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0466', '儿科田玉红', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0484', '传染苗爱军', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0486', '传染袁兆旭', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0493', '传染马占华', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('05', '内分泌科', '门诊二楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('0553', '麻醉梁兆科', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0554', '麻醉程相灿', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0575', '麻醉张雁', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('06', '神经内科', '门诊二楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('0634', '门办张雷杰', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('07', '心内科', '门诊二楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('0718', '放疗高忠民', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0722', '放疗刘秀荣', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0728', '放疗王军', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0729', '放疗陈友山', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0759', '急诊彭中坤', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0760', '急诊牛海涛', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0769', '急诊王立文', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0775', '急诊张随玉', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0776', '急诊冯庆芝', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0783', '急诊付双来', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('0787', '骨外冯涛', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('08', '老年病科', '门诊二楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('0817', '重症二科', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('09', '风湿科', '门诊二楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('10017', '骨外王奇', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('10031', '肝胆赵海旺', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1017', '内三庞少存', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1023', '心内赵新力', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1024', '内三赵锐利', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1072', '骨外宋国华', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1077', '肝胆刘成科', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1099', '肝胆叶永强', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('11', '胸外科', '门诊一楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('1101', '心内陈贝健', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('11011', '胃肠外科', '门诊一楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('11012', '两腺血管外科', '门诊一楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('11013', '肝胆疝外', '门诊一楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('1121', '骨科普通', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('11211', '骨创外科', '门诊一楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('11212', '骨关节外科', '门诊一楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('11213', '脊柱外科', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1138', '口腔周东升', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('11503', '妇科门诊手术室', '门诊三楼中区', '20009030500001');
INSERT INTO `t_dept` VALUES ('1151', '妇产科普通', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('11511', '孕产妇保健门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1158', '内三张玲', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1163', '儿科刘月东', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1169', '骨外刘振', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1197', '骨外于剑', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('12', '骨外科', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1201', '口腔普通', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('12148', '司法鉴定所', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1221', '小儿外葛芙蓉', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1223', '神经外任建军', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1231', '两腺魏志新', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1235', '眼科杨一涛', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1258', '风湿闵伟琪', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1261', '神经内朱明', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1262', '传染葛方启', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1263', '神经外郭西文', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1264', '胸外马心健', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1265', '骨外沙启乐', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1266', '妇产吴继海', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1268', '麻醉郭钊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1269', '两腺王伯祥', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1270', '心内吴付轩', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1271', '胸外王超峰', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1272', '骨外张勇', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1274', '骨外于桂生', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1277', '骨外冯松柏', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1278', '消化马艳丽', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1288', '骨外步国强', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1289', '烧伤于庆平', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('13', '泌尿外科', '门诊一楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('1311', '中医科特色门诊', '门诊二楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('1340', '神经内李玉文', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('13501', '口矫室', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1361', '血液颜安佩', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1362', '血液关建民', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1375', '骨外毛仲轩', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('139', '心脏血管外科', '门诊一楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('1391', '口腔张立生', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('14', '神经外科', '门诊一楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('14001', '内科普通门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('14002', '外科普通门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('14003', '妇科普通门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('14004', '儿科普通门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('14005', '眼科普通门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('14006', '耳鼻喉普通门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('14007', '口腔普通门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('14008', '皮肤普通门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('14009', '营养科普通门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('141', 'PICC门诊', '门诊三楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('1410', '儿科朱秀菊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('142', '伤口造口门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1450', '泌尿内张青德', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1459', '眼科戴馨', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('15', '小儿外科', '门诊一楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('1559', '神经外王刚', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1566', '皮肤邓仰福', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1588', '神经外梁宪坤', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('16', '烧伤科', '门诊一楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('161', '放疗王擎玉', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1612', '眼科刘翠英', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1613', '中医张汉启', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1614', '中医岳彩雷', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1616', '中医王雪英', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1617', '皮肤张本法', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1619', '急诊袁兆阁', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1621', '眼科张荣瑞', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1626', '急诊侯晗', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('1655', '儿科张建泽', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('166', '放疗李如玺', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('17', '妇产科', '门诊三楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('1708', '重症一科', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('18', '眼科', '门诊三楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('19', '小儿科', '门诊二楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('20', '不孕不育门诊', '门诊三楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('2015', '骨外刘合庆', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('202', '输血科', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('206', 'CT室', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('21', '耳鼻喉科', '门诊三楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('2167', '眼科武海军', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('219', '营养科', '门诊三楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('22', '口腔科', '口腔综合楼一楼', '20009030500001');
INSERT INTO `t_dept` VALUES ('222', '导管室', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('224', '磁共振室', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('23', '皮肤科', '门诊四楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('24', '肿瘤科', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('25', '传染科', '感染楼一楼', '20009030500001');
INSERT INTO `t_dept` VALUES ('26', '疼痛科', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('27', '美容科', '门诊四楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('2899', '妇产吕恒翠', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('29', '中医科', '门诊二楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('31', '中医普通', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('41101', '多学科综合门诊', '门诊三楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('442', '体检中心', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('53', '妇产科门诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('54', '门诊手术室', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('58', '血透室', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('61', '急诊科', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6199', '儿科王玉兰', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6255', '胃肠司世同', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6302', '内科朱崇第', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6303', '内科朱传由', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6305', '内科孙玉琴', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6306', '传染王福臣', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6309', '内科刘汉琪', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6313', '外科邹本章', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6317', '外科王兆允', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6322', '妇科郑素芳', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6323', '妇科李静', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6331', '儿科陈树藩', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6332', '儿科朱崇泉', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6334', '儿科李玉萍', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6371', '中医王玉贞', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6382', '内科张顺道', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6658', '神经外宋景元', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6666', '便民门诊', '门诊一楼西区', '20009030500001');
INSERT INTO `t_dept` VALUES ('6831', '内科王秀兰', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('6866', '血液夏建胜', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('87', '神经内急诊', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('90', '碎石中心', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9202', '病理科', '门诊四楼东区', '20009030500001');
INSERT INTO `t_dept` VALUES ('9278', '骨外刘传安', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9418', '骨外唐立群', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9421', '骨外黄晓楠', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9555', '内分泌朱昕', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9699', '内分泌程霖', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9706', '麻醉苗少华', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9710', '儿科王金荣', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9736', '不孕不育刘莲秋', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9737', '中医宋秀英', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9738', '皮肤晁青', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9966', '肌病吴保凡', '', '20009030500001');
INSERT INTO `t_dept` VALUES ('9993', '中医刘新惠', '', '20009030500001');

