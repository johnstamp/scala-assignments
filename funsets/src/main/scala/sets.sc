package funsets
import FunSets._
object sets {
  println("Welcome to the Scala worksheet")

type Set = Int => Boolean
def singletonSet(elem: Int): Set = 	set => set ==elem
def union(s: Set, t: Set): Set =
	(i:Int) => s(i) || t(i)
	def diff(s: Set, t: Set): Set = (i:Int) => !s(i) && t(i)
	def contains(s: Set, elem: Int): Boolean = s(elem)

///def intersect(a: Set, b: Set): Set = i => a(i) && b(i)

//def minus(a: Set, b: Set): Set = (i:Int) => a(i) && !b(i)
 //def intersect(s: Set, t: Set): Set = i=> s(i) & t(i)

//val a=singletonSet(3)

//val b=singletonSet(4)

////union(a,b)


//val isEven : Set = _%2 == 0

//isEven(4)
//isEven(5)

 val a = singletonSet(1)
  val b = singletonSet(2)
 val c = singletonSet(3)
  val f = singletonSet(4)
      val d=union(a,b);
      val e = union(b,c)
      val difference=diff(d,e)
        difference.toString
       assert(contains(difference,3), "f contains c")
       
  val bound = 1000
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a<(-bound)) true //its in the sett
      else if (contains(s,a) && !p(a)) false
      else iter(a-1)
    }
    iter(bound)
  }
  
      val forAllSet=union(union(a,b),union(c,f))
    		 forall(forAllSet, _<4)
    		 
   def exists(s: Set, p: Int => Boolean): Boolean = !forall(s,(x => !p(x)))
   
  
   exists(forAllSet, _>4)
   
   //def map(s: Set, f: Int => Int): Set = (a: Int)=> s(a)==a
 // def map(s: Set, f: Int => Int): Set = (e:Int) => exists(s, (x => f(x) == e))
   
     def map(s: Set, f: Int => Int): Set =
     {
     	elem:Int =>bool
     }



  // def map(s: Set, f: Int => Int): Set = { elem:Int => exists(s, {elem2:Int => f(elem2) == elem}) }
   
  val returnedSet= map(forAllSet,_* 2)
	
	printSet(forAllSet)
 	printSet(returnedSet)
}