
public class Player {
	private String name;
	private Strategy strategy;
	private int wincount;
	private int losecount;
	private int gamecount;
	public Player(String name, Strategy strategy) {		//名前と戦略を与えられる
		this.name = name;
		this.strategy = strategy;
	}
	public Hand nextHand() {							//戦略に次の手を決めてもらう(委譲)
		return strategy.nextHand();
	}
	public void win() {									//勝った
		strategy.study(true);
		wincount++;
		gamecount++;
	}
	public void lose() {								//負けた
		strategy.study(false);
		losecount++;
		gamecount++;
	}
	public void even() {								//引き分け
		gamecount++;
	}
	public String toString() {
		return "[" + name + ":" + gamecount + "games, " + wincount + "win, " + losecount + "lose, " + "]";
	}
}
