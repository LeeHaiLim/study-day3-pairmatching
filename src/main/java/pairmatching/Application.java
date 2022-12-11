package pairmatching;

import java.util.function.Supplier;
import pairmatching.domain.PairKey;
import pairmatching.repository.PairRepository;
import pairmatching.util.Command;
import pairmatching.util.FeatureMenu;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }

    public void run() {
        Initiator.init();
        FeatureMenu featureMenu;
        do {
            featureMenu = repeatWhile(() -> FeatureMenu.findMenu(inputView.readFeature()));
            runMenu(featureMenu);
        } while (!featureMenu.equals(FeatureMenu.QUIT));
    }

    public void runMenu(FeatureMenu featureMenu) {
        if (featureMenu.equals(FeatureMenu.QUIT)) {
            return;
        }
        if (featureMenu.equals(FeatureMenu.PAIR_MATCHING)) {
            pairMatching();
        }
        if (featureMenu.equals(FeatureMenu.PAIR_QUERY)) {
            pairQuery();
        }
        if (featureMenu.equals(FeatureMenu.PAIR_INIT)) {
            pairInit();
        }
    }

    public void pairMatching() {
        outputView.printMenu();
        PairKey pairKey = repeatWhile(() -> new PairKey(inputView.readPairKey()));
        while (PairRepository.containsKey(pairKey)) {
            Command command = repeatWhile(() -> Command.findCommand(inputView.readCommand()));
            if (command.equals(Command.NO)) {
                pairKey = repeatWhile(() -> new PairKey(inputView.readPairKey()));
                continue;
            }
            PairRepository.removePairs(pairKey);
        }
        try {
            PairMatcher.pairMatch(pairKey);
            outputView.printPairs(PairRepository.getPairs(pairKey));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    public void pairQuery() {
        outputView.printMenu();
        PairKey pairKey = repeatWhile(() -> new PairKey(inputView.readPairKey()));
        try {
            outputView.printPairs(PairRepository.getPairs(pairKey));
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    public void pairInit() {
        PairRepository.clear();
        outputView.printPairInitResult();
    }

    private <T> T repeatWhile(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
