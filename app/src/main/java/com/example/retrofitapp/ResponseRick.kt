package com.example.retrofitapp

import com.google.gson.annotations.SerializedName

// Data class representing the response structure for the Rick and Morty API
data class ResponseRick(

	// List of character results from the API response
	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	// Information about the API response
	@field:SerializedName("info")
	val info: Info? = null
)

// Data class representing the location information
data class Location(

	// Name of the location
	@field:SerializedName("name")
	val name: String? = null,

	// URL of the location
	@field:SerializedName("url")
	val url: String? = null
)

// Data class representing information about the API response
data class Info(

	// URL for the next page of results
	@field:SerializedName("next")
	val next: String? = null,

	// Number of pages in the response
	@field:SerializedName("pages")
	val pages: Int? = null,

	// Placeholder for the previous page (not used)
	@field:SerializedName("prev")
	val prev: Any? = null,

	// Total count of characters in the response
	@field:SerializedName("count")
	val count: Int? = null
)

// Data class representing an individual character result
data class ResultsItem(

	// URL of the character's image
	@field:SerializedName("image")
	val image: String? = null,

	// Gender of the character
	@field:SerializedName("gender")
	val gender: String? = null,

	// Species of the character
	@field:SerializedName("species")
	val species: String? = null,

	// Timestamp of when the character was created
	@field:SerializedName("created")
	val created: String? = null,

	// Information about the character's origin
	@field:SerializedName("origin")
	val origin: Origin? = null,

	// Name of the character
	@field:SerializedName("name")
	val name: String? = null,

	// Information about the character's last known location
	@field:SerializedName("location")
	val location: Location? = null,

	// List of episode URLs in which the character appears
	@field:SerializedName("episode")
	val episode: List<String?>? = null,

	// Unique identifier for the character
	@field:SerializedName("id")
	val id: Int? = null,

	// Type of the character
	@field:SerializedName("type")
	val type: String? = null,

	// URL of the character's page on the API
	@field:SerializedName("url")
	val url: String? = null,

	// Status of the character (e.g., "Alive", "Dead", "unknown")
	@field:SerializedName("status")
	val status: String? = null
)

// Data class representing information about the character's origin
data class Origin(

	// Name of the origin
	@field:SerializedName("name")
	val name: String? = null,

	// URL of the origin
	@field:SerializedName("url")
	val url: String? = null
)
