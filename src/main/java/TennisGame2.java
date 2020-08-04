public class TennisGame2
{
    private int player1Point;
    private int player2Point;
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getResult(int point){
        switch(point){
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
        }
        return "Forty";
    }

    public String getScore(){
        String player1Result = "";
        String player2Result = "";
        String score = "";

        if (player1Point == player2Point && player1Point < 4)
        {
            score = getResult(player1Point);
            score += "-All";
        }

        if (player1Point == player2Point && player1Point >=3)
            score = "Deuce";

        if (player1Point > 0 && player2Point ==0)
        {
            player1Result = getResult(player1Point);
            player2Result = "Love";
            score = player1Result + "-" + player2Result;
        }

        if (player2Point > 0 && player1Point ==0)
        {
            player2Result = getResult(player2Point);
            player1Result = "Love";
            score = player1Result + "-" + player2Result;
        }

        if (player1Point > player2Point && player1Point < 4)
        {
            player1Result = getResult(player1Point);
            player2Result = getResult(player2Point);
            score = player1Result + "-" + player2Result;
        }

        if (player2Point > player1Point && player2Point < 4)
        {
            player1Result = getResult(player1Point);
            player2Result = getResult(player2Point);
            score = player1Result + "-" + player2Result;
        }

        if (player1Point > player2Point && player2Point >= 3)
        {
            score = "Advantage "+player1Name;
        }

        if (player2Point > player1Point && player1Point >= 3)
        {
            score = "Advantage "+player2Name;
        }

        if (player1Point >=4 && player2Point >=0 && (player1Point - player2Point)>=2)
        {
            score = "Win for "+player1Name;
        }
        if (player2Point >=4 && player1Point >=0 && (player2Point - player1Point)>=2)
        {
            score = "Win for "+player2Name;
        }
        return score;
    }

    public void player1Score(){
        player1Point++;
    }

    public void player2Score(){
        player2Point++;
    }

    public void wonPoint(String player) {
        if (!player.equals("player1")) {
            player2Score();
        } else {
            player1Score();
        }
    }
}