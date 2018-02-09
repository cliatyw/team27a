/*[김기성]*/
package service;

public class Anaunseo {
	private int AnaunseoId;
	private String AnaunseoName;
	private int AnaunseoAge;
	public int getAnaunseoId() {
		return AnaunseoId;
	}
	public void setAnaunseoId(int anaunseoId) {
		AnaunseoId = anaunseoId;
	}
	public String getAnaunseoName() {
		return AnaunseoName;
	}
	public void setAnaunseoName(String anaunseoName) {
		AnaunseoName = anaunseoName;
	}
	public int getAnaunseoAge() {
		return AnaunseoAge;
	}
	public void setAnaunseoAge(int anaunseoAge) {
		AnaunseoAge = anaunseoAge;
	}
	//입력받은 값이 잘 들어왔나 확인하기 위한 방법 등 에 사용하기 위해 오버라이딩(toString)을 하였다.(단위테스트)
	@Override
	public String toString() {
		return "Anaunseo [AnaunseoId=" + AnaunseoId + ", AnaunseoName=" + AnaunseoName + ", AnaunseoAge=" + AnaunseoAge
				+ "]";
	}
}
