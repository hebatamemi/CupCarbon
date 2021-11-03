package senscript;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

import device.SensorNode;
import simulation.WisenSimulation;

public class Command_TIMESTAMP extends Command {

	protected String arg = "" ;
	
	public Command_TIMESTAMP(SensorNode sensor, String arg) {
		this.sensor = sensor ;
		this.arg = arg ;
	}

	@Override
	public double execute() {

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   		LocalDateTime now = LocalDateTime.now();  
   		String str = dtf.format(now);  
		WisenSimulation.simLog.add("S" + sensor.getId() + " GET TIMESTAMP.");
		sensor.getScript().addVariable(arg, str);
		return 0;
	}

	@Override
	public String toString() {
		return "GET TIMESTAMP";
	}

}
