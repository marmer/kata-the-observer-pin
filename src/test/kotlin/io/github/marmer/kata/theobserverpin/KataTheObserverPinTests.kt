package io.github.marmer.kata.theobserverpin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class KataTheObserverPinTests {

    @ParameterizedTest
    @CsvSource(
        value = [
            "1;1,2,4",
            "2;1,2,3,5",
            "3;2,3,6",
            "4;1,4,5,7",
            "5;2,4,5,6,8",
            "6;3,5,6,9",
            "7;4,7,8",
            "8;0,5,7,8,9",
            "9;6,8,9",
            "0;0,8",
        ], delimiter = ';'
    )
    fun shouldWorkForOneDigit(typedNumber: String, expectedResult: String) {
        assertEquals(expectedResult.split(","), getPINs(typedNumber))
    }

    @Test
    fun `empty input should serve empty result`() {
        val result = getPINs("")

        assertTrue(result.isEmpty()) { "result is empty" };
    }


    @Test
    fun `should serve all possible combinations for two digits`() {
        val result = getPINs("42")

        assertEquals(
            listOf(
                "11", "12", "13", "15",
                "41", "42", "43", "45",
                "51", "52", "53", "55",
                "71", "72", "73", "75"
            ), result
        )
    }

    @Test
    fun `should serve all possible combinations for three digits`() {
        val result = getPINs("342")

        assertEquals(
            listOf(
                "211", "212", "213", "215",
                "241", "242", "243", "245",
                "251", "252", "253", "255",
                "271", "272", "273", "275",

                "311", "312", "313", "315",
                "341", "342", "343", "345",
                "351", "352", "353", "355",
                "371", "372", "373", "375",

                "611", "612", "613", "615",
                "641", "642", "643", "645",
                "651", "652", "653", "655",
                "671", "672", "673", "675",
            ), result
        )
    }

    @Test
    fun `should serve all possible combinations for four digits`() {
        val result = getPINs("1342")

        assertEquals(
            listOf(
                "1211", "1212", "1213", "1215",
                "1241", "1242", "1243", "1245",
                "1251", "1252", "1253", "1255",
                "1271", "1272", "1273", "1275",

                "1311", "1312", "1313", "1315",
                "1341", "1342", "1343", "1345",
                "1351", "1352", "1353", "1355",
                "1371", "1372", "1373", "1375",

                "1611", "1612", "1613", "1615",
                "1641", "1642", "1643", "1645",
                "1651", "1652", "1653", "1655",
                "1671", "1672", "1673", "1675",

                "2211", "2212", "2213", "2215",
                "2241", "2242", "2243", "2245",
                "2251", "2252", "2253", "2255",
                "2271", "2272", "2273", "2275",

                "2311", "2312", "2313", "2315",
                "2341", "2342", "2343", "2345",
                "2351", "2352", "2353", "2355",
                "2371", "2372", "2373", "2375",

                "2611", "2612", "2613", "2615",
                "2641", "2642", "2643", "2645",
                "2651", "2652", "2653", "2655",
                "2671", "2672", "2673", "2675",

                "4211", "4212", "4213", "4215",
                "4241", "4242", "4243", "4245",
                "4251", "4252", "4253", "4255",
                "4271", "4272", "4273", "4275",

                "4311", "4312", "4313", "4315",
                "4341", "4342", "4343", "4345",
                "4351", "4352", "4353", "4355",
                "4371", "4372", "4373", "4375",

                "4611", "4612", "4613", "4615",
                "4641", "4642", "4643", "4645",
                "4651", "4652", "4653", "4655",
                "4671", "4672", "4673", "4675",
            ), result
        )
    }

}
