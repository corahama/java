public class DeckOfCardsTest{
  public static void main(String[] args){
    DeckOfCards deck = new DeckOfCards();

    deck.suffle();

    for(int counter = 1; counter <= 52; counter++){
      System.out.printf("%-19s", deck.dealCard());
      if(counter % 4 == 0)
        System.out.println();
    }
  }
}
