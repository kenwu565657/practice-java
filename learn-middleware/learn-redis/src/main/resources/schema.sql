create table `red_pocket_record` (
    `id` int(11) not null auto_increment,
    `user_id` int(11) not null,
    `red_packet` varchar(255),
    `total` int(11),
    `amount` decimal(10, 2),
    `is_active` tinyint(4) default '1',
    `create_time` datetime default null,
    primary key (`id`)
);

create table `red_pocket_detail` (
    `id` int(11) not null auto_increment,
    `record_id` int(11),
    `amount` decimal(8,2),
    `is_active` tinyint(4) default '1',
    `create_time` datetime default null,
    primary key (`id`)
);

create table `red_pocket_rob_record` (
    `id` int(11) not null auto_increment,
    `user_id` int(11) not null,
    `red_packet` varchar(255),
    `total` int(11),
    `amount` decimal(10, 2),
    `is_active` tinyint(4) default '1',
    `create_time` datetime default null,
    primary key (`id`)
)