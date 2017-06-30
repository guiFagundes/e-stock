package projeto.estock.entity;

public class CharacterSheet {

	public CharacterSheet(GameType gameType, String sheetLocation) {
		super();
		this.gameType = gameType;
		this.sheetLocation = sheetLocation;
	}

	private GameType gameType;
	private String sheetLocation;

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	public String getSheetLocation() {
		return sheetLocation;
	}

	public void setSheetLocation(String sheetLocation) {
		this.sheetLocation = sheetLocation;
	}

}
