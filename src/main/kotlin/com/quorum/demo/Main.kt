package com.quorum.demo

import org.web3j.abi.TypeReference
import org.web3j.abi.datatypes.Function
import org.web3j.abi.datatypes.Int
import java.math.BigInteger

fun main() {

    val nonce1 = BigInteger.valueOf(11)
    val func1 = Function("inc", emptyList(), emptyList())
    val quorumWrapper1 = QuorumWrapper(accountKey = ACCOUNT1_KEY, nodeUrl = NODE1_URL)

    quorumWrapper1.unlockAccount(ACCOUNT1_KEY)
    val res1 = quorumWrapper1.sendTransaction(
            func1,
            nonce1,
            CONTRACT_ADDRESS,
            NODE1_PUBK,
            listOf(NODE2_PUBK))


    if (res1!!.error != null)
        println("QUERY ERROR: ${res1.error.message}")
    else
        println("HASH: ${res1.result}")


    val quorumWrapper2 = QuorumWrapper(accountKey = ACCOUNT2_KEY, nodeUrl = NODE2_URL)
    val func2 = Function("getCount", emptyList(), listOf(object : TypeReference<Int>(){}))


    quorumWrapper2.unlockAccount(ACCOUNT2_KEY)
    val res2 = quorumWrapper2.sendTransaction(
            func2,
            nonce1.add(BigInteger.ONE),
            CONTRACT_ADDRESS,
            NODE2_PUBK,
            listOf(NODE1_PUBK))


    if (res2!!.error != null)
        println("QUERY ERROR: ${res2.error.message}")
    else
        println("HASH: ${res2.result}")
}