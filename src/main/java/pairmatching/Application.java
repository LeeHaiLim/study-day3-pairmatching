package pairmatching;

import pairmatching.constant.Function;
import pairmatching.service.MatchingService;
import pairmatching.view.input.InputView;
import pairmatching.view.output.OutputView;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Application {

    private final Map<Function, Runnable> functionKey = new HashMap<>();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MatchingService service = new MatchingService();

    Application() {
        initializeFunctionKey();
    }

    private void initializeFunctionKey() {
        functionKey.put(Function.MATCHING, () -> doMatching());
        functionKey.put(Function.INQUIRY, () -> inquiryMatching());
        functionKey.put(Function.INITIALIZE, () -> initializeMatching());
    }

    public static void main(String[] args) {
        new Application().run();
    }

    public void run() {
        while (true) {
            Function function = repeatWhenThrow(() -> inputView.readFunction());
            if (function == Function.QUIT) {
                break;
            }
            functionKey.get(function).run();
        }
    }

    private void doMatching() {

    }

    private void inquiryMatching() {

    }

    private void initializeMatching() {

    }

    private void repeatWhenThrow(Runnable method) {
        while (true) {
            try {
                method.run();
                return;
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private Function repeatWhenThrow(Supplier<Function> method) {
        while (true) {
            try {
                return method.get();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }
}
