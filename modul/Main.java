import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


class Participant {
    String name;
    List<String> skills;

    public Participant(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }
}


class Team {
    List<Participant> members;

    public Team() {
        this.members = new ArrayList<>();
    }

    public void addMember(Participant participant) {
        members.add(participant);
    }

    public void displayTeam() {
        System.out.println("Team composition:");
        for (Participant participant : members) {
            System.out.println("- " + participant.name);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<Participant> allParticipants = initializeParticipants();
        Team team = formTeam(selectLeader(allParticipants), allParticipants);

        System.out.println("Team successfully formed!");
        team.displayTeam();
    }

    
    private static List<Participant> initializeParticipants() {
        List<Participant> participants = new ArrayList<>();

        participants.add(new Participant("Participant1", List.of("backend", "database")));
        participants.add(new Participant("Participant2", List.of("frontend", "design")));

        return participants;
    }

    
    private static Participant selectLeader(List<Participant> participants) {
        Collections.shuffle(participants);
        return participants.get(0);
    }

    
    private static Team formTeam(Participant leader, List<Participant> allParticipants) {
        Team team = new Team();
        team.addMember(leader);

        List<Participant> availableParticipants = new ArrayList<>(allParticipants);
        availableParticipants.remove(leader);

        Timer recruitingTimer = new Timer();
        recruitingTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!availableParticipants.isEmpty() && team.members.size() < 5) {
                    Participant newMember = availableParticipants.remove(new Random().nextInt(availableParticipants.size()));
                    team.addMember(newMember);
                    System.out.println("Recruiting a new member: " + newMember.name);
                } else {
                    recruitingTimer.cancel();
                }
            }
        }, 0, 500); 

        return team;
    }
}
