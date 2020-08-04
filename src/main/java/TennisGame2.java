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

    public String getScore(){
        String[] textScores = {"Love", "Fifteen", "Thirty", "Forty"};

//        Draw
        boolean drawNotDeuce = player1Point == player2Point && player1Point < 3;
        if (drawNotDeuce)
        {
            return textScores[player1Point]+"-All";
        }

//        Deuce
        boolean isDeuce = player1Point == player2Point && player1Point >= 3;
        if (isDeuce) {
            return "Deuce";
        }

        //        Winner
        if (player1Point >=4 && player2Point >=0 && (player1Point - player2Point)>=2)
        {
            return "Win for "+player1Name;
        }
        if (player2Point >=4 && player1Point >=0 && (player2Point - player1Point)>=2)
        {
            return "Win for "+player2Name;
        }

//        Advantage
        if (player1Point > player2Point && player2Point >= 3)
        {
            return "Advantage "+player1Name;
        }
        if (player2Point > player1Point && player1Point >= 3)
        {
            return "Advantage "+player2Name;
        }


        return textScores[player1Point]+"-"+textScores[player2Point];
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