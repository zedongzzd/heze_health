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
   phone                varchar(20),
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
-- 记录
-- ----------------------------
/**
 * 科室数据
 */
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
/**
 * 医生数据
 */
INSERT INTO `t_doctor` VALUES ('0006', '王福贤', '主任医师', '01', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0008', '刘庆民', '主任医师', '01', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0016', '吴卫东', '主任医师', '01', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0018', '桑玉旗', '主任医师', '02', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0019', '郭冬梅', '副主任医师', '01', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0022', '赵卫平', '副主任医师', '02', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0023', '刘南', '主任医师', '02', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0024', '李庆芝', '副主任医师', '01', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0028', '吴凤娟', '主治医师', '14001', null, '');
INSERT INTO `t_doctor` VALUES ('0033', '胡青', '主任医师', '03', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0034', '徐令华', '主任医师', '04', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0039', '董卫平', '主任医师', '03', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0041', '田秋菊', '副主任医师', '04', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0047', '李秀宪', '主任医师', '03', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0054', '李桂香', '主任医师', '07', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0057', '徐秋霞', '副主任医师', '07', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0058', '晁银霞', '副主任医师', '07', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0060', '王勇', '主任医师', '07', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0062', '牛文堂', '主治医师', '07', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0063', '张道华', '主任医师', '07', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0064', '赵永志', '主任医师', '07', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0073', '曹雪如', '主治医师', '03', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0081', '朱社华', '副主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0088', '宗碧云', '主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0090', '孙卫亚', '主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0096', '王松', '主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0097', '吴晓燕', '主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0102', '李支援', '副主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0105', '李丽', '主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0106', '吕凤亚', '副主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0107', '韩凌', '副主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0108', '苏成林', '副主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0109', '王灵芝', '主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0117', '王琪', '主任医师', '14', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0119', '张宏图', '副主任医师', '14', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0125', '徐文涛', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0127', '张信芳', '副主任医师', '14', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0128', '姜海涛', '副主任医师', '14', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0129', '张全忠', '主任医师', '14', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0139', '许冰', '主任医师', '05', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0147', '李启云', '主任医师', '08', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0150', '刘春燕', '主治医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('0155', '李洪毓', '主任医师', '09', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0157', '李元华', '主任医师', '08', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0159', '杨光全', '副主任医师', '07', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0161', '陈宜恒', '主任医师', '09', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0164', '王春华', '主治医师', '09', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0166', '张兆丽', '副主任医师', '08', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0170', '崔广德', '主任医师', '11', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0171', '李振龙', '主任医师', '11', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0176', '马震', '副主任医师', '11', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0185', '华克胜', '副主任医师', '11', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0196', '梁云扬', '主治医师', '11212', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0206', '闫传柱', '主任医师', '12', null, '');
INSERT INTO `t_doctor` VALUES ('0208', '陈永志', '主任医师', '11212', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0213', '张善地', '副主任医师', '11213', null, '');
INSERT INTO `t_doctor` VALUES ('0218', '董斌', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0221', '薛广兴', '主任医师', '13', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0223', '苑登强', '副主任医师', '13', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0224', '李洪洲', '主任医师', '13', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0229', '冯勋强', '主治医师', '15', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0230', '郭永', '副主任医师', '13', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0233', '任长印', '主任医师', '16', null, '门诊一楼西区');
INSERT INTO `t_doctor` VALUES ('0240', '李守聚', '副主任医师', '16', null, '门诊一楼西区');
INSERT INTO `t_doctor` VALUES ('0242', '于海霞', '主治医师', '16', null, '门诊一楼西区');
INSERT INTO `t_doctor` VALUES ('0244', '刘明生', '副主任医师', '27', null, '门诊四楼西区');
INSERT INTO `t_doctor` VALUES ('0249', '周亚鹏', '主治医师', '27', null, '门诊四楼西区');
INSERT INTO `t_doctor` VALUES ('0252', '郝鹏', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0257', '刘洪建', '主任医师', '11012', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0258', '韩要法', '主任医师', '11011', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0263', '邹兴存', '主任医师', '11011', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0275', '祝青', '副主任医师', '11011', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0277', '孙智勇', '副主任医师', '11013', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0279', '薛洪峰', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0280', '郭勇', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0283', '李霞', '主治医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('0287', '唐桂荣', '副主任医师', '17', null, '门诊三楼东区');
INSERT INTO `t_doctor` VALUES ('0297', '李英', '主任医师', '17', null, '门诊三楼东区');
INSERT INTO `t_doctor` VALUES ('0305', '李瑞环', '主任医师', '17', null, '门诊三楼东区');
INSERT INTO `t_doctor` VALUES ('0306', '霍娟', '主任医师', '17', null, '门诊三楼东区');
INSERT INTO `t_doctor` VALUES ('0310', '潘雷', '主任医师', '17', null, '门诊三楼东区');
INSERT INTO `t_doctor` VALUES ('0322', '闫印春', '主任医师', '17', null, '门诊三楼东区');
INSERT INTO `t_doctor` VALUES ('0334', '解合兰', '副主任医师', '05', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0338', '金海英', '副主任医师', '20', null, '门诊三楼东区');
INSERT INTO `t_doctor` VALUES ('0344', '刘海彬', '主治医师', '11511', null, '');
INSERT INTO `t_doctor` VALUES ('0345', '李慧卿', '主治医师', '17', null, '门诊三楼东区');
INSERT INTO `t_doctor` VALUES ('0347', '陈波', '主治医师', '11511', null, '');
INSERT INTO `t_doctor` VALUES ('0348', '程世杰', '主治医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('0369', '王艾寅', '主任医师', '18', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('0372', '晁岱岭', '副主任医师', '18', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('0373', '李秀贵', '副主任医师', '18', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('0374', '李俊英', '副主任医师', '18', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('0375', '陈进', '副主任医师', '18', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('0376', '李慧', '主治医师', '14005', null, '');
INSERT INTO `t_doctor` VALUES ('0379', '胡翠月', '主任医师', '18', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('0384', '岳葆婷', '副主任医师', '21', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('0385', '刘训超', '主治医师', '14001', null, '');
INSERT INTO `t_doctor` VALUES ('0389', '刘荷珍', '副主任医师', '21', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('0392', '陈立勇', '副主任医师', '21', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('0395', '李军', '主治医师', '14006', null, '');
INSERT INTO `t_doctor` VALUES ('0398', '王守玺', '主治医师', '14006', null, '');
INSERT INTO `t_doctor` VALUES ('0401', '陈广杰', '主任医师', '21', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('0405', '曾爱荣', '主任医师', '22', null, '口腔综合楼一楼');
INSERT INTO `t_doctor` VALUES ('0407', '李莉', '主任医师', '22', null, '口腔综合楼一楼');
INSERT INTO `t_doctor` VALUES ('0413', '王益华', '副主任医师', '22', null, '口腔综合楼一楼');
INSERT INTO `t_doctor` VALUES ('0416', '孙新国', '主治医师', '14007', null, '');
INSERT INTO `t_doctor` VALUES ('0417', '刘守超 ', '主治医师', '22', null, '口腔综合楼一楼');
INSERT INTO `t_doctor` VALUES ('0419', '徐娟', '主治医师', '22', null, '口腔综合楼一楼');
INSERT INTO `t_doctor` VALUES ('0429', '戚巧云', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0430', '焦福利', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0438', '张兰珍', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0440', '冯兴柱', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0443', '周志远', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0445', '刘金凤', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0447', '于文立', '主治医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0450', '王秀琴', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0456', '姜文', '副主任医师', '17', null, '门诊三楼东区');
INSERT INTO `t_doctor` VALUES ('0459', '常久利', '副主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0460', '王翠华', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0461', '王蕾', '副主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0464', '张培娥', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('0466', '田玉红', '副主任医师', '0466', null, '');
INSERT INTO `t_doctor` VALUES ('0476', '孙文莲', '主任医师', '25', null, '感染楼一楼');
INSERT INTO `t_doctor` VALUES ('0477', '付继荣', '主任医师', '25', null, '感染楼一楼');
INSERT INTO `t_doctor` VALUES ('0481', '朱桂荣', '主任医师', '25', null, '感染楼一楼');
INSERT INTO `t_doctor` VALUES ('0484', '苗爱军', '主任医师', '25', null, '感染楼一楼');
INSERT INTO `t_doctor` VALUES ('0486', '袁兆旭', '副主任医师', '25', null, '感染楼一楼');
INSERT INTO `t_doctor` VALUES ('0491', '赵爱英', '副主任医师', '25', null, '感染楼一楼');
INSERT INTO `t_doctor` VALUES ('0492', '姬群英', '主治医师', '09', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0493', '马占华', '主任医师', '25', null, '感染楼一楼');
INSERT INTO `t_doctor` VALUES ('0553', '粱兆科', '副主任医师', '26', null, '');
INSERT INTO `t_doctor` VALUES ('0554', '程相灿', '副主任医师', '26', null, '');
INSERT INTO `t_doctor` VALUES ('0562', '高飞', '主治医师', '26', null, '');
INSERT INTO `t_doctor` VALUES ('0575', '张雁', '主治医师', '26', null, '');
INSERT INTO `t_doctor` VALUES ('0579', '王海峰', '主治医师', '26', null, '');
INSERT INTO `t_doctor` VALUES ('0634', '张雷杰', '副主任医师', '6666', null, '门诊一楼西区');
INSERT INTO `t_doctor` VALUES ('0695', '张一卓', '主治医师', '08', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0718', '高忠民', '副主任医师', '24', null, '');
INSERT INTO `t_doctor` VALUES ('0722', '刘秀荣', '副主任医师', '24', null, '');
INSERT INTO `t_doctor` VALUES ('0728', '王军', '副主任医师', '24', null, '');
INSERT INTO `t_doctor` VALUES ('0729', '陈友山', '主任医师', '24', null, '');
INSERT INTO `t_doctor` VALUES ('0733', '张文霞', '主治医师', '24', null, '');
INSERT INTO `t_doctor` VALUES ('0742', '和劲光', '主治医师', '24', null, '');
INSERT INTO `t_doctor` VALUES ('0754', '张凤香', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0759', '彭中坤', '主任医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0760', '牛海涛', '副主任医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0769', '王立文', '主任医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0775', '张随玉', '主任医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0776', '冯庆芝', '副主任医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0783', '付双来', '主任医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0787', '冯涛', '主任医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0793', '赵妍', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0866', '陈琳', '医师', '139', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0867', '杨稳', '医师', '11213', null, '');
INSERT INTO `t_doctor` VALUES ('0869', '于川东', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0880', '黄栋', '医师', '139', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0888', '徐启良', '主治医师', '11', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('0899', '孔德才', '医师', '14002', null, '');
INSERT INTO `t_doctor` VALUES ('0901', '董俊强', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0904', '张卫国', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0909', '杨依祚', '医师', '08', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('0946', '李进军', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0975', '袁玉国', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('0995', '张远浩', '医师', '139', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('10015', '赵蒙', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('10017', '王奇', '医师', '11211', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('10020', '盖红宇', '主治医师', '27', null, '门诊四楼西区');
INSERT INTO `t_doctor` VALUES ('10021', '朱耀华', '主治医师', '27', null, '门诊四楼西区');
INSERT INTO `t_doctor` VALUES ('10028', '王修军', '副主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('10029', '袁洪宇', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('10030', '马方明', '医师', '11013', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('10031', '赵海旺', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('10040', '乔保华', '主治医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('1008', '朱明涛', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1009', '石合现', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1012', '张平', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1017', '庞少存', '副主任医师', '1017', null, '');
INSERT INTO `t_doctor` VALUES ('1023', '赵新力', '主任医师', '1023', null, '');
INSERT INTO `t_doctor` VALUES ('1024', '赵锐利', '主任医师', '1024', null, '');
INSERT INTO `t_doctor` VALUES ('1063', '曹丹', '医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('1065', '王芳', '医师', '11511', null, '');
INSERT INTO `t_doctor` VALUES ('1071', '相龙占', '医师', '11211', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1072', '宋国华', '医师', '11213', null, '');
INSERT INTO `t_doctor` VALUES ('1073', '田素建', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1077', '刘成科', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1078', '任跃兵', '医师', '12', null, '');
INSERT INTO `t_doctor` VALUES ('1080', '李燕.', '医师', '17', null, '门诊三楼东区');
INSERT INTO `t_doctor` VALUES ('1085', '张艳丽`', '主治医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1092', '王茂峰', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1099', '叶永强', '主任医师', '11013', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1101', '陈贝健', '副主任医师', '1101', null, '');
INSERT INTO `t_doctor` VALUES ('1119', '冯斌', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1124', '冀海霞', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1125', '张友生', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1138', '周东升', '副主任医师', '22', null, '口腔综合楼一楼');
INSERT INTO `t_doctor` VALUES ('1147', '王新强', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1149', '胡斌', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1150', '付松涛', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1155', '徐权斌', '副主任医师', '11013', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1158', '张玲', '副主任医师', '1158', null, '');
INSERT INTO `t_doctor` VALUES ('1163', '刘月东', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1166', '李现军', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1167', '杨明明', '主治医师', '05', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('1169', '刘振', '主治医师', '12', null, '');
INSERT INTO `t_doctor` VALUES ('1171', '李巍', '主治医师', '01', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('1193', '吕春英', '副主任医师', '18', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('1196', '童宁', '主治医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1197', '于剑', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1198', '闫丽', '主治医师', '09', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('1199', '许超', '主治医师', '11212', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1200', '祁建军', '主治医师', '14001', null, '');
INSERT INTO `t_doctor` VALUES ('1203', '房振亚', '主治医师', '11503', null, '门诊三楼中区');
INSERT INTO `t_doctor` VALUES ('1207', '任师磊', '主治医师', '14001', null, '');
INSERT INTO `t_doctor` VALUES ('1209', '王洪波', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('12148', '司法鉴定所', '主任医师', '12148', null, '');
INSERT INTO `t_doctor` VALUES ('1215', '沈肖俐', '主治医师', '23', null, '门诊四楼西区');
INSERT INTO `t_doctor` VALUES ('12154', '闫越颖', '医师', '14008', null, '');
INSERT INTO `t_doctor` VALUES ('12158', '赵莹', '主治医师', '14008', null, '');
INSERT INTO `t_doctor` VALUES ('12159', '侯春红', '医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('1216', '苗卫华', '副主任医师', '11212', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('12162', '王明', '医师', '14002', null, '');
INSERT INTO `t_doctor` VALUES ('12163', '唐茜茜', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1217', '马彦超', '主治医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('1219', '牛军', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1220', '刘安城', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1221', '葛芙蓉', '主任医师', '15', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1222', '金勇军', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1223', '任建军', '主任医师', '14', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1228', '黄坤', '主治医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1231', '魏志新', '主任医师', '11012', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1235', '杨一涛', '副主任医师', '18', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('1236', '孙玉萍', '医师', '11511', null, '');
INSERT INTO `t_doctor` VALUES ('1253', '葛春花', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1254', '张博', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1255', '王广兴', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1256', '王玉美', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1257', '谢效平', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1258', '闵伟琪', '主任医师', '1258', null, '');
INSERT INTO `t_doctor` VALUES ('1261', '朱明', '主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1262', '葛方启', '副主任医师', '25', null, '感染楼一楼');
INSERT INTO `t_doctor` VALUES ('1263', '郭西文', '主任医师', '14', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1264', '马心健', '主任医师', '139', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1265', '沙启乐', '主任医师', '1265', null, '');
INSERT INTO `t_doctor` VALUES ('1266', '吴继海', '主任医师', '17', null, '门诊三楼东区');
INSERT INTO `t_doctor` VALUES ('1269', '王伯祥', '副主任医师', '11012', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1270', '吴付轩', '主任医师', '1270', null, '');
INSERT INTO `t_doctor` VALUES ('1271', '王超峰', '副主任医师', '1271', null, '');
INSERT INTO `t_doctor` VALUES ('1272', '张勇', '主任医师', '1272', null, '');
INSERT INTO `t_doctor` VALUES ('1273', '肖珍云', '主治医师', '11212', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1274', '于桂生', '主治医师', '1274', null, '');
INSERT INTO `t_doctor` VALUES ('1275', '朱明启', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1277', '冯松柏', '主治医师', '1277', null, '');
INSERT INTO `t_doctor` VALUES ('1278', '马艳丽', '副主任医师', '1278', null, '');
INSERT INTO `t_doctor` VALUES ('1279', '吴月丽', '主治医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('1288', '步国强', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1289', '于庆平', '副主任医师', '16', null, '门诊一楼西区');
INSERT INTO `t_doctor` VALUES ('1292', '张艳丽', '主治医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1293', '汤黎', '主治医师', '14006', null, '');
INSERT INTO `t_doctor` VALUES ('1294', '邹岩', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1298', '徐慧英', '医师', '29', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1299', '马宁', '主治医师', '14001', null, '');
INSERT INTO `t_doctor` VALUES ('1300', '徐瑞娥', '主治医师', '14001', null, '');
INSERT INTO `t_doctor` VALUES ('1301', '刘方', '医师', '24', null, '');
INSERT INTO `t_doctor` VALUES ('1304', '高佳', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1305', '毕琦', '医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1306', '李云', '主治医师', '14001', null, '');
INSERT INTO `t_doctor` VALUES ('1313', '孙卫强', '医师', '24', null, '');
INSERT INTO `t_doctor` VALUES ('1314', '刘颖', '主治医师', '08', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('1320', '李超', '主治医师', '16', null, '门诊一楼西区');
INSERT INTO `t_doctor` VALUES ('1323', '王培培', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1328', '孙明冲', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1340', '李玉文', '副主任医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1355', '张圣红', '主治医师', '11511', null, '');
INSERT INTO `t_doctor` VALUES ('1361', '颜安佩', '主任医师', '1361', null, '');
INSERT INTO `t_doctor` VALUES ('1362', '关建民', '副主任医师', '1362', null, '');
INSERT INTO `t_doctor` VALUES ('1363', '刘增福', '医师', '01', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('1364', '付景', '医师', '01', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('1369', '王浦', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1370', '李辉', '主治医师', '14002', null, '');
INSERT INTO `t_doctor` VALUES ('1374', '李康', '主治医师', '11212', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1375', '毛仲轩', '主治医师', '14002', null, '');
INSERT INTO `t_doctor` VALUES ('1390', '张文静', '医师', '14007', null, '');
INSERT INTO `t_doctor` VALUES ('1391', '张立生', '副主任医师', '22', null, '口腔综合楼一楼');
INSERT INTO `t_doctor` VALUES ('1395', '杨志国', '医师', '24', null, '');
INSERT INTO `t_doctor` VALUES ('1396', '孙晓妍', '医师', '14001', null, '');
INSERT INTO `t_doctor` VALUES ('1399', '田丽', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1400', '贾卉娟', '医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1410', '朱秀菊', '副主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1411', '于晗澍', '副主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1433', '赫俊会', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1438', '陶春蕾', '主治医师', '14006', null, '');
INSERT INTO `t_doctor` VALUES ('1450', '张清德', '副主任医师', '1450', null, '');
INSERT INTO `t_doctor` VALUES ('1451', '王奉淼', '主治医师', '14002', null, '');
INSERT INTO `t_doctor` VALUES ('1459', '戴馨', '副主任医师', '18', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('1462', '李红梅', '医师', '09', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('1485', '史东雷', '主治医师', '11211', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1556', '闫敬茹', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1562', '赵莹', '主治医师', '14008', null, '');
INSERT INTO `t_doctor` VALUES ('1566', '邓仰福', '主任医师', '23', null, '门诊四楼西区');
INSERT INTO `t_doctor` VALUES ('1581', '孔宪春', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1588', '梁宪坤', '主任医师', '1588', null, '');
INSERT INTO `t_doctor` VALUES ('1599', '王刚', '副主任医师', '1559', null, '');
INSERT INTO `t_doctor` VALUES ('1609', '郭彦平', '主治医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('1610', '高静', '护师', '6199', null, '');
INSERT INTO `t_doctor` VALUES ('1611', '李建', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1612', '刘翠英', '副主任医师', '18', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('1613', '张汉启', '主任医师', '29', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1614', '岳彩雷', '主任医师', '29', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1615', '吴本端', '主任医师', '29', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1616', '王雪英', '副主任医师', '29', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1617', '张本法', '副主任医师', '23', null, '门诊四楼西区');
INSERT INTO `t_doctor` VALUES ('1618', '王擎玉', '主任医师', '161', null, '');
INSERT INTO `t_doctor` VALUES ('1619', '袁兆阁', '主任医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1621', '张荣瑞', '副主任医师', '18', null, '门诊三楼西区');
INSERT INTO `t_doctor` VALUES ('1623', '韦福利', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1626', '侯晗', '副主任医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1639', '徐婉茹', '主治医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1646', '苗海平', '医师', '14007', null, '');
INSERT INTO `t_doctor` VALUES ('1655', '张建泽', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1659', '张巧芹', '医师', '11511', null, '');
INSERT INTO `t_doctor` VALUES ('1660', '吴景丽', '医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('1666', '王文红', '主治医师', '14006', null, '');
INSERT INTO `t_doctor` VALUES ('1667', '任晓燕', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1673', '沙晗', '医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('1675', '徐淑云', '医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('1680', '邹翠丽', '医师', '11511', null, '');
INSERT INTO `t_doctor` VALUES ('1682', '孙婷', '医师', '14005', null, '');
INSERT INTO `t_doctor` VALUES ('1716', '郭青', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1720', '程蕊', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1721', '刘会敏', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1723', '王星', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1728', '朱平', '医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('1729', '张勇华', '医师', '11511', null, '');
INSERT INTO `t_doctor` VALUES ('1818', '张伟', '主治医师', '23', null, '门诊四楼西区');
INSERT INTO `t_doctor` VALUES ('1839', '田静', '医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1850', '杜文丽', '医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1853', '陈艳坤', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1855', '赵昌学', '副主任医师', '139', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1856', '马波民', '副主任医师', '139', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('1872', '何晓翠', '医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('1906', '祝春青', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1907', '刘保兰', '医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('1908', '于春虎', '主任医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1909', '段宇鸿', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1914', '刘新林', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1915', '孔德木', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1924', '付影', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('1927', '楚超', '医师', '11213', null, '');
INSERT INTO `t_doctor` VALUES ('1928', '何银锋', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1929', '苏洪民', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1930', '王孝伟', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1933', '郑默然', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('1935', '李会丽', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2015', '刘合庆', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2016', '王兴光', '医师', '11212', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('2145', '妇门手术室', '主治医师', '11503', null, '门诊三楼中区');
INSERT INTO `t_doctor` VALUES ('2163', '袁家侃', '医师', '14007', null, '');
INSERT INTO `t_doctor` VALUES ('2167', '武海军', '副主任医师', '2167', null, '');
INSERT INTO `t_doctor` VALUES ('2207', '李赛', '医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('2208', '郭新明', '医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('2283', ' 于恒飞', '医师', '11211', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('2286', '范猛', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2287', '曾瑞莹', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2288', '沈明杰', '医师', '11211', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('2289', '郝磊', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2291', '袁丹丹', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2292', '李钧', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2295', '李慧艳', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2296', '刘艳', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2297', '刘磊', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2298', '蒋成', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2300', '高杰', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2316', '郝为民', '主任医师', '11213', null, '');
INSERT INTO `t_doctor` VALUES ('2317', '王芳芳', '医师', '14007', null, '');
INSERT INTO `t_doctor` VALUES ('2318', '王彪', '医师', '14007', null, '');
INSERT INTO `t_doctor` VALUES ('2355', '郭彦平', '医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('2551', '李娜', '医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('2622', '李庆民', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('2899', '吕恒翠', '副主任医师', '2899', null, '');
INSERT INTO `t_doctor` VALUES ('2900', '黄巧真', '医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('3501', '朱彤', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('4549', '刘风霞', '医师', '14007', null, '');
INSERT INTO `t_doctor` VALUES ('6001', '吴涛', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('6002', '韩哲', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('6255', '司世同', '主任医师', '6255', null, '');
INSERT INTO `t_doctor` VALUES ('6259', '李凯', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('6260', '胡凤利', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('6261', '杨宪章', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('6262', '焦仁才', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('6266', '刘印叶', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('6268', '李会会', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('6269', '王华旭', '医师', '87', null, '');
INSERT INTO `t_doctor` VALUES ('6302', '朱崇第', '主任医师', '6302', null, '');
INSERT INTO `t_doctor` VALUES ('6303', '朱传由', '主任医师', '6303', null, '');
INSERT INTO `t_doctor` VALUES ('6305', '孙玉琴', '主任医师', '6305', null, '');
INSERT INTO `t_doctor` VALUES ('6306', '王福臣', '主任医师', '6306', null, '');
INSERT INTO `t_doctor` VALUES ('6308', '李如玺', '主任医师', '166', null, '');
INSERT INTO `t_doctor` VALUES ('6309', '刘汉琪', '主任医师', '6309', null, '');
INSERT INTO `t_doctor` VALUES ('6313', '邹本章', '主任医师', '6313', null, '');
INSERT INTO `t_doctor` VALUES ('6317', '王兆允', '主任医师', '6317', null, '');
INSERT INTO `t_doctor` VALUES ('6322', '郑素芳', '主任医师', '6322', null, '');
INSERT INTO `t_doctor` VALUES ('6323', '李静', '主任医师', '6323', null, '');
INSERT INTO `t_doctor` VALUES ('6331', '陈树藩', '主任医师', '6331', null, '');
INSERT INTO `t_doctor` VALUES ('6332', '朱崇泉', '主任医师', '6332', null, '');
INSERT INTO `t_doctor` VALUES ('6334', '李玉萍', '主任医师', '6334', null, '');
INSERT INTO `t_doctor` VALUES ('6371', '王玉贞', '主任医师', '6371', null, '');
INSERT INTO `t_doctor` VALUES ('6382', '张顺道', '主任医师', '6382', null, '');
INSERT INTO `t_doctor` VALUES ('6658', '宋景元', '主任医师', '6658', null, '');
INSERT INTO `t_doctor` VALUES ('6666', '门办', '主治医师', '6666', null, '门诊一楼西区');
INSERT INTO `t_doctor` VALUES ('6699', '梁玉林', '医师', '14003', null, '');
INSERT INTO `t_doctor` VALUES ('6831', '王秀兰', '主任医师', '6831', null, '');
INSERT INTO `t_doctor` VALUES ('6866', '夏建胜', '主任医师', '6866', null, '');
INSERT INTO `t_doctor` VALUES ('6904', '小儿科', '主任医师', '19', null, '门诊二楼东区');
INSERT INTO `t_doctor` VALUES ('6907', '口腔科', '主任医师', '22', null, '口腔综合楼一楼');
INSERT INTO `t_doctor` VALUES ('9100', '风湿科', '主治医师', '09', null, '门诊二楼西区');
INSERT INTO `t_doctor` VALUES ('9214', '碎石中心', '主治医师', '90', null, '');
INSERT INTO `t_doctor` VALUES ('9258', '耿翠萍', '主治医师', '14001', null, '');
INSERT INTO `t_doctor` VALUES ('9278', '刘传安', '主治医师', '9278', null, '');
INSERT INTO `t_doctor` VALUES ('9300', '贤俊民.', '主治医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('9301', '袁建伟', '主治医师', '14002', null, '');
INSERT INTO `t_doctor` VALUES ('9334', '王富军', '主治医师', '13', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('9335', '马效雷', '主治医师', '14001', null, '');
INSERT INTO `t_doctor` VALUES ('9338', '杜晓丽', '医师', '14008', null, '');
INSERT INTO `t_doctor` VALUES ('9339', '李红梅妇', '医师', '11503', null, '门诊三楼中区');
INSERT INTO `t_doctor` VALUES ('9366', '刘晓燕', '医师', '14005', null, '');
INSERT INTO `t_doctor` VALUES ('9412', '刘志勇', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('9418', '唐立群', '副主任医师', '9418', null, '');
INSERT INTO `t_doctor` VALUES ('9419', '刘安成', '主治医师', '11211', null, '门诊一楼东区');
INSERT INTO `t_doctor` VALUES ('9421', '黄晓楠', '主治医师', '9421', null, '');
INSERT INTO `t_doctor` VALUES ('9555', '朱昕', '副主任医师', '9555', null, '');
INSERT INTO `t_doctor` VALUES ('9699', '程霖', '主任医师', '9699', null, '');
INSERT INTO `t_doctor` VALUES ('9706', '苗韶华', '主任医师', '26', null, '');
INSERT INTO `t_doctor` VALUES ('9710', '王金荣', '副主任医师', '9710', null, '');
INSERT INTO `t_doctor` VALUES ('9736', '刘莲秋', '副主任医师', '9736', null, '');
INSERT INTO `t_doctor` VALUES ('9737', '宋秀英', '副主任医师', '9737', null, '');
INSERT INTO `t_doctor` VALUES ('9738', '晁青', '副主任医师', '9738', null, '');
INSERT INTO `t_doctor` VALUES ('9739', '白汉生', '医师', '61', null, '');
INSERT INTO `t_doctor` VALUES ('9966', '吴保凡', '副主任医师', '9966', null, '');
INSERT INTO `t_doctor` VALUES ('9993', '刘新惠', '副主任医师', '9993', null, '');
INSERT INTO `t_doctor` VALUES ('9994', '李国庆', '医师', '07', null, '门诊二楼西区');

