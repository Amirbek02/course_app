import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Modul {
    private static final int TEAM_SIZE = 5;
    private static final int PARTICIPANT_COUNT = 20;
    private static final int RECRUITMENT_INTERVAL = 5000; // 5 seconds

    private List<Participant> allParticipants = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();

    public static void main(String[] args) {
        Modul teamBuilder = new Modul();
        teamBuilder.initializeParticipants();
        teamBuilder.startRecruitment();
    }

    private void initializeParticipants() {
        for (int i = 1; i <= PARTICIPANT_COUNT; i++) {
            Participant participant = new Participant(i, generateRandomSkills());
            allParticipants.add(participant);
        }
    }

    private void startRecruitment() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                recruitTeamMember();
                if (teams.size() == PARTICIPANT_COUNT / TEAM_SIZE) {
                    timer.cancel();
                }
            }
        }, 0, RECRUITMENT_INTERVAL);
    }

    private void recruitTeamMember() {
        if (allParticipants.isEmpty()) {
            System.out.println("No more available participants.");
            return;
        }

        Collections.shuffle(allParticipants);
        List<Participant> selectedParticipants = allParticipants.subList(0, TEAM_SIZE);
        allParticipants.removeAll(selectedParticipants);

        Team team = new Team();
        for (int i = 0; i < TEAM_SIZE; i++) {
            Role role = Role.values()[i];
            team.addMember(new TeamMember(selectedParticipants.get(i), role));
        }

        teams.add(team);
        System.out.println("Team recruited: " + team);
    }

    private List<String> generateRandomSkills() {
        List<String> skills = new ArrayList<>();
        Random random = new Random();
        int skillCount = random.nextInt(5) + 1; // Randomly choose 1 to 5 skills
        for (int i = 0; i < skillCount; i++) {
            skills.add("Skill" + (i + 1));
        }
        return skills;
    }
}

class Participant {
    private int id;
    private List<String> skills;

    public Participant(int id, List<String> skills) {
      this.id = id;
      this.skills = skills;
  }
  

    public int getId() {
        return id;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Participant " + id;
    }
}

enum Role {
    CEO, DATABASE, BACKEND, FRONTEND, SCIENCE_EXPERT
}

class TeamMember {
    private Participant participant;
    private Role role;

    public TeamMember(Participant participant, Role role) {
        this.participant = participant;
        this.role = role;
    }

    @Override
    public String toString() {
        return participant + " as " + role;
    }
}

class Team {
    private List<TeamMember> members = new ArrayList<>();

    public void addMember(TeamMember member) {
        members.add(member);
    }

    @Override
    public String toString() {
        return "Team members: " + members;
    }
}
