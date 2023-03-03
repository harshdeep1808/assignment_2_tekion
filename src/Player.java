public class Player {

    private int pid;
    private String name;
    private String team;
    private String type;
    private int runs;
    private int balls;
    private int wickets;

    public Player() {
    }

    public Player(int pid, String name, String team, String type) {
        this.pid = pid;
        this.name = name;
        this.team = team;
        this.type = type;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public String toString() {
        return "Player{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", type='" + type + '\'' +
                ", runs=" + runs +
                ", balls=" + balls +
                ", wickets=" + wickets +
                '}';
    }
}
