
public class TennisGame2 implements TennisGame
{
    private static final int pointGame = 4;
	private static final int points40 = 3;
	private static final int points30 = 2;
	private static final int points15 = 1;
	private static final int pointsNone = 0;
	public int player1Points = 0;
    public int player2Points = 0;
    

    public TennisGame2() {    }

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
    
    public String getLiteralScore(){
        String score = "";
        score = tiedScoreNotDeuce(player1Points, player2Points);        
        score = tiedScoreInDeuce(score, player1Points, player2Points);  
        score = playingForPointsNotDeuceNotAdvantage(score, player1Points, player2Points);       
        score = playersPlayingForAdvantage(score, player1Points, player2Points);
        score = playerWinsGame(score, player1Points, player2Points);
        return score;
    }
    

	private String tiedScoreNotDeuce(int player1Points, int Player2Points) {
		if (player1Points == player2Points && player1Points < pointGame)
        	return (convertPointsToLiteral(player1Points) + "-All");
		return "";
	}

	private String tiedScoreInDeuce(String score, int playerPoints, int otherPlayerPoints) {
		if (playerPoints==otherPlayerPoints && playerPoints>=3)
            score = "Deuce";
		return score;
	}

	private String playersPlayingForAdvantage(String score, int playerPoints, int otherPlayerPoints) {
		if (playerPointsHigherThanOtherPlayerPoint(player1Points, player2Points) && playingForAdvantage(player2Points))
        {
            score = "Advantage player1";
        }
        if (playerPointsHigherThanOtherPlayerPoint(player2Points, player1Points) && playingForAdvantage(player1Points))
        {
            score = "Advantage player2";
        }
		return score;
	}

	
	private String playingForPointsNotDeuceNotAdvantage(String score, int player1Points, int player2Points) {
		if (playerPointsHigherThanOtherPlayerPoint(player1Points, player2Points) && player1Points < pointGame)
        {
           score = convertPointsToLiteral(player1Points) + "-" + convertPointsToLiteral(player2Points);
        }
        if (playerPointsHigherThanOtherPlayerPoint(player2Points, player1Points) && player2Points < pointGame)
        {
        	score = convertPointsToLiteral(player1Points) + "-" + convertPointsToLiteral(player2Points);
        }
		return score;
	}


	
	private boolean playerPointsHigherThanOtherPlayerPoint(int playerPoints, int otherPlayerPoints) {
		return (playerPoints > otherPlayerPoints);
	}

	private boolean playingForAdvantage(int playerPoints) {
		return (playerPoints >= points40);
	}

	private String playerWinsGame(String score, int player1Points, int player2Points) {
		if (playerInGamepointOtherPlayerNotInGame(player1Points, player2Points) && twoPointsDifference(player1Points, player2Points) )
        {
            score = "Win for player1";
        }
        if (playerInGamepointOtherPlayerNotInGame(player2Points, player1Points) && twoPointsDifference(player2Points, player1Points))
        {
            score = "Win for player2";
        }
		return score;
	}
	

	private boolean playerInGamepointOtherPlayerNotInGame(int pointsOfAPlayer, int pointsOfOtherPlayer) {
		return (pointsOfAPlayer>=pointGame && pointsOfOtherPlayer>=pointsNone);

	}
	

	private boolean twoPointsDifference(int player1Points, int player2Points) {
		return ((player1Points-player2Points)>=points30);		
	}
    
    public void SetP1Score(int number){
        
        for (int puntosAnotadosJugador1 = 0; puntosAnotadosJugador1 < number; puntosAnotadosJugador1++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int puntosAnotadosPorJugador2 = 0; puntosAnotadosPorJugador2 < number; puntosAnotadosPorJugador2++)
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