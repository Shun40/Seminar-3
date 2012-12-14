
public class Hand {
	public static final int HANDVALUE_GUU = 0;	//グーを表す値
	public static final int HANDVALUE_CHO = 1;	//チョキを表す値
	public static final int HANDVALUE_PAA = 2;	//パーを表す値
	public static final Hand[] hand = {			//じゃんけんの手を表す3つのインスタンス
		new Hand(HANDVALUE_GUU),
		new Hand(HANDVALUE_CHO),
		new Hand(HANDVALUE_PAA),
	};
	private static final String[] name = {		//じゃんけんの手の文字列表現
		"グー", "チョキ", "パー",
	};
	private int handvalue;						//じゃんけんの手の値
	// コンストラクタ
	private Hand(int handvalue) {
		this.handvalue = handvalue;
	}
	// インスタンスを得るメソッド,引数で示されたインスタンスhandを返す
	public static Hand getHand(int handvalue) {
		return hand[handvalue];
	}
	public boolean isStrongerThan(Hand h) {		//thisがhより強いときtrueを返す
		return fight(h) == 1;
	}
	public boolean isWakerThan(Hand h) {		//thisがhより弱いときtrueを返す
		return fight(h) == -1;
	}
	private int fight(Hand h) {					//引き分けは0,thisの勝ちなら1,hの勝ちなら-1
		if(this == h) {
			return 0;
		} else if((this.handvalue + 1) % 3 == h.handvalue) {
			return 1;
		} else {
			return -1;
		}
	}
	public String toString() {					//文字列表現へ変換
		return name[handvalue];
	}
}