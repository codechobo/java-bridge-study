package bridge.utils;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.type.PositionType;
import bridge.type.RetryType;
import bridge.view.InputView;

public class PositionUtils {

    private final InputView inputView = new InputView();

    public boolean compareTo(Player player, Bridge bridge, int start) {
        PositionType passPosition = bridge.currentPosition(start);
        PositionType playerPosition = player.currentPosition(start);

        if (passPosition.equals(playerPosition)) {
            return true;
        }

        return false;
    }

    public RetryType toRetryType(boolean isPass) {
        if (!isPass) {
            String readGameCommand = inputView.readGameCommand();

            return RetryType.matchSymbol(readGameCommand)
                    .orElseThrow(() -> new IllegalArgumentException());
        }

        return RetryType.PASS;
    }



}