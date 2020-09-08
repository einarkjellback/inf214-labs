fun main() {
    fun send(amount: Double, from: Account, to: Account) {
        var first = from
        var second = to
        if (first.id > second.id) {
            first = to
            second = from
        }
        synchronized(first) {
            synchronized(second) {
                from.withdraw(amount)
                to.deposit(amount)
            }
        }
    }

}

private class Account(var balance: Double, var id: Int) {
    fun withdraw(amount: Double) {
        balance -= amount
    }

    fun deposit(amount: Double) {
        balance += amount
    }
}