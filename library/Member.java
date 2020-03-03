import java.util.ArrayList;

class Member {
  public String id;
  public String name;
  public ArrayList<Book> borrowedBooks = new ArrayList<Book>();
  
  //menerima book kedalam array list
  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }

  //mengeluarkan book dari member
  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }
}