package be.bomberman.main.gameobjects.bonus;

import be.bomberman.main.affichage.Screen;
import be.bomberman.main.gameobjects.Player;
import be.bomberman.main.levels.Level;
import be.bomberman.main.levels.tiles.Tile;

public class FetaBonus extends UsedBonus {

	private int counter = 800 ;
	
	
	public FetaBonus(Level level, int x, int y) {
		super(level, x, y);
		// coordonn�es inutiles
	}



	@Override
	public void doUsedBonusAction(Player player) {
		player.setSpeed(2);
		this.player = player ;
		//System.out.println("hi");
	}

	@Override
	public void update() {
		counter--;
		if (counter < 0){
			player.setSpeed(1);
			remove();
		}
		
	}

	@Override
	public void render(Screen screen) {
		
	}

	@Override
	public void remove() {
		removed = true;
		
	}



	@Override
	public void doUsedBonusActionOnCollision(Player player) {
		// TODO Auto-generated method stub
		
	}

}
