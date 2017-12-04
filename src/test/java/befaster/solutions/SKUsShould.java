package befaster.solutions;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SKUsShould {

    @Test
    @Parameters({
            "A, A",
            "BA, AB"
    })
    public void
    sortSkus(String input, String output) {
        assertThat(SKUs.sort(input), is(output));
    }

}