package co.touchlab.stately.concurrency

import co.touchlab.testhelp.concurrency.ThreadOperations
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ThreadRefTest {
  @Test
  fun threadRefTest() {
    val ref = ThreadRef()
    assertTrue(ref.same())
    val ops = ThreadOperations { }
    ops.exe {
      assertFalse(ref.same())
      ref.reset()
      assertTrue(ref.same())
    }

    ops.run(1)

    assertFalse(ref.same())
    ref.reset()
    assertTrue(ref.same())
  }
}