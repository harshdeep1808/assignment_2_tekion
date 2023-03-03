public class Scoreboard {

    private int sid;
    private String team;
    private String batsman;
    private String bowler;
    private int wickets;
    private int overs;
    private int balls;
    private int runs;

    public Scoreboard() {
    }

    public Scoreboard(int sid, String team, String batsman, String bowler, int wickets, int overs, int balls, int runs) {
        this.sid = sid;
        this.team = team;
        this.batsman = batsman;
        this.bowler = bowler;
        this.wickets = wickets;
        this.overs = overs;
        this.balls = balls;
        this.runs = runs;
    }

    public String toString() {
        return "Scoreboard{" +
                "sid=" + sid +
                ", team='" + team + '\'' +
                ", batsman='" + batsman + '\'' +
                ", bowler='" + bowler + '\'' +
                ", wickets=" + wickets +
                ", overs=" + overs +
                ", balls=" + balls +
                ", runs=" + runs +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public int getOvers() {
        return overs;
    }

    public void setOvers(int overs) {
        this.overs = overs;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }
}
