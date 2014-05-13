package funsets

object sets {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

type Set = Int => Boolean
def singletonSet(elem: Int): Set = 	set => set ==elem
                                                  //> singletonSet: (elem: Int)Int => Boolean
def union(s: Set, t: Set): Set =
	(i:Int) => s(i) || t(i)                   //> union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
	def diff(s: Set, t: Set): Set = (i:Int) => !s(i) && t(i)
                                                  //> diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
	def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean

///def intersect(a: Set, b: Set): Set = i => a(i) && b(i)

//def minus(a: Set, b: Set): Set = (i:Int) => a(i) && !b(i)
 //def intersect(s: Set, t: Set): Set = i=> s(i) & t(i)

//val a=singletonSet(3)

//val b=singletonSet(4)

////union(a,b)


//val isEven : Set = _%2 == 0

//isEven(4)
//isEven(5)

 val a = singletonSet(1)                          //> a  : Int => Boolean = <function1>
  val b = singletonSet(2)                         //> b  : Int => Boolean = <function1>
 val c = singletonSet(3)                          //> c  : Int => Boolean = <function1>
      val d=union(a,b);                           //> d  : Int => Boolean = <function1>
      val e = union(b,c)                          //> e  : Int => Boolean = <function1>
      val difference=diff(d,e)                    //> difference  : Int => Boolean = <function1>
        difference.toString                       //> res0: String = <function1>
       assert(contains(difference,3), "f contains c")
}