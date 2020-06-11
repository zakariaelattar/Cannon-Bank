create table agency
(
    id_agency int auto_increment
        primary key,
    address   varchar(50) not null,
    country   varchar(50) not null,
    email     varchar(50) not null,
    fax       varchar(50) not null,
    name      varchar(50) not null,
    phone     varchar(50) not null
);

create table atm
(
    id_atm    int auto_increment
        primary key,
    address   varchar(50) not null,
    latitude  float       not null,
    longitude float       not null
);

create table banker
(
    id_banker    int auto_increment
        primary key,
    address      varchar(50) not null,
    birth_date   date        not null,
    email        varchar(50) not null,
    f_name       varchar(50) not null,
    joining_date date        not null,
    l_name       varchar(50) not null,
    phone        varchar(50) not null,
    id_agency    int         not null,
    constraint FK4lcler4g5s7bqcuw8lmdvo4uf
        foreign key (id_agency) references agency (id_agency)
);

create table category_account
(
    id_account  int auto_increment
        primary key,
    description varchar(50) not null,
    name        varchar(50) not null
);

create table account
(
    id_account     int         not null
        primary key,
    account_number int         not null,
    balance        float       not null,
    bic            varchar(50) not null,
    creation_date  date        not null,
    iban           varchar(50) not null,
    is_suspended   bit         not null,
    id_type        int         not null,
    id_client      int         not null,
    constraint FKmmaskmegyyurqt0kl6ddq3msn
        foreign key (id_type) references category_account (id_account)
);

create table category_cb
(
    id_cb       int auto_increment
        primary key,
    description varchar(50) not null,
    name        varchar(50) not null
);

create table category_cc
(
    id_card     int auto_increment
        primary key,
    description varchar(50) not null,
    name        varchar(50) not null
);

create table category_transaction
(
    id_transaction int auto_increment
        primary key,
    description    varchar(50) not null,
    name           varchar(50) not null
);

create table checkbook
(
    id_cb       int auto_increment
        primary key,
    is_finished bit not null,
    id_account  int not null,
    id_type     int not null,
    constraint FK16xvxaksc9w1y5bnfhlrglnqj
        foreign key (id_account) references account (id_account),
    constraint FKr9584nj2nwnmvjfel71t6a8fb
        foreign key (id_type) references category_cb (id_cb)
);

create table client
(
    id_client     bigint auto_increment
        primary key,
    adress        varchar(255) null,
    birth_date    datetime     null,
    email         varchar(255) null,
    fname         varchar(255) null,
    is_suspended  int          not null,
    joigning_date datetime     null,
    lname         varchar(255) null,
    phone         varchar(255) null,
    address       varchar(50)  not null,
    f_name        varchar(10)  not null,
    joining_date  date         not null,
    l_name        varchar(50)  not null,
    id_banker     int          not null,
    constraint FK2ndpo7yhawrpdmaeu7coe4m9k
        foreign key (id_banker) references banker (id_banker)
);

create table credit_card
(
    id_card      int auto_increment
        primary key,
    balance      double      not null,
    card_holder  varchar(50) not null,
    card_number  int         not null,
    cvv          int         not null,
    expires_date date        not null,
    id_account   int         not null,
    id_type      int         not null,
    constraint FKhm7mmvfryvdtws7wfi4b930x0
        foreign key (id_account) references account (id_account),
    constraint FKm6rdwd8itpqnx2mlwqojl422j
        foreign key (id_type) references category_cc (id_card)
);

create table location
(
    id_location int auto_increment
        primary key,
    latitude    float not null,
    longitude   float not null,
    id_agency   int   not null,
    constraint FKsyw4vwas8791tuc03kbwfbpvb
        foreign key (id_agency) references agency (id_agency)
);

create table login
(
    id_client int         not null
        primary key,
    email     varchar(50) not null,
    password  varchar(50) not null
);

create table request
(
    id_request int auto_increment
        primary key,
    date       date        not null,
    is_open    bit         not null,
    type       varchar(50) not null,
    id_type    int         not null,
    id_client  int         not null,
    constraint FKmdt2l3xet4x5uyts7rjcoviaf
        foreign key (id_type) references category_cc (id_card)
);

create table roles
(
    id   int auto_increment
        primary key,
    name varchar(20) null
);

create table support
(
    id_ticket int auto_increment
        primary key,
    country   varchar(50) not null,
    date      date        not null,
    email     varchar(50) not null,
    is_open   bit         not null,
    message   varchar(50) not null,
    name      varchar(50) not null,
    title     varchar(50) not null,
    id_client int         not null
);

create table transaction
(
    id_transaction int auto_increment
        primary key,
    amount         double not null,
    date           date   not null,
    old_balance_r  double not null,
    old_balance_s  double not null,
    id_r           int    not null,
    id_s           int    not null,
    id_type        int    not null,
    constraint FKj7ymjenpp1eslcc74lyfrmq2p
        foreign key (id_s) references account (id_account),
    constraint FKragrxt1wo5d5kmuetflf1fiwd
        foreign key (id_type) references transaction (id_transaction),
    constraint FKsi2rwe0sw1ihf8m5i7lw6y7mj
        foreign key (id_r) references account (id_account)
);

create table users
(
    id        bigint auto_increment
        primary key,
    email     varchar(50)  null,
    password  varchar(120) null,
    tenant_id varchar(120) null,
    username  varchar(20)  null,
    constraint UK6dotkott2kjsp8vw4d0m25fb7
        unique (email),
    constraint UKr43af9ap4edm43mmtq01oddj6
        unique (username)
);

