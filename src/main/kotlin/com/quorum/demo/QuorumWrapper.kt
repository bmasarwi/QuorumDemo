package com.quorum.demo

import org.web3j.abi.FunctionEncoder
import org.web3j.abi.datatypes.Function
import org.web3j.protocol.admin.Admin
import org.web3j.protocol.core.methods.response.EthSendTransaction
import org.web3j.protocol.http.HttpService
import org.web3j.quorum.Quorum
import org.web3j.quorum.methods.request.PrivateTransaction
import java.lang.IllegalStateException
import java.math.BigInteger

class QuorumWrapper(private val accountKey: String,
                    private val nodeUrl: String,
                    private val httpService: HttpService = HttpService(nodeUrl),
                    private val web3j: Admin? = Admin.build(httpService),
                    private val quorum: Quorum? = Quorum.build(httpService)) {

    fun unlockAccount(accountKey: String) {
        val personalUnlockAccount = web3j?.personalUnlockAccount(accountKey, "")?.send()

        if (!personalUnlockAccount?.accountUnlocked()!!) {
            throw IllegalStateException("Failed to unlock account $accountKey")
        }
    }

    fun sendTransaction(func: Function,
                        nonce: BigInteger?,
                        contractAddress: String,
                        privateFrom: String?,
                        privateTo: List<String>?): EthSendTransaction? {

        val gasLimit = BigInteger.valueOf(1000000)
        return quorum?.ethSendTransaction(
                PrivateTransaction(
                        accountKey,
                        nonce,
                        gasLimit,
                        contractAddress,
                        BigInteger.ZERO,
                        FunctionEncoder.encode(func),
                        privateFrom,
                        privateTo
                ))?.send()
    }
}