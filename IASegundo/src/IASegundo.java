import structs.FrameData;
import structs.GameData;
import structs.Key;
import gameInterface.AIInterface;

import java.util.Random;

import commandcenter.CommandCenter;
public class IASegundo implements AIInterface {
	
	Key inputKey;
	boolean playerNumber;
	FrameData frameData;
	CommandCenter cc;
	
	private String[] ATTACKS = {"THROW_A",
			"THROW_B",
			"STAND_A",
			"STAND_B",
			"CROUCH_A",
			"CROUCH_B",
			"STAND_FA",
			"STAND_FB",
			"CROUCH_FA",
			"CROUCH_FB" };
	private Random random = new Random();
	
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
			
			if(cc.getskillFlag() ){
				

				inputKey = cc.getSkillKey();
			}	else{
				inputKey.empty();
				cc.skillCancel();

			
				if(cc.getDistanceX() < 100){
					
					cc.commandCall(ATTACKS[random.nextInt(ATTACKS.length)]);
				}else{
					cc.commandCall("FORWARD_WALK");
				}

			}
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