
public class MorseCode {
	private char ch;
	private String code;
	public MorseCode(char ch, String code) {
		int character = (int)ch; //Provides ASCII Value
		try {
			if((character >= 32) || (character <= 90)) {
				this.ch = ch;
			}
			else {
				throw new Exception();
			}
		}
		catch(Exception Ex) {
			System.out.printf("Out-of-range Character: %s%n",ch);
		}
		this.code = code;
	}
	
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
