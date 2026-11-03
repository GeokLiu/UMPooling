package com.example.umpooling.repository

import com.example.umpooling.SupabaseClientProvider
import com.example.umpooling.data.ParsedRideNlp
import com.example.umpooling.data.TripOffer
import io.github.jan.supabase.functions.functions
import io.github.jan.supabase.postgrest.postgrest
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

class RideRepository {

    private val supabase = SupabaseClientProvider.client

    /**
     * Fetch all active trips from Supabase
     */
    suspend fun fetchActiveTrips(): List<TripOffer> {
        return supabase.postgrest["trip_offers"]
            .select()
            .decodeList<TripOffer>()
    }

    /**
     * Send user's natural-language ride request
     * to Supabase Edge Function powered by Gemini
     */
    suspend fun parseRideRequestWithAI(
        userPrompt: String
    ): ParsedRideNlp {

        val payload = buildJsonObject {
            put("prompt", userPrompt)
        }

        val response = supabase.functions.invoke(
            function = "parse-ride-request",
            body = payload
        )

        val jsonString = response.bodyAsText()

        return Json.decodeFromString<ParsedRideNlp>(
            jsonString
        )
    }
}