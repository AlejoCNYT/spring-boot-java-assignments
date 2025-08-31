create table users(
                      id uuid primary key,
                      name varchar(100),
                      email varchar(120) unique not null,
                      password_hash varchar(200) not null,
                      role varchar(20) not null
);

create table material(
                         id uuid primary key,
                         name varchar(80) unique not null,
                         eco_points_factor numeric not null
);

create table product(
                        id uuid primary key,
                        ean varchar(32) unique not null,
                        name varchar(160),
                        material_id uuid not null references material(id),
                        how_to_dispose varchar(200)
);

create table pickup(
                       id uuid primary key,
                       citizen_id uuid not null references users(id),
                       collector_id uuid references users(id),
                       address varchar(200),
                       lat numeric, lng numeric,
                       scheduled_at timestamptz,
                       status varchar(20) not null
);
create index idx_pickup_scheduled on pickup(scheduled_at);

create table pickup_item(
                            id uuid primary key,
                            pickup_id uuid not null references pickup(id),
                            material_id uuid not null references material(id),
                            weight_kg numeric not null,
                            quality varchar(20) not null
);

create table points_ledger(
                              id uuid primary key,
                              user_id uuid not null references users(id),
                              pickup_id uuid references pickup(id),
                              delta_points int not null,
                              reason varchar(60),
                              created_at timestamptz not null default now()
);
