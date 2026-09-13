package com.rideshare.locationservice.service;

import com.rideshare.locationservice.dto.DriverLocationRequest;
import com.rideshare.locationservice.dto.NearByDriverResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
@Slf4j

public class LocationService {

    private final RedisTemplate<String,String> redisTemplate;

    // Redis key for all driver locations
    private static final String DRIVERS_GEO_KEY = "drivers:locations";

    /**
     * update driver location in redis
     * called every 3 second by driver phone
     * map to redis GEOADD command
     * @param driverLocationRequest
     */
    public void updateDriverLocation(DriverLocationRequest driverLocationRequest) {
        log.info("Updating location for driver: {}", driverLocationRequest.getDriverId());

        // Important: longitude FIRST, latitude SECOND - GeoSpatial Standard
        Point driverPoint = new Point(
            driverLocationRequest.getLongitude(),
            driverLocationRequest.getLatitude()
        );

        redisTemplate.opsForGeo().add(
                DRIVERS_GEO_KEY,
                driverPoint,
                driverLocationRequest.getDriverId());
        log.info("Location updated for driver: {}", driverLocationRequest.getDriverId());
    }


    /**
     * Find nearby drivers within given radius.
     * Called by Matching Service on ride request.
     * Maps to Redis GEORADIUS command.
     */
    public List<NearByDriverResponse> findByDrivers(double latitude, double longitude, double radiusInKm) {
        log.info("Finding drivers near lat: {} long: {} withing {}Km",
                latitude, longitude, radiusInKm);
        
    }

    public void removeDriver(String driverID) {

    }


}
