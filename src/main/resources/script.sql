create table appraise
(
    itemId              char(50)     default ''                not null comment '主键'
        primary key,
    userId              char(50)     default ''                not null comment '评论者ID',
    multipleScore       double(2, 1)                           null comment '综合评分',
    matchScore          double(2, 1)                           null comment '描述相符',
    ratingTheInterviewe double(2, 1)                           null comment '对面试官的评分',
    environment         double(2, 1)                           null comment '公司环境评分',
    InterviewProcess    varchar(200) default ''                null comment '面试过程',
    dataId              char(50)     default ''                null comment '面试岗位Id',
    evaluationLabel1    varchar(15)  default ''                null comment '评价标签1',
    evaluationLabel2    varchar(15)  default ''                null comment '评价标签2',
    evaluationLabel3    varchar(15)  default ''                null comment '评价标签3',
    evaluationLabel4    varchar(15)  default ''                null comment '评价标签4',
    evaluationLabel5    varchar(15)  default ''                null comment '评价标签5',
    crateTime           timestamp    default CURRENT_TIMESTAMP null comment '创建时间'
)
    comment '评价表';

create table enterpriseinfo
(
    eId             char(50)     default '' not null comment '主键'
        primary key,
    logoImage       varchar(200) default '' not null comment '公司Logo',
    eName           varchar(50)  default '' not null comment '公司名称',
    ePlace          varchar(50)  default '' not null comment '公司地址',
    signLanguage    varchar(150) default '' not null comment '宣传语',
    eIntroducation  text                    null comment '公司介绍',
    financingStage  varchar(20)  default '' null comment '融资阶段',
    category        varchar(30)  default '' null comment '行业类别',
    eUrl            varchar(50)  default '' null comment '公司网站链接',
    eImage1         varchar(200) default '' null comment '公司环境介绍1',
    eImage2         varchar(200) default '' null comment '公司环境介绍2',
    eImage3         varchar(200) default '' null comment '公司环境介绍3',
    evaluationNum   int                     null comment '面试评价数量',
    positionNum     int                     null comment '在招职位数量',
    dealRate        double(2, 1)            null comment '简历处理率',
    benefit1        varchar(20)  default '' null comment '福利一',
    benefit2        varchar(20)  default '' null comment '福利二',
    benefit3        varchar(20)  default '' null comment '福利三',
    benefit4        varchar(20)  default '' null comment '福利四',
    benefit5        varchar(20)  default '' null comment '福利五',
    visitNum        int                     null comment '浏览次数',
    numberOfWorkers int                     null comment '员工人数'
)
    comment '企业信息表';

create table managementteam
(
    mIds            char(50)    default '' not null comment '主键'
        primary key,
    dataId          char(50)    default '' not null comment '父ID',
    mName           varchar(10) default '' not null comment '管理者名字',
    mIntroducation  text                   not null comment '管理者介绍',
    pMintroducation varchar(50) default '' not null comment '管理者职位描述'
)
    comment '企业管理团队表';

create table positioninfo
(
    pId         char(50)    default ''                not null comment '主键'
        primary key,
    dataId      char(50)    default ''                not null comment '父ID',
    reId        char(50)    default ''                not null comment '招聘者id',
    pTitle      varchar(20) default ''                null comment '职位名称',
    salary      varchar(20) default ''                null comment '薪资',
    experience  varchar(30) default ''                null comment '经验要求',
    place       varchar(30) default ''                null comment '工作地点',
    temptation  varchar(50) default ''                null comment '职位诱惑',
    description text                                  null comment '职位描述',
    departments varchar(50) default ''                null comment '所属部门',
    states      varchar(10) default ''                null comment '职位发布状态',
    postNature  varchar(10) default ''                null comment '职位的性质（全职/兼职/实习）',
    postType1   varchar(10) default ''                null comment '职位分类1',
    postType2   varchar(10) default ''                null comment '职位分类2',
    postType3   varchar(10) default ''                null comment '职位分类3',
    postType4   varchar(10) default ''                null comment '职位分类4',
    postType5   varchar(10) default ''                null comment '职位分类5',
    releaseTime timestamp   default CURRENT_TIMESTAMP null comment '发布时间',
    visitNum    int                                   null comment '浏览次数'
)
    comment '职位信息表';

create table recruiterinfor
(
    itemId      char(50)    default ''                not null comment '主键'
        primary key,
    dataId      char(50)    default ''                not null comment '公司的ID',
    userName    varchar(50) default ''                null comment '招聘者名字',
    password    varchar(40) default ''                null comment '密码',
    companyName varchar(50) default ''                null comment '公司名称',
    title       varchar(20) default ''                null comment '职位名称',
    createTime  timestamp   default CURRENT_TIMESTAMP null comment '创建时间'
)
    comment '招聘者信息表';

create table userinfo
(
    UserId            char(50)     default ''                not null comment '主键'
        primary key,
    email             varchar(50)  default ''                not null comment '邮箱（用作登录名）',
    password          varchar(50)  default ''                not null comment '密码',
    userName          varchar(50)  default ''                null comment '姓名',
    gender            varchar(50)  default ''                null comment '性别',
    birthday          timestamp                              null comment '生日',
    phone             varchar(20)  default ''                null comment '联系电话',
    jobHuntingStatus  varchar(20)  default ''                null comment '当前求职状态',
    identitys         varchar(20)  default ''                null comment '身份',
    heardImage        varchar(200) default ''                null comment '头像',
    personalAdvantage varchar(200) default ''                null comment '个人优势',
    itemCreateAt      timestamp    default CURRENT_TIMESTAMP null comment '创建时间'
)
    comment '用户信息表';


