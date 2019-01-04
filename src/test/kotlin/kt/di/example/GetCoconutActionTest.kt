package kt.di.example

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.kotlintest.specs.FunSpec
import org.assertj.core.api.Assertions.assertThat

class GetCoconutActionTest : GetCoconutActionDispatcher, FunSpec() {

    override val coconutRepository = mock<CoconutRepository>()

    init {

        test("Perform will get the coconut from the repository") {
            val expectedCoconut = Coconut(id = "Ripe", flavor = "Spectacular")

            whenever(coconutRepository.get("Ripe"))
                    .thenReturn(expectedCoconut)


            val coconut = GetCoconutAction("Ripe").perform()

            assertThat(coconut).isEqualTo(expectedCoconut)
        }

    }

}