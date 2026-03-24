class main {
  public static void main(String[] args) {
  //c
  // write code here to test your Cipher class.
  // when you're finished, replace your test code with
  // the tests I provided
  Cipher cipher1 = new Cipher(2, 5);
  System.out.println(cipher1.encryptMessage("Highschool"));

  System.out.println();

  Cipher cipher2 = new Cipher(3, 4);
  System.out.println(cipher2.encryptMessage("Highschool"));

  System.out.println();

  Cipher cipher3 = new Cipher(9, 4);
  System.out.println(cipher3.encryptMessage("Hilbert will win at state robotics."));


  }
}
