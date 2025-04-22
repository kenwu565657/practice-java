create table `praise` (
    `id` int(11) not null auto_increment comment 'primary key',
    `blog_id` int(11) not null,
    `user_id` int(11) not null,
    `praise_time` datetime default null,
    `status` int(11) default '1',
    `is_active` int(11) default '1',
    `create_time` datetime default null,
    `update_time` timestamp null default null,
    PRIMARY KEY (`id`)
) Engine=InnoDB Default charset=utf8mb4;