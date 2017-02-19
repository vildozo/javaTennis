
public class TennisGame2 implements TennisGame
{
    private static final int pointGame = 4;
	private static final int points40 = 3;
	private static final int points30 = 2;
	private static final int points15 = 1;
	private static final int pointsNone = 0;
	public int player1Points = 0;
    public int player2Points = 0;
    
    public String player1LiteralScore = "";
    public String player2LiteralScore = "";

    public TennisGame2() {
    }

    public String convertPointsToLiteral(int puntosDeJugador){
    	if (puntosDeJugador==pointsNone)
            return "Love";
        if (puntosDeJugador==points15)
        	return "Fifteen";
        if (puntosDeJugador==points30)
        	return "Thirty";
        if (puntosDeJugador==points40)
            return "Forty";
        return"";
    }
    
    public String getScore(){
        String score = "";
        if (player1Points == player2Points && player1Points < pointGame)
        	score = convertPointsToLiteral(player1Points) + "-All";
        if (player1Points==player2Points && player1Points>=3)
            score = "Deuce";
        if (player1Points > pointsNone && player2Points==pointsNone)
        {
        	player1LiteralScore=convertPointsToLiteral(player1Points);
            player2LiteralScore = "Love";
            score = player1LiteralScore + "-" + player2LiteralScore;
        }
        if (player2Points > pointsNone && player1Points==pointsNone)
        {
        	player2LiteralScore=convertPointsToLiteral(player2Points);
            player1LiteralScore = "Love";
            score = player1LiteralScore + "-" + player2LiteralScore;
        }
        
        if (player1Points>player2Points && player1Points < pointGame)
        {
        	player1LiteralScore=convertPointsToLiteral(player1Points);
        	player2LiteralScore=convertPointsToLiteral(player2Points);
           score = player1LiteralScore + "-" + player2LiteralScore;
        }
        if (player2Points>player1Points && player2Points < pointGame)
        {
        	player2LiteralScore=convertPointsToLiteral(player2Points);
        	player1LiteralScore=convertPointsToLiteral(player1Points);
            score = player1LiteralScore + "-" + player2LiteralScore;
        } 
        if (player1Points > player2Points && player2Points >= points40)
        {
            score = "Advantage player1";
        }
        
        if (player2Points > player1Points && player1Points >= points40)
        {
            score = "Advantage player2";
        }
        
        if (player1Points>=pointGame && player2Points>=pointsNone && (player1Points-player2Points)>=points30)
        {
            score = "Win for player1";
        }
        if (player2Points>=4 && player1Points>=0 && (player2Points-player1Points)>=points30)
        {
            score = "Win for player2";
        }
        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}