public class TennisGame2
{
    private int player1Point;
    private int player2Point;
    private final String player1Name;
    private final String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getResult(int point){
        String[] textResult = {"Love", "Fifteen", "Thirty", "Forty"};
        return textResult[point];
    }

    public String getScore(){
//        Draw
        boolean drawNotDeuce = player1Point == player2Point && player1Point < 3;
        if (drawNotDeuce)
        {
            return getResult(player1Point)+"-All";
        }

//        Deuce
        boolean isDeuce = player1Point == player2Point && player1Point >= 3;
        if (isDeuce) {
            return "Deuce";
        }

        //        Winner
        boolean player1Winner = player1Point >= 4 && player2Point >= 0 && (player1Point - player2Point) >= 2;
        if (player1Winner)
        {
            return "Win for "+player1Name;
        }
        boolean player2Winner = player2Point >= 4 && player1Point >= 0 && (player2Point - player1Point) >= 2;
        if (player2Winner)
        {
            return "Win for "+player2Name;
        }

//        Advantage
        boolean player1Advantage = player1Point > player2Point && player2Point >= 3 && (player1Point-player2Point) ==1;
        if (player1Advantage)
        {
            return "Advantage "+player1Name;
        }
        boolean player2Advantage = player2Point > player1Point && player1Point >= 3 && (player2Point-player1Point) ==1;
        if (player2Advantage)
        {
            return "Advantage "+player2Name;
        }

        return getResult(player1Point)+"-"+getResult(player2Point);
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