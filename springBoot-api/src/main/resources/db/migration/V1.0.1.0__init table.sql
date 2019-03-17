create table user_account
(
  id               VARCHAR(36) PRIMARY KEY,
  status           smallint                             not null,
  created_at       timestamp                            not null,
  updated_at       timestamp                            not null,
  auth_key         varchar(36)not null,
  first_name       varchar(255)not null,
  last_name        varchar(255)null,
  username         varchar(255)                         not null UNIQUE,
  password         varchar(100)                         not null,
  phone            varchar(255)                         null
);
