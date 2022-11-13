package lotto.io;

import java.util.LinkedList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private final int MIN_UNIT = 1000;

    public int enterPurchaseAmt() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = readLine();

        System.out.printf("\n%d개를 구매했습니다.\n", Integer.parseInt(amount) / MIN_UNIT);
        return Integer.parseInt(amount);
    }

    public LinkedList<Integer> enterWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String number = readLine();

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonus = readLine();

        LinkedList<Integer> winningNumList = makeWinningNumberList(number, bonus);

        if (winningNumList.subList(0, winningNumList.size() - 1).contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }

        return winningNumList;

    }

    private LinkedList<Integer> makeWinningNumberList(String winningNum, String bonusNum) {
        LinkedList<Integer> winningNumWithBonusList = new LinkedList<>();

        for (String wn : winningNum.split(",")) {
            winningNumWithBonusList.add(Integer.parseInt(wn));
        }
        winningNumWithBonusList.add(Integer.parseInt(bonusNum));

        return winningNumWithBonusList;
    }
}
