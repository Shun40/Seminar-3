
public class Hand {
	public static final int HANDVALUE_GUU = 0;	//�O�[��\���l
	public static final int HANDVALUE_CHO = 1;	//�`���L��\���l
	public static final int HANDVALUE_PAA = 2;	//�p�[��\���l
	public static final Hand[] hand = {			//����񂯂�̎��\��3�̃C���X�^���X
		new Hand(HANDVALUE_GUU),
		new Hand(HANDVALUE_CHO),
		new Hand(HANDVALUE_PAA),
	};
	private static final String[] name = {		//����񂯂�̎�̕�����\��
		"�O�[", "�`���L", "�p�[",
	};
	private int handvalue;						//����񂯂�̎�̒l
	// �R���X�g���N�^
	private Hand(int handvalue) {
		this.handvalue = handvalue;
	}
	// �C���X�^���X�𓾂郁�\�b�h,�����Ŏ����ꂽ�C���X�^���Xhand��Ԃ�
	public static Hand getHand(int handvalue) {
		return hand[handvalue];
	}
	public boolean isStrongerThan(Hand h) {		//this��h��苭���Ƃ�true��Ԃ�
		return fight(h) == 1;
	}
	public boolean isWakerThan(Hand h) {		//this��h���ア�Ƃ�true��Ԃ�
		return fight(h) == -1;
	}
	private int fight(Hand h) {					//����������0,this�̏����Ȃ�1,h�̏����Ȃ�-1
		if(this == h) {
			return 0;
		} else if((this.handvalue + 1) % 3 == h.handvalue) {
			return 1;
		} else {
			return -1;
		}
	}
	public String toString() {					//������\���֕ϊ�
		return name[handvalue];
	}
}