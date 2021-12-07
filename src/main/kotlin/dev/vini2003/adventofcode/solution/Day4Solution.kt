package dev.vini2003.adventofcode.solution

import java.net.URL

object Day4Solution : Solution(2021, 4, 1) {
	val NumberRegex = "([0-9]+)".toRegex()
	
	data class Entry(var value: Int, var marked: Boolean = false) {
		fun update(number: Int) {
			if (number == value) marked = true
		}
	}
	
	data class Board(var lines: List<String>) {
		private val m: List<List<Entry>> = List(5) { l ->
			NumberRegex.findAll(lines[l]).map(MatchResult::value).map(String::toInt).map(::Entry).toList()
		}
		
		private fun hasRow(): Boolean {
			return (0..4).any { row ->
				(0..4).all { column ->
					m[row][column].marked
				}
			}
		}
		
		private fun hasColumn(): Boolean {
			return (0..4).any { column ->
				(0..4).all { row ->
					m[row][column].marked
				}
			}
		}
		
		fun sumUnmarked(): Int {
			return m.flatten().filter { entry -> !entry.marked }.sumOf { entry -> entry.value }
		}
		
		fun isWinner() = hasRow() || hasColumn()
		
		fun update(number: Int) {
			m.flatten().forEach { entry -> entry.update(number) }
		}
	}
	
	override fun solvePart1(input: URL): String {
		val lines = input.readText().trimEnd().lines().filter(String::isNotEmpty)
		
		val numbers = NumberRegex.findAll(lines[0]).map(MatchResult::value).map(String::toInt).toList()
		
		val boards = lines.drop(1).windowed(5, 5).map(::Board)
		
		val winners = mutableListOf<Pair<Int, Board>>()
		
		for (number in numbers) {
			boards.forEach { board ->
				if (!board.isWinner()) {
					board.update(number)
					
					if (board.isWinner()) {
						winners += number to board
					}
				}
			}
		}
		
		val (number, board) = winners.first()
		
		return "${board.sumUnmarked() * number}"
	}
	
	override fun solvePart2(input: URL): String {
		val lines = input.readText().trimEnd().lines().filter(String::isNotEmpty)
		
		val numbers = NumberRegex.findAll(lines[0]).map(MatchResult::value).map(String::toInt).toList()
		
		val boards = lines.drop(1).windowed(5, 5).map(::Board)

		val winners = mutableListOf<Pair<Int, Board>>()
		
		for (number in numbers) {
			boards.forEach { board ->
				if (!board.isWinner()) {
					board.update(number)
		
					if (board.isWinner()) {
						winners += number to board
					}
				}
			}
		}
		
		val (number, board) = winners.last()
		
		return "${board.sumUnmarked() * number}"
	}
}