package bridge.view.output;

import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridge) {
        for (List<String> row : bridge) {
            printRow(row);
        }
        System.out.println();
    }

    private void printRow(List<String> bridgeRow) {
        StringBuilder output = new StringBuilder("[");

        for (int index = 0; index < bridgeRow.size(); index++) {
            output.append(String.format(" %s ", bridgeRow.get(index)));
            if (index != bridgeRow.size() - 1) {
                output.append("|");
            }
        }
        output.append("]");

        System.out.println(output);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, int tryCount) {
        System.out.printf("게임 성공 여부: %s\n"
                + "총 시도한 횟수: %d\n\n", result, tryCount);
    }

    public void printException(Exception e) {
        System.out.println(e.getMessage());
        Arrays.stream(e.getStackTrace()).forEach(System.out::println);
    }
}
