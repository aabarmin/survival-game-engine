create table SCENE_LAYERS
(
    LAYER_ID int auto_increment,
    LAYER_TYPE character(255) not null,
    SCENE_ID int not null,
    LAYER_FILE_TYPE character(255) not null,
    LAYER_FILE_NAME character(255) not null,
    constraint SCENE_LAYERS_PK
        primary key (LAYER_ID)
);