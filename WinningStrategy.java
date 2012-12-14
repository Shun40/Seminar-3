import java.util.Random;

public class WinningStrategy implements Strategy {
	private Random random;
	private boolean won = false;
	private Hand prevHand;
	// コンストラクタでrandomに乱数を与える
	public WinningStrategy(int seed) {
		random = new Random(seed);
	}
	public Hand nextHand() {
		if(!won) {	//wonがfalseだった場合、ランダムで次の手を決める
			prevHand = Hand.getHand(random.nextInt(3));
		}
		return prevHand;
	}
	// 前回の勝負の結果をwonに保持
	public void study(boolean win) {
		won = win;
	}
}
