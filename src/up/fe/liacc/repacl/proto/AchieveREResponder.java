package up.fe.liacc.repacl.proto;

import java.util.ArrayList;

import up.fe.liacc.repacl.Agent;
import up.fe.liacc.repacl.acl.ACLMessage;
import up.fe.liacc.repacl.acl.MessageTemplate;
import up.fe.liacc.repacl.acl.Protocol;

public class AchieveREResponder extends Behavior {

	private MessageTemplate template;

	public AchieveREResponder(Agent agent) {
		super(agent);

		// Set the template that will filter the responses
		template = new MessageTemplate();
		ArrayList<Integer> protocols = new ArrayList<Integer>();
		protocols.add(Protocol.FIPA_REQUEST); //FIXME this shouldn't be a fixed value
		template.setProtocols(protocols );
	}

	@Override
	public void action() {
		/*
		 * This method is scheduled in Repast.
		 * On each tick, do:
		 *  1 - Get one message matching the template
		 *  2 - Read the performative in the message
		 *  3 - Call the appropriate handler
		 *  5 - If wait list is empty, run the appropriate "handle all"
		 *  6 - Update the protocol state 
		 */
		ACLMessage nextMessage = this.getOwner().getMatchingMessage(template);
		if (nextMessage != null) {
			handleRequest(nextMessage);
		}
	}

	/**
	 * This method is called every tick if there is a message to process.
	 * This default implementation does nothing and should be overridden.
	 * @param nextMessage
	 */
	private void handleRequest(ACLMessage nextMessage) {}
	
	

}
