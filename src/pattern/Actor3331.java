package pattern;

public class Actor3331 {
    public static void main(String[] args) {
        Partner partner1 = new Partner("X corporation");
        Partner partner2 = new Partner("Y corporation");
        Actor actor = new Actor();
        Agent agent = new Agent(actor);
        partner1.invite(agent, 10000);
        partner2.invite(agent, 8000);
        partner2.invite(agent, 10000);
    }
}

class Actor {

    public void perform() {
        System.out.println("The actor is performing");
    }

}

class Agent {

    private Actor actor;

    public Agent(Actor actor) {
        this.actor = actor;
    }

    public void process(Partner partner, int price) {
        if (partner.getName().equals("X corporation")) {
            System.out.println("The actor refuses to cooperate with X corporation");
        } else if (price < 10000) {
            System.out.println("Price is lower than expected");
        } else {
            actor.perform();
        }

    }

}

class Partner { // 合作方

    private String name;

    Partner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void invite(Agent broker, int price) {
        broker.process(this, price);
    }

}
