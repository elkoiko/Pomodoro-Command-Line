package pomodoro

fun main() {
    val tasks: Pomodoros = askUser()
    tasks.start()
    println("Congratulations! You've accomplished everything you wanted!")
}

fun askUser(): Pomodoros {
    println("Do you want the default choices ? Short break: 7 mins - Tasks: 3 Y/N")
    val defaultChoice = readLine().equals("y", true)
    return if (defaultChoice) {
        Pomodoros()
    } else {
        println("How many tasks do you want to accomplish ?")
        val nbTasks: Int = try { readLine()!!.toInt() } catch (e: NumberFormatException) { 3 }
        println("How long do you want your short break to be ?")
        val shortBreakPeriod: Int = try { readLine()!!.toInt() } catch (e: NumberFormatException) { 7 }
        Pomodoros(nbTasks, shortBreakPeriod)
    }
}
