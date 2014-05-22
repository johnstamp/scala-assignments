import objsets._
object retweetsSheet {
  val a=new Tweet("johnstamp","look at this",20);
  val b = new Tweet("ronaldo","great goal",200);
  

abstract class TweetSet {
  def filter(p: Tweet => Boolean): TweetSet = ???
  

  
 	def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet={
 			if(p(this))acc.
 
 }
 }
 

}