import structs.FrameData;
import structs.GameData;
import structs.Key;
import gameInterface.AIInterface;
import structs.CharacterData;

import java.util.Random;

import commandcenter.CommandCenter;
public class IAState implements AIInterface {
	
	Key inputKey;
	boolean playerNumber;
	FrameData frameData;
	CommandCenter cc;
	
	
	@Override
	public int initialize(GameData gameData, boolean playerNumber){ 
		this.playerNumber = playerNumber;
		this.inputKey = new Key();
		cc = new CommandCenter();
		frameData = new FrameData();
		return 0;
	}
	
	@Override
	public void getInformation(FrameData frameData){ 
		this.frameData = frameData;
		cc.setFrameData(this.frameData, playerNumber);
	}
	
	@Override
	public void processing() {
		if(!frameData.getEmptyFlag() && frameData.getRemainingTime() > 0){
			CharacterData player = frameData.getMyCharacter(true);
		
			CharacterData oponent = frameData.getOpponentCharacter(false);
			System.out.println(oponent.getState().name() +
					" " + oponent.getAction().name() +
					" " + oponent.getRemainingFrame() + 
					" " + player.getHp());
		}
	}
	
	@Override
	public Key input()
	{ return
	inputKey;
	}
	@Override
	public void close(){
	}
	@Override
	public String getCharacter(){
	return CHARACTER_ZEN;
	}
	}