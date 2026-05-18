CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(150),
    email VARCHAR(150),
    role VARCHAR(50),
);

CREATE TABLE IF NOT EXISTS ride (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    from_location VARCHAR(150) NOT NULL,
    to_location VARCHAR(150) NOT NULL,
    departure_time DATETIME,
    arrival_time DATETIME,
    max_passengers INT NOT NULL,
    current_passengers INT DEFAULT 0,
    status VARCHAR(50) DEFAULT 'OPEN',
    driver_id BIGINT,
    CONSTRAINT fk_driver FOREIGN KEY (driver_id) REFERENCES users(id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS ride_passengers (
    ride_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,

    PRIMARY KEY (ride_id, user_id),

    CONSTRAINT fk_ride
        FOREIGN KEY (ride_id)
        REFERENCES ride(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);