package br.com.ibm.assassinato.commandline;

import br.com.ibm.assassinato.actors.Witness;
import br.com.ibm.assassinato.services.WitnessValidationService;
import br.com.ibm.assassinato.utils.HypothesisUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.concurrent.atomic.AtomicInteger;

public class InputCommandLineTest {

    private InputCommandLine inputCommandLine;
    private GetInput getInput;

    @Before
    public void init() {
        getInput = Mockito.mock(GetInput.class);
        inputCommandLine = new InputCommandLine(Witness.WitnessBuilder.aWitness()
                .withLocation(HypothesisUtils.LOCATIONS[0])
                .withSuspect(HypothesisUtils.SUSPECTS[0])
                .withGun(HypothesisUtils.GUNS[0])
                .build(),
                getInput,
                new WitnessValidationService()
        );
    }

    @Test
    public void run() throws Exception {
        AtomicInteger count = new AtomicInteger(0);
        Mockito.when(getInput.read()).then(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                switch (count.incrementAndGet()) {
                    case 1:
                        return "1, 1, 2";
                    case 2:
                        return "0, 1, 2";
                    case 3:
                        return "0, 0, 2";
                    case 4:
                        return "0, 0, A";
                    case 5:
                        return "";
                    case 6:
                        return "2, 3";
                    case 7:
                        return "2; 3";
                    default:
                        return "0,0,0";
                }
            }
        });
        inputCommandLine.run(new String[]{});
    }
}