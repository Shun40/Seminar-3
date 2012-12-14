import java.util.Random;

public class ProbStrategy implements Strategy {
	private Random random;
	private int prevHandValue = 0;		//�O��ɏo������
	private int currentHandValue = 0;	//����o����
	private int[][] history = {			//3*3�̐����񎟌��z����`
			{ 1, 1, 1, },
			{ 1, 1, 1, },
			{ 1, 1, 1, },
	};
	// �R���X�g���N�^��random�ɗ�����^����
	public ProbStrategy(int seed) {
		random = new Random(seed);
	}
	public Hand nextHand() {
		int bet = random.nextInt(getSum(currentHandValue));
		int handvalue = 0;
		if(bet < history[currentHandValue][0]) {
			handvalue = 0;
		} else if(bet < history[currentHandValue][0] + history[currentHandValue][1]) {
			handvalue = 1;
		} else {
			handvalue = 2;
		}
		prevHandValue = currentHandValue;
		currentHandValue = handvalue;
		return Hand.getHand(handvalue);
	}
	private int getSum(int hv) {
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum += history[hv][i];
		}
		return sum;
	}
	public void study(boolean win) {
		if(win) {
			history[prevHandValue][currentHandValue]++;
		} else {
			history[prevHandValue][(currentHandValue + 1) % 3]++;
			history[prevHandValue][(currentHandValue + 2) % 3]++;
		}
	}
}
