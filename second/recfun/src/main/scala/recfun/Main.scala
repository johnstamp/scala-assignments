package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Pascal's Triangle. Recursive call to method
   * end the recursion when hit top of trinagle or
   * the sides
   * @author John Stamp
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == r || r <= 0 || c <= 0)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Store the Parentheses in a list. As closing tags for open tags appear
   * drop them from the list. when you reach end of the input list then
   * then parentheses list should be empty too.
   * @author John Stamp
   */
  def balance(chars: List[Char]): Boolean = {

    def balanceIter(chars: List[Char], parentheses: List[Char]): Boolean = {
      if (chars.isEmpty) throw new java.util.NoSuchElementException()

      else if (chars.tail.isEmpty) {
        if (chars.head == '(' || (chars.head == ')' && parentheses.isEmpty)) false
        else if (chars.head == ')' && (parentheses.head == '(' && parentheses.tail.isEmpty)) true
        else if (parentheses.isEmpty) true
        else false
      } else if ((chars.head) == '(') {
        balanceIter(chars.tail, parentheses :+ chars.head)
      } else if (chars.head == ')')
        (!parentheses.isEmpty) && balanceIter(chars.tail, parentheses.tail)

      else
        balanceIter(chars.tail, parentheses)
    }

    balanceIter(chars, "".toList);

  }

  /**
   * Counting permutations of change from a list of coins and amount of money
   * @author John Stamp
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def calculateChange(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty) return 0
      else if (money <= 0) 1
      else if (money < coins.head)
        if (!coins.tail.isEmpty)
          calculateChange(money, coins.tail)
        else 0
      else {
        if (!coins.tail.isEmpty)
          calculateChange(money, coins.tail) + calculateChange(money - coins.head, coins)
        else calculateChange(money - coins.head, coins)
      }
    }
    calculateChange(money, coins);
  }

}
