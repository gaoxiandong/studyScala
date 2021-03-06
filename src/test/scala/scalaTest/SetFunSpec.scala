package scalaTest
import org.scalatest.FunSpec

class SetFunSpec extends FunSpec {

  describe("A Set") {
    describe("when empty"){
      describe("test"){
        it("should have size 0") {
          assert(Set.empty.size == 0)
        }

        it("should produce NoSuchElementException when head is invoked") {
          assertThrows[NoSuchElementException] {
            Set.empty.head
          }
        }
      }

    }
  }
}