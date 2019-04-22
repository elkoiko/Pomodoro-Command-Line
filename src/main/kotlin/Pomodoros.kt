package pomodoro

class Pomodoros(private val nbTasks: Int = 3, private val shortBreakPeriod: Int = 7) {

    // In minutes
    private val taskPeriod = 25
    private val longBreakPeriod = 25

    init {
        require(shortBreakPeriod < longBreakPeriod) {
            println("A short break cannot be longer than a long break. $shortBreakPeriod > $longBreakPeriod.")
        }
    }

    fun start() {
        println("Starting $nbTasks tasks - short break $shortBreakPeriod mins - long break $longBreakPeriod mins.")
        var i = 1

        while (i <= nbTasks) {
            waitFor(taskPeriod, "Task $i:")
            println("*** Et voila! Another task done! ***")
            readLine() // Waiting input for starting break
            if (i % 3 == 0)
                waitFor(longBreakPeriod, "Long break:")
            else
                waitFor(shortBreakPeriod, "Short break:")
            println("*** Break is over :) ***")
            readLine() // Waiting input for starting a new task
            i++
        }
    }

    private fun waitFor(period: Int, message: String) {
        for (secs in (period * 60) downTo 0) {
            print("\r$message ${secs / 60}m ${secs % 60}s remaining")
            Thread.sleep(1000)
        }
        println()
    }
}