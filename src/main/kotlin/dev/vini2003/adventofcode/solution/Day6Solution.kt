package dev.vini2003.adventofcode.solution

import java.net.URL
import kotlin.math.abs
import kotlin.math.max

object Day6Solution : Solution(2021, 6, 1) {
	val NumberRegex = "([0-9]+)".toRegex()
	
	class Population(line: String) {
		private val ages = (0L..8L).associateWith { 0L }.toMutableMap()
		
		init {
			NumberRegex.findAll(line).map(MatchResult::value).map(String::toLong).forEach { age ->
				ages[age] = ages[age]!! + 1
			}
			
		}
		
		fun simulate(days: Int) {
			for (d in 0 until days) {
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
		}
		
		fun total(): Long {
			return ages.values.sum()
		}
	}
	
	override fun solvePart1(input: URL): String {
		val population = Population(input.readText())
		
		population.simulate(80)
		
		return "${population.total()}"
	}
	
	override fun solvePart2(input: URL): String {
		val population = Population(input.readText())
		
		population.simulate(256)
		
		return "${population.total()}"
	}
}