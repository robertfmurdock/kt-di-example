package kt.di.example

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.kotlintest.Description
import io.kotlintest.specs.FunSpec
import org.assertj.core.api.Assertions.assertThat

class GetLimeActionTest : GetLimeActionDispatcher, FunSpec() {

    override lateinit var limeRepository: LimeRepository

    override fun beforeTest(description: Description) {
        limeRepository = mock()
    }

    init {

        test("will produce a lime each time") {
            val expectedLime = Lime("Extra Sour")

            whenever(limeRepository.get()).thenReturn(expectedLime)

            val lime: Lime = GetLimeAction.perform()

            assertThat(lime).isEqualTo(expectedLime)
        }
    }

}