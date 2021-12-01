import com.github.ajalt.mordant.terminal.Terminal
import dev.vini2003.adventofcode.solution.Solution
import dev.vini2003.adventofcode.util.SolutionUtils

val terminal = Terminal()

fun main(args: Array<String>) {
	SolutionUtils.Solutions.forEach(Solution::solve)
}