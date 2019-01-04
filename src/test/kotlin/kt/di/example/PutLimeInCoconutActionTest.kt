package kt.di.example

import io.kotlintest.specs.FunSpec
import org.assertj.core.api.Assertions.assertThat

class PutLimeInCoconutActionTest : PutLimeInCoconutActionDispatcher, FunSpec() {

    init {

        test("will blend lime and pour it into coconut") {
            val lime = Lime("Barely even sour")
            val coconut = Coconut("7", "fresh")

            val result: HalfCoconutDrink = PutLimeInCoconutAction(lime, coconut)
                    .perform()

            assertThat(result.milk).isEqualTo(Milk("fresh", "Barely even sour"))
        }
    }

}

