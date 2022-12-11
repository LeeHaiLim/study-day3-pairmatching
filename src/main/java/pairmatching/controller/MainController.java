package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Menu;
import pairmatching.service.CrewSaveService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class MainController {
    private CrewSaveService crewSaveService = new CrewSaveService();
    private MatchingController matchingController = new MatchingController();

    public MainController() {
        List<String> backendCrew = crewSaveService.getBackendCrew();
        List<String> frontendCrew = crewSaveService.getFrontendCrew();
        crewSaveService.saveCrewNames(backendCrew, Course.BACKEND);
        crewSaveService.saveCrewNames(frontendCrew, Course.FRONTEND);
    }

    public void run() {
        Menu menu;
        do {
            menu = readMenu();
            runService(menu);
        } while (menu != Menu.QUIT);
    }

    private void runService(Menu menu) {
        if (menu == Menu.MATCHING) {
            matchingController.run();
        }
        if (menu == Menu.INFO) {
            matchingController.runMatchingInfo();
        }
        if (menu == Menu.RESET) {
            matchingController.resetPairMatching();
            OutputView.printMessage("초기화 되었습니다.");
        }
    }

    public Menu readMenu() {
        try {
            return Menu.from(InputView.readMenu());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readMenu();
        }
    }
}