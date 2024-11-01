package org.example.contriller;

import org.example.service.EcosystemService;
import org.example.util.Utils;

import java.util.Scanner;

import static org.example.util.constant.ExceptionMessage.ERROR_ENTER_MESSAGE;
import static org.example.util.constant.ConsoleMenuConstant.MAIN_MENU;
import static org.example.util.constant.StepConstant.*;

public class PersonController {
    private final EcosystemService ecosystemService;
    private static final Scanner SCANNER = new Scanner(System.in);

    public void welcomePerson() {
        System.out.print(MAIN_MENU);
        Utils.loopIterationAndExit((int count) -> {
            try {
                String step = SCANNER.nextLine();
                switch (step) {
                    case STEP_ONE -> ecosystemService.getAll();
                    case STEP_TWO -> ecosystemService.create();
                    case STEP_ZERO -> Utils.exit();
                    default -> {
                        if (count < Utils.ITERATION_LOOP_MESSAGE)
                            System.out.print(ERROR_ENTER_MESSAGE);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }, Utils.ITERATION_LOOP);
    }

    public PersonController(EcosystemService ecosystemService) {
        this.ecosystemService = ecosystemService;
    }
}