create table user_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    constraint FKh8ciramu9cc9q3qcqiv4ue8a6
        foreign key (role_id) references roles (id),
    constraint FKhfh9dx7w3ubf1co1vdev94g3f
        foreign key (user_id) references users (id)
);

create view information_schema.ALL_PLUGINS as -- missing source code
;

create view information_schema.APPLICABLE_ROLES as -- missing source code
;

create view information_schema.CHARACTER_SETS as -- missing source code
;

create view information_schema.CHECK_CONSTRAINTS as -- missing source code
;

create view information_schema.CLIENT_STATISTICS as -- missing source code
;

create view information_schema.COLLATIONS as -- missing source code
;

create view information_schema.COLLATION_CHARACTER_SET_APPLICABILITY as -- missing source code
;

create view information_schema.COLUMNS as -- missing source code
;

create view information_schema.COLUMN_PRIVILEGES as -- missing source code
;

create view information_schema.ENABLED_ROLES as -- missing source code
;

create view information_schema.ENGINES as -- missing source code
;

create view information_schema.EVENTS as -- missing source code
;

create view information_schema.FILES as -- missing source code
;

create view information_schema.GEOMETRY_COLUMNS as -- missing source code
;

create view information_schema.GLOBAL_STATUS as -- missing source code
;

create view information_schema.GLOBAL_VARIABLES as -- missing source code
;

create view information_schema.INDEX_STATISTICS as -- missing source code
;

create view information_schema.INNODB_BUFFER_PAGE as -- missing source code
;

create view information_schema.INNODB_BUFFER_PAGE_LRU as -- missing source code
;

create view information_schema.INNODB_BUFFER_POOL_STATS as -- missing source code
;

create view information_schema.INNODB_CMP as -- missing source code
;

create view information_schema.INNODB_CMPMEM as -- missing source code
;

create view information_schema.INNODB_CMPMEM_RESET as -- missing source code
;

create view information_schema.INNODB_CMP_PER_INDEX as -- missing source code
;

create view information_schema.INNODB_CMP_PER_INDEX_RESET as -- missing source code
;

create view information_schema.INNODB_CMP_RESET as -- missing source code
;

create view information_schema.INNODB_FT_BEING_DELETED as -- missing source code
;

create view information_schema.INNODB_FT_CONFIG as -- missing source code
;

create view information_schema.INNODB_FT_DEFAULT_STOPWORD as -- missing source code
;

create view information_schema.INNODB_FT_DELETED as -- missing source code
;

create view information_schema.INNODB_FT_INDEX_CACHE as -- missing source code
;

create view information_schema.INNODB_FT_INDEX_TABLE as -- missing source code
;

create view information_schema.INNODB_LOCKS as -- missing source code
;

create view information_schema.INNODB_LOCK_WAITS as -- missing source code
;

create view information_schema.INNODB_METRICS as -- missing source code
;

create view information_schema.INNODB_MUTEXES as -- missing source code
;

create view information_schema.INNODB_SYS_COLUMNS as -- missing source code
;

create view information_schema.INNODB_SYS_DATAFILES as -- missing source code
;

create view information_schema.INNODB_SYS_FIELDS as -- missing source code
;

create view information_schema.INNODB_SYS_FOREIGN as -- missing source code
;

create view information_schema.INNODB_SYS_FOREIGN_COLS as -- missing source code
;

create view information_schema.INNODB_SYS_INDEXES as -- missing source code
;

create view information_schema.INNODB_SYS_SEMAPHORE_WAITS as -- missing source code
;

create view information_schema.INNODB_SYS_TABLES as -- missing source code
;

create view information_schema.INNODB_SYS_TABLESPACES as -- missing source code
;

create view information_schema.INNODB_SYS_TABLESTATS as -- missing source code
;

create view information_schema.INNODB_SYS_VIRTUAL as -- missing source code
;

create view information_schema.INNODB_TABLESPACES_ENCRYPTION as -- missing source code
;

create view information_schema.INNODB_TABLESPACES_SCRUBBING as -- missing source code
;

create view information_schema.INNODB_TRX as -- missing source code
;

create view information_schema.KEY_CACHES as -- missing source code
;

create view information_schema.KEY_COLUMN_USAGE as -- missing source code
;

create view information_schema.PARAMETERS as -- missing source code
;

create view information_schema.PARTITIONS as -- missing source code
;

create view information_schema.PLUGINS as -- missing source code
;

create view information_schema.PROCESSLIST as -- missing source code
;

create view information_schema.PROFILING as -- missing source code
;

create view information_schema.REFERENTIAL_CONSTRAINTS as -- missing source code
;

create view information_schema.ROUTINES as -- missing source code
;

create view information_schema.SCHEMATA as -- missing source code
;

create view information_schema.SCHEMA_PRIVILEGES as -- missing source code
;

create view information_schema.SESSION_STATUS as -- missing source code
;

create view information_schema.SESSION_VARIABLES as -- missing source code
;

create view information_schema.SPATIAL_REF_SYS as -- missing source code
;

create view information_schema.STATISTICS as -- missing source code
;

create view information_schema.SYSTEM_VARIABLES as -- missing source code
;

create view information_schema.TABLES as -- missing source code
;

create view information_schema.TABLESPACES as -- missing source code
;

create view information_schema.TABLE_CONSTRAINTS as -- missing source code
;

create view information_schema.TABLE_PRIVILEGES as -- missing source code
;

create view information_schema.TABLE_STATISTICS as -- missing source code
;

create view information_schema.TRIGGERS as -- missing source code
;

create view information_schema.USER_PRIVILEGES as -- missing source code
;

create view information_schema.USER_STATISTICS as -- missing source code
;

create view information_schema.VIEWS as -- missing source code
;

create view information_schema.user_variables as -- missing source code
;

