
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    public String player1LiteralScore = "";
    public String player2LiteralScore = "";

    public TennisGame2() {
    }

  
    
    public String getScore(){
        String score = "";
        if (player1Points == player2Points && player1Points < 4)
        {
            if (player1Points==0)
                score = "Love";
            if (player1Points==1)
                score = "Fifteen";
            if (player1Points==2)
                score = "Thirty";
            score += "-All";
        }
        if (player1Points==player2Points && player1Points>=3)
            score = "Deuce";
        
        if (player1Points > 0 && player2Points==0)
        {
            if (player1Points==1)
                player1LiteralScore = "Fifteen";
            if (player1Points==2)
                player1LiteralScore = "Thirty";
            if (player1Points==3)
                player1LiteralScore = "Forty";
            
            player2LiteralScore = "Love";
            score = player1LiteralScore + "-" + player2LiteralScore;
        }
        if (player2Points > 0 && player1Points==0)
        {
            if (player2Points==1)
                player2LiteralScore = "Fifteen";
            if (player2Points==2)
                player2LiteralScore = "Thirty";
            if (player2Points==3)
                player2LiteralScore = "Forty";
            
            player1LiteralScore = "Love";
            score = player1LiteralScore + "-" + player2LiteralScore;
        }
        
        if (player1Points>player2Points && player1Points < 4)
        {
            if (player1Points==2)
                player1LiteralScore="Thirty";
            if (player1Points==3)
                player1LiteralScore="Forty";
            if (player2Points==1)
                player2LiteralScore="Fifteen";
            if (player2Points==2)
                player2LiteralScore="Thirty";
            score = player1LiteralScore + "-" + player2LiteralScore;
        }
        if (player2Points>player1Points && player2Points < 4)
        {
            if (player2Points==2)
                player2LiteralScore="Thirty";
            if (player2Points==3)
                player2LiteralScore="Forty";
            if (player1Points==1)
                player1LiteralScore="Fifteen";
            if (player1Points==2)
                player1LiteralScore="Thirty";
            score = player1LiteralScore + "-" + player2LiteralScore;
        }
        
        if (player1Points > player2Points && player2Points >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2Points > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
        
        if (player1Points>=4 && player2Points>=0 && (player1Points-player2Points)>=2)
        {
            score = "Win for player1";
        }
        if (player2Points>=4 && player1Points>=0 && (player2Points-player1Points)>=2)
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