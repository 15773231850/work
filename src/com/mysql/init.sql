CREATE DATABASE IF NOT EXISTS cms
DEFAULT CHARSET utf8
COLLATE utf8_general_ci;
USE cms;
CREATE TABLE IF NOT EXISTS Application(
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,                 #自主增长
  serial_number          VARCHAR(36)    COMMENT          '申请流水号',
  type_certificate       VARCHAR(100)    COMMENT          '投保人证件类型' ,
  number_certificate        VARCHAR(100)    COMMENT        '投保人证件号码',
  date_application            VARCHAR(100)    COMMENT      '申请日期',
  loan_amount       VARCHAR(100)    COMMENT                '贷款金额（元）',
  insured_period       VARCHAR(100)    COMMENT             '投保期限(月)',
  repayment       VARCHAR(100)    COMMENT                  '还款方式',
  other_repayment       VARCHAR(100)    COMMENT            '其他还款方式名称',
  currency       VARCHAR(100)    COMMENT                   '币种',
  Lending_rates       VARCHAR(100)    COMMENT              '贷款利率（%）',
  insurance_amount       VARCHAR(100)    COMMENT           '保险金额（元）',
  loan_period       VARCHAR(100)    COMMENT                 '贷款期限（月）',
  detail         text            COMMENT                    '备注',
  created_time DATETIME NOT NULL COMMENT                   '贷款起始日期',
  updated_time DATETIME NOT NULL COMMENT                   '贷款到期日期',
  delete_status     tinyint  NOT NULL  COMMENT  '0：正常' COMMENT '1:删除'   #分类状态。0：正常；1：删除
);
 INSERT  Into

CREATE TABLE IF NOT EXISTS content_category (
id           BIGINT PRIMARY KEY AUTO_INCREMENT,                        #自主增长
  parent_id    BIGINT NOT NULL   COMMENT '外键',                #外键，父级内容分类id。取值0表示无父分类（根分类）
  name      VARCHAR(20)  NOT NULL COMMENT '分类名称',                #分类名称
  status     tinyint  NOT NULL  COMMENT  '0：正常' COMMENT '1:删除' ,  #分类状态。0：正常；1：删除
  order_number  int              COMMENT  '排序' ,                      #排序序号。值越小排序越靠前
  created_time DATETIME NOT NULL COMMENT  '创建时间',
  updated_time DATETIME NOT NULL COMMENT  '修改时间'
);

INSERT INTO content_category (parent_id,name ,status, order_number,created_time,updated_time) VALUES (
  "22",
  "donkuo",
  "0",
  "333",
  "2017-11-16 23:09:43",
  "2017-11-16 23:09:43"
);
 