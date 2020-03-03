import java.util.ArrayList;

class Library {
  public ArrayList<Book> books = new ArrayList<Book>();
  public ArrayList<Member> members = new ArrayList<Member>();

  //menambah member kedalam array list
  public void addMember(Member member) {
    this.members.add(member);
  }


  //looping mencari id member
  public Boolean isMemberIdExist(String id) {
    Boolean isExist = false;
    for (Member member : this.members) {
      if (member.id == id) {
        isExist = true;
      }
    }
    return isExist;
  }

  //meminjamkan buku apabila id buku dan id member ditemukan
  public void giveBook(String bookId, String memberId) {
    //mencari buku lalu meremove buku dari arraylist buku
    Book book = this.getBookById(bookId);
    this.books.remove(book);

    //mencari  nomer member dan index lalu 
    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.add(book);
  }

  public void receiveBook(String bookId, String memberId) {
    //menambahkan book kedalam array list books
    Book book = this.getBookById(bookId);
    this.books.add(book);

    //mencari nomer member dan index member, lalu menghilangkan dari member
    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.remove(book);
  }

  
  private int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  private Member getMemberById(String id) {
    for (Member member : this.members) {
      if (member.id.equals(id)) {
        return member;
      }
    }
    return null;
  }

  private Book getBookById(String id) {
    //for every book from arraylist books.
    for (Book book : this.books) {
      //if book.id equals id we need to return the book.
      if (book.id.equals(id)) {
        return book;
      }
    }
    return null;
  }
}