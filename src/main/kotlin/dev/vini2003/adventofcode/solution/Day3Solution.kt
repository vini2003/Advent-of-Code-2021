package dev.vini2003.adventofcode.solution

import java.net.URL



object Day3Solution : Solution(2021, 3, 1) {
	data class Frequency(var `0`: Int = 0, var `1`: Int = 0) {
		fun common() = if (`0` > `1`) "0" else "1"
		fun uncommon() = if (`0` < `1`) "0" else "1"
	}
	
	override fun solvePart1(input: URL): String {
		val lines = input.readText().trimEnd().lines()
		
		val frequencies = Array(12) { Frequency() }
		
		lines.forEach { line ->
			line.forEachIndexed { i, c ->
				when (c) {
					'0' -> frequencies[i].`0` += 1
					'1' -> frequencies[i].`1` += 1
				}
			}
		}
		
		val gamma = frequencies.joinToString("", transform = Frequency::common).toInt(2)
		val epsilon = frequencies.joinToString("", transform = Frequency::uncommon).toInt(2)
		
		return "${gamma * epsilon}"
	}
	
	fun findCommon(d: Int, lines: List<String>): Char? {
		var `0` = 0
		var `1` = 0
		
		for (line in lines) {
			when (line[d]) {
				'0' -> ++`0`
				'1' -> ++`1`
			}
		}
		
		return if (`0` > `1`) '0' else if (`1` > `0`) '1' else null
	}
	
	fun findUncommon(d: Int, lines: List<String>): Char? {
		var `0` = 0
		var `1` = 0
		
		for (line in lines) {
			when (line[d]) {
				'0' -> ++`0`
				'1' -> ++`1`
			}
		}
		
		return if (`0` > `1`) '1' else if (`1` > `0`) '0' else null
	}
	
	override fun solvePart2(input: URL): String {
		val lines = input.readText().trimEnd().lines()
		
		var oxygen = lines.toList()
		
		for (i in 0..11) {
			val common = findCommon(i, oxygen)
			val uncommon = findUncommon(i, oxygen)
			
			if (oxygen.size == 1) {
				break
			}
			
			oxygen = oxygen.filter { line ->
				if (common == uncommon) {
					line[i] == '1'
				} else {
					line[i] == common
				}
			}
		}
		
		var carbonDioxide = lines.toList()
		
		for (i in 0..11) {
			val common = findCommon(i, carbonDioxide)
			val uncommon = findUncommon(i, carbonDioxide)
			
			if (carbonDioxide.size == 1) {
				break
			}
			
			carbonDioxide = carbonDioxide.filter { line ->
				if (common == uncommon) {
					line[i] == '0'
				} else {
					line[i] == uncommon
				}
			}
		}
		
		val lifeSupport = oxygen.first().toInt(2) * carbonDioxide.first().toInt(2)
		
		return "${lifeSupport}"
	}
}