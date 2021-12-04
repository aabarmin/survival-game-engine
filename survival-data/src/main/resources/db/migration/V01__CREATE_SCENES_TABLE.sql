create table SCENES
(
    SCENE_ID   INT auto_increment,
    SCENE_NAME CHARACTER(1024) not null,
    SCENE_TYPE CHARACTER(255) not null,
    constraint SCENES_PK
        primary key (SCENE_ID)
);
