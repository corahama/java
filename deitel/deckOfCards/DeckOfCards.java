import java.security.SecureRandom;

public class DeckOfCards{
  private Card[] deck;
  private int currentCard;
  private static final int NUMBER_OF_CARDS = 52;
  private static final SecureRandom randomNumber = new SecureRandom();

  public DeckOfCards(){
    String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six",
    "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
    String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

    currentCard = 0;
    deck = new Card[NUMBER_OF_CARDS];

    for(int counter = 0; counter < deck.length; counter++){
      deck[counter] = new Card(faces[counter%13], suits[counter/13]);
    }
  }

  public void suffle(){
    currentCard = 0;
    int second;

    for(int counter = 0; counter < deck.length; counter++){
        second = randomNumber.nextInt(52);

        Card temp = deck[counter];
        deck[counter] = deck[second];
        deck[second] = temp;
    }
  }

  public Card dealCard(){
    if(currentCard < deck.length)
      return deck[currentCard++];
    else
      return null;
  }

}
