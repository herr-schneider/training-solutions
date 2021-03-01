USE `activitytracker`;
CREATE TABLE activities (id BIGINT AUTO_INCREMENT,
                         start_time TIMESTAMP,
                         activity_desc VARCHAR(255),
                         activity_type VARCHAR(255),
                         PRIMARY KEY (id));

CREATE TABLE track_points(id BIGINT AUTO_INCREMENT,
									act_time DATE,
									lat DOUBLE,
									lon DOUBLE,
									activityID BIGINT,
									PRIMARY KEY(id),
									FOREIGN KEY (activityID) REFERENCES activities(id));
