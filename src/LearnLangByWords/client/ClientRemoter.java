package clientServer;

import org.json.simple.JSONObject;

public class ClientRemoter {
	private Client clientInst;
	
	public ClientRemoter () {
		clientInst = new Client();
	}
	
	
	public String sendSaltRequest (String login) {
		clientInst.sendQuery(login);
		String line = clientInst.readAnswer();
		return line;
	}
	
	@SuppressWarnings("unchecked")
	public static void main (String[] args) {
		ClientRemoter test = new ClientRemoter();
		JSONObject request = new JSONObject();
		request.put("act", "getSalt");
		request.put("login", "admin");		
		test.sendSaltRequest(request.toJSONString());
	}
}
