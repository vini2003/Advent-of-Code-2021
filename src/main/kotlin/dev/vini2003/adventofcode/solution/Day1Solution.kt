package dev.vini2003.adventofcode.solution

import java.net.URL

object Day1Solution : Solution(2021, 1, 5_000) {
	override fun solvePart1(input: URL): String {
		val lines = input.readText().trimEnd().lines().map(String::toInt)
		val count = (1 until lines.size).count { index -> lines[index] > lines[index - 1] }
		
		return "$count"
	}
	
	override fun solvePart2(input: URL): String {
		val lines = input.readText().trimEnd().lines().map(String::toInt).windowed(3) { it.sum() }
		val count = (1 until lines.size).count { index -> lines[index] > lines[index - 1] }
		
		return "$count"
	}
}