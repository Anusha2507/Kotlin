import java.util.Scanner
import kotlin.math.absoluteValue

class BankAccount(val cname: String,val  cId: String) {
    constructor( cname: String, cId: String,cAccount:String):this(cname,cId){
       var account_type:String = cAccount
    }

    var balance: Float = 0F
    var customerName:String =cname
    var customerId:String = cId
    var account_type: String = ""
    var previousTransaction: Float = 0F

    var sc = Scanner(System.`in`)

    init {
        findMenu()
    }

    private fun createAccount(customerName: String, customerId: String) {
//        print("Enter ur name: ")
//        this.customerName=sc.nextLine()
//        println("Enter userId: ")
//        this.customerId=sc.nextLine()

        println("-------------------------------------------------------")
        println("Choose type of account u want \n 1.Current \n 2.Savings")
        account_type = sc.nextLine()
        println("Do u want to deposit initial amount? yes or no: ")
        var decision: String = sc.nextLine()
        if (decision == "yes") {
            println("Enter the amount to deposit: ")
            var amount: Float = sc.nextFloat()
            deposit_money(amount)
        } else {
            println("---------------------------------------------------")
            println("Thanks for choosing us")
        }
    }

    fun displayAccountDetails() {
        println("Customer Name: $customerName ")

        println("Customer Id : $customerId ")
        println("Account Type : $account_type")
        println("Balance : $balance")
    }

    fun deposit_money(amount: Float) {

        balance = balance add amount
        previousTransaction = amount
        println("Transaction successful & ur balance is $balance")
    }

    fun withdraw_money(amount: Float) {

        if (this.balance < amount) {
            println("Oops(: There is no sufficient balance & ur balance amount is $balance")
        } else {
            balance = balance sub amount
            previousTransaction = (-amount)
            println("successfully withdrawed amount & ur balance is $balance ")
        }
    }

    fun previousTransactionDetails() {

        if (previousTransaction > 0F) {
            println("Deposited amount : $previousTransaction")
        } else if (previousTransaction < 0F) {
            println("withdrawn amount : ${previousTransaction.absoluteValue}")
        } else {
            println("No Transaction processed")
        }
    }

    fun findMenu() {
        println("Welcome $customerName")
        println("Are you new to our serves?? yes or no")
        var newc = sc.nextLine()
        if (newc == "yes") {
            createAccount(customerName, customerId)
        }
        var option: Char = '-'
        println("A. Account Details ")
        println("B. Deposit Money")
        println("C. Withdraw Money")
        println("D. Transaction History")
        println("E. Exit ")
        do {
            println("-----------------------------------------------")
            println("Enter an Option :  ")
            option = sc.next().elementAt(0)
            when (option) {
                'A' -> {
                    displayAccountDetails()

                }
                'B' -> {
                    println("Enter the amount to deposit: ")
                    var amount = sc.nextFloat()
                    deposit_money(amount)
                }

                'C' -> {
                    println("Enter the amount to withdraw: ")
                    var amount = sc.nextFloat()
                    withdraw_money(amount)

                }
                'D' -> {
                    previousTransactionDetails()
                }
                'E' -> {
                    println("Thank you for choosing us... :)")
                    println("-----------------------------------------------")

                }
                else -> {
                    println("Invalid option....please enter correctly")

                }
            }
        } while (option != 'E')
    }
}
infix fun Float.add(b:Float):Float=this+b
infix fun Float.sub(b:Float):Float=this-b

fun main() {
    var user1 = BankAccount("Anusha", "1234")
}
