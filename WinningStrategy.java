import java.util.Random;

public class WinningStrategy implements Strategy {
	private Random random;
	private boolean won = false;
	private Hand prevHand;
	// �R���X�g���N�^��random�ɗ�����^����
	public WinningStrategy(int seed) {
		random = new Random(seed);
	}
	public Hand nextHand() {
		if(!won) {	//won��false�������ꍇ�A�����_���Ŏ��̎�����߂�
			prevHand = Hand.getHand(random.nextInt(3));
		}
		return prevHand;
	}
	// �O��̏����̌��ʂ�won�ɕێ�
	public void study(boolean win) {
		won = win;
	}
}
