import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class ExtremeStartupSpec extends Spec with ShouldMatchers {

	describe("extreme startup server") {
		val servlet = new ExtremeStartup
		it("adds numbers") {
			servlet.answer("what is the sum of 4 and 12") should equal ("16")
		}
    it("answers Christmas-theme questions") {
      servlet.answer("what's santa clause's real name") should equal ("Kris Kringle")
    }
	}
}
