create database comic;
use comic;


create table comic
(
    id           BIGINT auto_increment,
    image        varchar(200) null,
    name         varchar(50)  not null,
    author       varchar(50)  null comment '作者',
    `describe`   varchar(300) null comment '描述',
    release_date date         null comment '发布日期',
    state           int default 0     not null,
    create_time  datetime     not null,
    update_time  datetime     not null,
    constraint comic_pk
        primary key (id)
);


create table comic_volume
(
    id           bigint auto_increment,
    comic_id     bigint        not null,
    image        varchar(200) null,
    name         varchar(50)   null,
    state           int default 0     not null,
    order_number int           not null comment '序号',
    money        decimal       not null,
    release_date date          not null comment '发布时间',
    stock        int default 0 not null comment '库存',
    create_time  datetime      not null,
    update_time  datetime      not null,
    constraint comic_volume_pk
        primary key (id)
);

create table tag
(
    id   bigint auto_increment,
    name varchar(20) not null,
    constraint tag_pk
        primary key (id)
);

create table comic_tag
(
    id   bigint auto_increment,
    comic_id bigint null,
    tag_id   bigint null,
    constraint comic_tag_pk
        primary key (id)
);

create table comment
(
    id          bigint auto_increment,
    comic_id    bigint       not null,
    user_id     bigint       not null,
    content     varchar(300) not null comment '内容',
    create_time datetime     not null,
    constraint comment_pk
        primary key (id)
);

create table user
(
    id          bigint auto_increment,
    name        varchar(20)  not null,
    image       varchar(100) not null,
    account     varchar(15)  not null,
    password    varchar(15)  not null,
    create_time datetime     not null,
    update_time datetime     not null,
    constraint user_pk
        primary key (id)
);

create table detailed_user
(
    id          bigint auto_increment,
    user_id     bigint            not null,
    phone       char(11)          null,
    email       varchar(30)       null,
    money       decimal default 0 null,
    create_time datetime          not null,
    update_time datetime          not null,
    constraint detailed_user_pk
        primary key (id)
);


create table address_book
(
    id               bigint auto_increment,
    user_id          bigint        not null,
    `default`        int default 0 not null comment '是否默认 0否 1默认',
    phone            char(11)      not null,
    detailed_address varchar(100)  not null comment '详细地址',
    create_time      datetime      not null,
    update_time      datetime      not null,
    constraint address_book_pk
        primary key (id)
);

create table `order`
(
    id              bigint auto_increment,
    user_id         bigint        not null,
    order_number    char(32)      not null comment '订单号',
    state           int default 0 not null comment '状态 0处理中 1未支付 2已支付 3已发货 4已完成 5已取消',
    sum_money       datetime      not null,
    pay_time        datetime      not null,
    address_book_id bigint        not null,
    create_time     datetime      not null,
    update_time     datetime      not null,
    constraint order_pk
        primary key (id)
);

create table detailed_order
(
    id              bigint auto_increment,
    order_id        bigint   not null,
    comic_id        bigint   not null,
    comic_volume_id bigint   not null,
    number          int      not null comment '数量',
    money           decimal  not null comment '单价',
    price           decimal  not null comment '总价',
    create_time     datetime not null,
    update_time     datetime null,
    constraint detailed_order_pk
        primary key (id)
);






