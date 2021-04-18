create table careerObjective
(
    Id                   char(50)    default '' not null comment '主键' primary key,
    dataId               char(50)    default '' not null comment '数据源',
    position             varchar(50) default '' comment '期待职位',
    city                 varchar(50) default '' comment '期待城市',
    starting_salary_from varchar(50) default '' comment '期待起薪from',
    starting_salary_to   varchar(50) default '' comment '期待起薪to'
)
    comment '求职意向表';



create table EducationalExperience
(
    Id                 char(50)    default '' not null comment '主键' primary key,
    dataId             char(50)    default '' not null comment '数据源',
    schoolName         varchar(50) default '' comment '学校名称',
    professional_title varchar(50) default '' comment '专业名称',
    education          varchar(50) default '' comment '学历',
    graduation_time    timestamp comment '毕业时间'
)
    comment '教育经历表';



create table work_experience
(
    Id               char(50)    default '' not null comment '主键' primary key,
    dataId           char(50)    default '' not null comment '数据源',
    companyName      varchar(50) default '' comment '公司名称',
    company_industry varchar(50) default '' comment '公司行业',
    department       varchar(50) default '' comment '所属部门',
    tybe_of_job      varchar(50) default '' comment '职位类型',
    position_Name    varchar(50) default '' comment '职位名称',
    operating_hours  varchar(50) default '' comment '工作时间'
)
    comment '工作经历表';
