package dev.vini2003.adventofcode.solution.year_2021

import dev.vini2003.adventofcode.solution.Solution
import java.net.URL

object Day1Solution : Solution(1, 1) {
	override fun solvePart1(input: URL): String {
		val lines = input.readText().lines().dropLast(1).map(String::toInt)
		val count = (1 until lines.size).count { index -> lines[index] > lines[index - 1] }
		
		return "$count"
	}
	
	override fun solvePart2(input: URL): String {
		val lines = input.readText().lines().dropLast(1).map(String::toInt).windowed(3) { it.sum() }
		val count = (1 until lines.size).count { index -> lines[index] > lines[index - 1] }
		
		return "$count"
	}
}