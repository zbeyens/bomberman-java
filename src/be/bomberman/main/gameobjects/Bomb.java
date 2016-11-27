package be.bomberman.main.gameobjects;

import be.bomberman.main.affichage.SheetSquare;
import be.bomberman.main.levels.Level;
import be.bomberman.main.levels.tiles.Tile;

public abstract class Bomb extends GameObject{	

	protected int timer;
	protected int range;	
	protected Player player;
	
	public Bomb(int x, int y, Level level, int range, Player player) {
		super(level);
		this.x = x;
		this.y = y;
		this.level = level;
		this.player = player;
		this.timer = 0;
		this.range = range;
		//placeInFront(player);
		center();
	}
	
	
	public abstract void boom();
	
	public static boolean canBePlaced(int x, int y){
		/*
		 * Seul les coord en haut a gauche son n�cessaire car les autres bords du joueur ne peuvent pas etre su un autre tile
		 */
		if (level.theLevel == "level1"){
			if(level.getTile((x+16)>> 5, (y+16)>> 5) == Tile.grass) return true;
		}else if (level.theLevel == "level2"){
			if(level.getTile((x+16)>> 5, (y+16)>> 5) == Tile.grassLevel2) return true;
		}
		
		return false;
	}	
	
	public boolean bombCollision(int x, int y){
		// x y position du player en pixel
		int[] entCoord = getCoordinates(x, y);
		if ( (getCoordinates(this.x, this.y)[0] == entCoord[0]) && (getCoordinates(this.x, this.y)[1] == entCoord[1]) ){
			
			return true;
		}
		return false;
	}
	
	public boolean getYourBomb(int xEntity, int yEntity){
		
		int xMin = 9;
		int xMax = 21;
		int yMin = 20; //pour que la tete ne brule pas
		int yMax = 29;
			if (bombCollision(xEntity + xMin, yEntity + yMin)) return true ;
			if (bombCollision(xEntity + xMax, yEntity + yMax)) return true ; 
			if (bombCollision(xEntity + xMin, yEntity + yMax)) return true;		
			if (bombCollision(xEntity + xMax, yEntity + yMin)) return true ;	
		return false;
	}
	
	/*
	public void placeInFront(Player player){
		int dir = player.getMovingDir() ;
		// nord sud ouest est
		if (dir == 0){this.y = this.y - 8;}
		if (dir == 1){this.y = this.y + 16;}
		if (dir == 2){this.x = this.x - 8;}
		if (dir == 3){this.x = this.x + 16;}
	}
	
	*/
	
	
}
