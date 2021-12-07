package dev.vini2003.adventofcode.solution

import java.net.URL
import kotlin.math.abs
import kotlin.math.max

object Day6Solution : Solution(2021, 6, 1) {
	val NumberRegex = "([0-9]+)".toRegex()
	
	override fun solvePart1(input: URL): String {
		val initialAges = NumberRegex.findAll(input.readText()).map(MatchResult::value).map(String::toInt)
		
		val ages = (0..8).associateWith { 0 }.toMutableMap()
		
		initialAges.forEach { age ->
			ages[age] = ages[age]!! + 1
		}
		
		for (d in 0..79) {
			val prevAge0 = ages[0]!!
			
			ages[0] = ages[1]!!
			ages[1] = ages[2]!!
			ages[2] = ages[3]!!
			ages[3] = ages[4]!!
			ages[4] = ages[5]!!
			ages[5] = ages[6]!!
			ages[6] = ages[7]!! + prevAge0
			ages[7] = ages[8]!!
			ages[8] = prevAge0
		}
		
		return "${ages.values.sum()}"
	}
	
	override fun solvePart2(input: URL): String {
		val initialAges = NumberRegex.findAll(input.readText()).map(MatchResult::value).map(String::toLong)
		
		val ages = (0L..8L).associateWith { 0L }.toMutableMap()
		
		initialAges.forEach { age ->
			ages[age] = ages[age]!! + 1L
		}
		
		for (d in 0L..255L) {
			val prevAge0 = ages[0]!!
			
			ages[0] = ages[1]!!
			ages[1] = ages[2]!!
			ages[2] = ages[3]!!
			ages[3] = ages[4]!!
			ages[4] = ages[5]!!
			ages[5] = ages[6]!!
			ages[6] = ages[7]!! + prevAge0
			ages[7] = ages[8]!!
			ages[8] = prevAge0
		}
		
		return "${ages.values.sum()}"
	}
}