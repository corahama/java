public enum Book{
  JHTP("Java how to program", "2015"),
  CHTP("C how to program", "2013"),
  IW3HTP("Internet & world wide web how to program", "2012"),
  CPPHTP("C++ how to program", "2014"),
  VBHTP("Visual basics how to program", "2014"),
  HSHARPHTP("C# how to program", "2014");

  private final String title, copyrightYear;

  Book(String title, String copyrightYear){
    this.title = title;
    this.copyrightYear = copyrightYear;
  }

  public String getTitle(){
    return title;
  }

  public String getCopyrightYear(){
    return copyrightYear;
  }
}
