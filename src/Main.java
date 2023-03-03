import java.util.ArrayList;
import java.util.List;

public class Main {

    public static String tossMatch(){
        int a =(int)Math.floor((Math.random())*2);
        return a==0?"A":"B";
    }
    public static int func(){
        int rand=(int)Math.floor((Math.random()*6)+1);// probability of runs=1/6
        int randW=(int)Math.floor(Math.random()*15); //probability of wicket =1/15
        if(rand==5) return func();
        if(randW==14) return -1; //-1==wicket
        return rand;
    }
    public static  void updateWicket(Player bowler){
        int wickets= bowler.getWickets();
        wickets++;
        bowler.setWickets(wickets);
    }
    public static void updateBalls(Player bowler){
        int balls= bowler.getBalls();
        balls++;
        bowler.setBalls(balls);
    }
    public static void updateRuns(Player batsman,int run){
        int runs= batsman.getRuns();
        runs+=run;
        batsman.setRuns(runs);
    }

    public static List<Player> addPlayers(){
        List<Player> players=new ArrayList<>();
        String [] t={"A","B"};
        for(int j=0;j<2;j++){
            int pid=players.size();
            String type="";
            for(int i=0;i<5;i++){
                if(i<3)type="batsman";
                else type="bowler";
                String name=t[j]+Integer.toString(i);
                Player p=new Player(pid,name,t[j],type);
                players.add(p);
                pid++;
            }
        }
        return players;
    }

    public static List<Player> findByType(List<Player> players,String type,String team){
        List<Player> flag=new ArrayList<>();
        for(int i=0;i<players.size();i++){
            if(players.get(i).getType().equals(type)&&players.get(i).getTeam().equals(team)){
                flag.add(players.get(i));
            }
        }
        return flag;
    }

    public static List<Player> findByTeam(List<Player> players,String team){
        List<Player> flag=new ArrayList<>();
        for(int i=0;i<players.size();i++){
            if(players.get(i).getTeam().equals(team)){
                flag.add(players.get(i));
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String toss=tossMatch();
        String [] teams={"A","B"};
        List<Player> players=addPlayers();
        List<Scoreboard>scoreboard=new ArrayList<>();
        int totalOvers=10;
        Boolean matchOver=false;
        int balls=0,overs=0,wickets=0,runs=0,currTeam=toss.equals(teams[0])?0:1,target=-1;
        List<Player> bowlers=findByType(players,"bowler",currTeam==0?teams[1]:teams[0]);
        List<Player> batsmans=findByTeam(players,teams[currTeam]);
        int batsmanInd=0,bowlersInd=0,innings=0;
        Player bowler=bowlers.get(bowlersInd);
        Player batsman= batsmans.get(batsmanInd);
        boolean flag=false;
        String winner="";
        while(!matchOver){
            int res=func();
            balls=(balls+1)%7;
            if(balls==0)balls++;
            if(res==-1){  //-1==wicket taken
                updateWicket(bowler);
                wickets++;
                batsmanInd++;
                if(wickets>=5){
                    Scoreboard s = new Scoreboard(scoreboard.size(), teams[currTeam], batsman.getName(), bowler.getName(), wickets, overs, balls, runs);
                    scoreboard.add(s);
                    innings++;
                    if(target==-1) {
                        target = runs;
                    }
                    if(innings<2){
                        if(currTeam==1)currTeam=0;
                        else currTeam=1;
                        balls=overs=wickets=runs=batsmanInd=bowlersInd=0;
                        if(currTeam==0)
                            bowlers=findByType(players,"bowler",teams[1]);
                        else bowlers=findByType(players,"bowler",teams[0]);
                        batsmans=findByTeam(players,teams[currTeam]);
                        bowler=bowlers.get(bowlersInd);
                        batsman= batsmans.get(batsmanInd);
                    }
                }
                else batsman= batsmans.get(batsmanInd);
            }else{
                updateBalls(bowler);
                updateRuns(batsman,res);
                runs+=res;
                if(innings==1){
                    if(runs>target){
                        innings++;
                    }
                }
            }

            Scoreboard s = new Scoreboard(scoreboard.size(), teams[currTeam], batsman.getName(), bowler.getName(), wickets, overs, balls, runs);
            scoreboard.add(s);

            if(balls==6&&flag){
                overs++;
                if(overs==totalOvers){
                    if(target==-1)
                        target=runs;
                    if(innings<2){
                        if(currTeam==1)currTeam=0;
                        else currTeam=1;
                        innings++;
                        balls=overs=wickets=runs=batsmanInd=bowlersInd=0;
                        bowlers=findByType(players,"bowler",currTeam==0?teams[1]:teams[0]);
                        batsmans=findByTeam(players,teams[currTeam]);
                    }
                }
                if(innings<2){
                    bowlersInd=(bowlersInd+1)%2;
                    bowler=bowlers.get(bowlersInd);
                }
            }
            if(innings==2){
                if(runs<target) {
                    if(currTeam==0)
                        currTeam=1;
                    else currTeam=0;
                    winner = teams[currTeam];
                }
                else {
                    winner = teams[currTeam];
                }
                matchOver=true;
                break;
            }
            flag=true;
        }
        //.
        //.
        //logic ends
        String result="Team "+winner+" won by "+Integer.toString(Math.abs(target-runs))+" runs.";
        System.out.println(result);
        System.out.println(scoreboard);
        System.out.println(players);
    }
}