package bridge.view;

import bridge.domain.Draw;
import bridge.type.DrawType;
import bridge.type.PositionType;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private Draw draw = new Draw();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(PositionType position, boolean isPass) {
        DrawType.PASS.draw(position, isPass, draw);
        DrawType.MISS.draw(position, isPass, draw);

        String up = String.join(" | ", draw.getUpBridges());
        String down = String.join(" | ", draw.getDownBridges());

        System.out.printf("[ %s ]\n", up);
        System.out.printf("[ %s ]\n\n", down);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String gameStatus, int gameCount) {
        System.out.println("최종 게임 결과");

        String up = String.join(" | ", draw.getUpBridges());
        String down = String.join(" | ", draw.getDownBridges());

        System.out.printf("[ %s ]\n", up);
        System.out.printf("[ %s ]\n\n", down);

        System.out.printf("게임 성공 여부: %s\n", gameStatus);
        System.out.printf("총 시도한 횟수: %d\n", gameCount);
    }

    public void reset() {
        draw.removeAll();
    }

    public int countPassSymbol() {
        return draw.countPassSymbol();
    }
}
