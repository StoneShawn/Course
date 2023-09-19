package com.shawn.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkCourse(
    val successCriteria : SuccessCriteria,
    val numSoldTickets: Int,
    val status: String,
    val proposalDueTime: String,
    val coverImageUrl: String,
    val title: String,
    val savedStatus: String,
    val coin : Int
)

@Serializable
data class SuccessCriteria(
    val numSoldTickets: Int
)