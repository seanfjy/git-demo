CREATE TABLE `article`
(
    `id`          int(11) not null auto_increment comment '主键',
    `user_id`     int(11) not null comment '作者 ID',
    `title`       varchar(100) not null comment '文章标题',
    `summary`     varchar(200) default null comment '文章概要',
    `read_count`  int(11) unsigned zerofill not null comment '阅读读数',
    `crate_time`  datetime     not null comment '创建时间',
    `update_time` datetime     not null comment '最后修改时间',
    primary key (id)
) ENGINE = InnoDB
    auto_increment =1
    default charset = utf8mb4;