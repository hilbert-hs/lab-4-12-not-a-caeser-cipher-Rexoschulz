class Cipher {
  private String[][] letterBlock;
  private int numRows;
  private int numCols;

  // Constructor: parameters include number of rows, number of columns

  public Cipher(int r, int c) {
    numRows = r;
    numCols = c;
    letterBlock = new String[r][c];
  }

  // method fillBlock(): places a String into letterBlock in row major order
  // @param str: the String to be processed
  // POSTCONDITION: if str.length() < numRows * numCols, "A" is placed in each unfilled cell
  // POSTCONDITION: if str.length() > numRows * numCols, trailing characters are ignored

  private void fillBlock(String str) {
      for(int i=0; i< letterBlock.length; i++){
        for(int j=0; j < letterBlock[i].length; j++){
          if (str.length()> 0){
            letterBlock[i][j]= str.substring(0,1);
            str = str.substring(1,str.length());
          } else{
            letterBlock[i][j]="A";
          }
        }
      }
  }

  // method encryptBlock(): extracts encrypted message (cipher) from letterBlock in column major order
  // PRECONDITION: letterBlock has been filled
  // @return encrypted String from letterBlock

  private String encryptBlock() {
    String str = "";
    for(int i=0; i< letterBlock[0].length; i++){
        for(int j=0; j < letterBlock.length; j++){
            str += letterBlock[j][i];
        }
      }
    return str;
  }

  // method encryptMessage(): encrypts a message using methods fillBlock() and encryptBlock()
  // @param message: the String to be encrypted
  // @return the encrypted message
  // if message is an empty String, returns an empty string

  public String encryptMessage(String message) {
    String fin = "";
    while(message.length()>0){
      if (message.length()> numRows * numCols){
        fillBlock(message.substring(0, numRows * numCols));
        fin += encryptBlock();
        message = message.substring(numRows * numCols, message.length());
      } else{
        fillBlock(message.substring(0, message.length()));
        fin += encryptBlock();
        message = "";
      }
    }
    return fin;
  }
}
