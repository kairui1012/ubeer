package com.rideshare.locationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DriverLocationRequest {
    private String driverId;
    private double latitude;
    private double longitude;
}
