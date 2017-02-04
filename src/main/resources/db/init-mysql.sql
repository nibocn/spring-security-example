DROP TABLE IF EXISTS USER_INFO;
DROP TABLE IF EXISTS ROLE;
DROP TABLE IF EXISTS RESOURCE;
DROP TABLE IF EXISTS ROLE_RESOURCE;


CREATE TABLE `USER_INFO` (
  `ID`        CHAR(32)     NOT NULL
  COMMENT ' 主键 ID',
  `USER_NAME` VARCHAR(100) NOT NULL,
  `PASSWORD`  VARCHAR(100) NOT NULL
  COMMENT ' 密码',
  PRIMARY KEY (`ID`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '用户信息';


/*==============================================================*/
/* Table: ROLE                                                  */
/*==============================================================*/
CREATE TABLE ROLE
(
  ID        CHAR(32)    NOT NULL
  COMMENT '主键ID',
  ROLE_NAME VARCHAR(30) NOT NULL
  COMMENT '角色名称',
  EDIT      TINYINT(1)  NOT NULL DEFAULT 1
  COMMENT '是否可编辑，0：否；1：是。默认为：1',
  REMARK    VARCHAR(100) COMMENT '备注',
  PRIMARY KEY (ID)
);

ALTER TABLE ROLE
  COMMENT '角色表';

/*==============================================================*/
/* Table: RESOURCE                                              */
/*==============================================================*/
CREATE TABLE RESOURCE
(
  ID            INT         NOT NULL AUTO_INCREMENT
  COMMENT '主键ID',
  PARENT_ID     INT COMMENT '父ID',
  RESOURCE_NAME VARCHAR(32) NOT NULL
  COMMENT '名称',
  PERMISSION    VARCHAR(50) COMMENT '访问许可标识',
  RESOURCE_TYPE TINYINT     NOT NULL DEFAULT 0
  COMMENT '类型，0：导航类；1：安全类；',
  IS_DEFAULT    BOOL        NOT NULL DEFAULT FALSE
  COMMENT '是否默认菜单、功能，true：默认，false：非默认',
  SORT          INT COMMENT '排序',
  ICON          VARCHAR(32) COMMENT '图标',
  REMARK        VARCHAR(256) COMMENT '备注',
  PRIMARY KEY (ID)
);

ALTER TABLE RESOURCE
  COMMENT '资源表';

/*==============================================================*/
/* Table: ROLE_RESOURCE                                         */
/*==============================================================*/
CREATE TABLE ROLE_RESOURCE
(
  ROLE_ID     CHAR(32) NOT NULL
  COMMENT '角色ID',
  RESOURCE_ID INT      NOT NULL
  COMMENT '资源ID',
  PRIMARY KEY (ROLE_ID, RESOURCE_ID)
);

ALTER TABLE ROLE_RESOURCE
  COMMENT '角色与资源关联表';