package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(4)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
 // ignore("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
 // }	

  //ignore("union contains all elements") {
     test("Testing the union method") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
   test("Testing the difference method") {
    new TestSets { 
      val a = singletonSet(1) 
      val b = singletonSet(2) 
      val c = singletonSet(3) 
      val d=union(a,b);
      val e = union(b,c)
      val difference=diff(d,e)
      assert(contains(difference,1),"differnce contains 1")
      
    }
   }
    test("Testing the intersect method") {
    new TestSets { 
      val a = singletonSet(1) 
      val b = singletonSet(2) 
      val c = singletonSet(3) 
      val d=union(a,b);
      val e = union(b,c)
      val unionVal=intersect(d,e)
      assert(contains(unionVal,2),"intersect contains 2")
      
    }
   }
    test("Testing the filter method") {
    new TestSets { 
      val a = singletonSet(1) 
      val b = singletonSet(2) 
      val c = singletonSet(3) 
      val d = singletonSet(-1)
      
      val x= union(a,b)
      val y= union(c,d)
      
      val f = filter(y, x => (x > 0)) 
 
      assert(contains(f,3), "f contains 3") 
      assert(!contains(f,-1), "f doesnt contain -1") 
    }
    }
     test("Testing the for all method") {
    new TestSets { 
      
      val forAllSet=union(union(s1,s2),union(s3,s4))
        assert( forall(forAllSet, _<5))
    	assert( !forall(forAllSet, _<4)) //assert less that set
    	assert(forall(forAllSet, _>(-4)))
    	assert(!forall(forAllSet, _<(-4)))
    }
     }
       test("Testing the exists method") {
    new TestSets { 
      
      val forAllSet=union(union(s1,s2),union(s3,s4))
        assert( exists(forAllSet, _>3))
    	//assert( !forall(forAllSet, _>5)) //assert less that set
    
    }
     }
   ignore("Testing the map method") {
    new TestSets { 
      
      val forAllSet=union(union(s1,s2),union(s3,s4))
        val returnedSet=map(forAllSet, _*3)
        
    	assert( contains(returnedSet,12)) //assert less that set
    
    }
     }
}
