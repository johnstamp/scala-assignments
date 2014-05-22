import objsets._
object retweetsSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(89); 
  val a=new Tweet("johnstamp","look at this",20);System.out.println("""a  : objsets.Tweet = """ + $show(a ));$skip(49); ;
  val b = new Tweet("ronaldo","great goal",200);;System.out.println("""b  : objsets.Tweet = """ + $show(b ))}
  

abstract class TweetSet {
  def filter(p: Tweet => Boolean): TweetSet = ???
  

  
 	def filterAcc(p: Tweet => Boolean, acc: TweetSet): TweetSet={
 			if(p(this))acc.
 
 }
 }
 

}
