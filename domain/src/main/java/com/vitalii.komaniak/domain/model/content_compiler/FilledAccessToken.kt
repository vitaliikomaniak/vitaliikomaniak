package com.vitalii.komaniak.domain.model.content_compiler


sealed class AccessToken {

    private fun willBeExpiredIn(time: Long): Boolean =
        this is EmptyAccessToken ||
                (this is FilledAccessToken && expireIn - System.currentTimeMillis() < time)

    fun willBeExpiredIn60seconds() = willBeExpiredIn(time = WILL_BE_EXPIRED_IN)

    fun isExpired() = willBeExpiredIn(time = 0)

    fun isEmpty() = this is EmptyAccessToken

    fun isCacheHashEmpty() = when (this) {
        is EmptyAccessToken -> true
        is FilledAccessToken -> cacheHash.isEmpty()
    }

    fun isAuthorised() = this is AuthAccessToken
    fun isUnAuthorised() = !isAuthorised()


    companion object {
        const val WILL_BE_EXPIRED_IN = 60_000L
    }
}

object EmptyAccessToken : AccessToken()

sealed class FilledAccessToken : AccessToken() {

    abstract val accessToken: String
    abstract val tokenType: String
    abstract val refreshToken: String
    abstract val expireIn: Long
    abstract val cacheHash: String

    abstract val entitlements: String

}

data class AuthAccessToken(

    override val accessToken: String,
    override val tokenType: String,
    override val refreshToken: String,
    override val expireIn: Long,
    override val cacheHash: String,

    override val entitlements: String,

    val userCacheHash: String, // only amc plus users

    val amcnAccountId: String?,

    val country: String?,

    val profileId: Int?,

    ) : FilledAccessToken()

data class UnAuthAccessToken(

    override val accessToken: String,
    override val tokenType: String,
    override val refreshToken: String,
    override val expireIn: Long,
    override val cacheHash: String,
    override val entitlements: String,

) : FilledAccessToken()