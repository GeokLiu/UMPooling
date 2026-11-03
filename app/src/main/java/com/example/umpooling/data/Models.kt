package com.example.umpooling.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val id: String,
    val email: String,
    @SerialName("display_name")
    val displayName: String,
    val faculty: String,
    @SerialName("residential_area")
    val residentialArea: String,
    val role: String = "both",
    @SerialName("green_tier")
    val greenTier: String = "Bronze",
    @SerialName("total_co2_saved_kg")
    val totalCo2SavedKg: Double = 0.0,
    val rating: Double = 5.0
)

@Serializable
data class TripOffer(
    val id: String? = null,
    @SerialName("driver_id")
    val driverId: String,
    @SerialName("origin_zone")
    val originZone: String,
    @SerialName("destination_zone")
    val destinationZone: String,
    @SerialName("departure_time")
    val departureTime: String,
    @SerialName("total_seats")
    val totalSeats: Int,
    @SerialName("available_seats")
    val availableSeats: Int,
    @SerialName("cost_share_per_seat")
    val costSharePerSeat: Double,
    val status: String = "scheduled"
)

@Serializable
data class RideRequest(
    val id: String? = null,
    @SerialName("passenger_id")
    val passengerId: String,
    @SerialName("origin_zone")
    val originZone: String,
    @SerialName("destination_zone")
    val destinationZone: String,
    @SerialName("preferred_window_start")
    val preferredWindowStart: String,
    @SerialName("preferred_window_end")
    val preferredWindowEnd: String,
    @SerialName("requested_seats")
    val requestedSeats: Int = 1,
    @SerialName("parsed_from_nlp")
    val parsedFromNlp: Boolean = false,
    val status: String = "open"
)

@Serializable
data class ParsedRideNlp(
    @SerialName("origin_zone")
    val originZone: String,

    @SerialName("destination_zone")
    val destinationZone: String,

    @SerialName("departure_time")
    val departureTime: String,

    val seats: Int = 1
)